package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.bo.Article;
import com.common.ICacheService;
import com.common.SystemConst;
import com.common.util.BeanConvertor;
import com.common.util.BlogUtils;
import com.common.util.SFTPUtil;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import com.service.ArticleService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by Lincg on 2017/5/19.
 */

@Controller
public class MyBlogController {

    @Autowired
    private ArticleService articleService;

    @Resource
    private ICacheService cacheService;

    @RequestMapping("/myBlog.html")
    public ModelAndView getBlog(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/myBlog");
        modelAndView.addObject("username", session.getAttribute("username"));
        return modelAndView;
    }


    @RequestMapping(value = "/myBlogList.html",method = RequestMethod.GET)
    public ModelAndView getMyBlog(HttpSession session, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        String username = (String) session.getAttribute("username");
        String lastDateTime = request.getParameter("lastDateTime");
        String lessDateTime = request.getParameter("lessDateTime");
        String pageCount = request.getParameter("pageCount");
        String status = request.getParameter("status");
        String tag = request.getParameter("tag");
        if (status == null || status.isEmpty()) {
            status = "1";
        }
        List<Article> articles;
        if (tag == null || tag.isEmpty()) {
            articles = articleService.getUserArticleList(username, lastDateTime, lessDateTime, Byte.parseByte(status));
        } else {
            articles = articleService.getUserTagArticleList(username, tag, lastDateTime, lessDateTime, Byte.parseByte(status));
        }
        long count = 0;
        String key;
        for (Article article : articles){
            count = 0;
            key = "article:ReadCount:" + article.getId();
            if (cacheService.exists(key)) {
                count = (long)cacheService.getLong(key);
            }
            article.setReadCounts((int)count);
        }
        modelAndView.addObject("tag", tag);
        modelAndView.setViewName("/myBlogList");
        if (pageCount == null || pageCount.isEmpty()) {
            modelAndView.addObject("pageCount","1");
            modelAndView.addObject("lessDateTime", null);
            if (articles != null && !articles.isEmpty() && (articles.size() > SystemConst.PAGESIZE)) {
                articles.remove(articles.size() - 1);
                modelAndView.addObject("lastDateTime", articles.get(articles.size() - 1).getCreateTime());
            } else {
                modelAndView.addObject("lastDateTime", null);
            }
        } else {
            if (lastDateTime != null && !lastDateTime.isEmpty()) {
                modelAndView.addObject("pageCount", Integer.parseInt(pageCount) + 1);
                modelAndView.addObject("lessDateTime", lastDateTime);
                if (articles != null && !articles.isEmpty() && (articles.size() > SystemConst.PAGESIZE)) {
                    articles.remove(articles.size() - 1);
                    modelAndView.addObject("lastDateTime", articles.get(articles.size() - 1).getCreateTime());
                } else {
                    modelAndView.addObject("lastDateTime", null);
                }
            } else if (lessDateTime != null && !lessDateTime.isEmpty()){
                modelAndView.addObject("pageCount", Integer.parseInt(pageCount) - 1);
                modelAndView.addObject("lastDateTime", lessDateTime);
                if (articles != null && !articles.isEmpty() && (articles.size() > SystemConst.PAGESIZE)) {
                    articles.remove(articles.size() - 1);
                    modelAndView.addObject("lessDateTime", articles.get(articles.size() - 1).getCreateTime());
                } else {
                    modelAndView.addObject("lessDateTime", null);
                }
            }
        }

        modelAndView.addObject("articles",
                               BeanConvertor.convert2ArticleVos(articles, Byte.parseByte(status)));

        //查找标签
        List<Map<String, Object>> tagVos = articleService.selectTagsByUsername(username, Byte.parseByte(status));
        modelAndView.addObject("tagVos", tagVos);
        modelAndView.addObject("status", status);
        return modelAndView;
    }


    @RequestMapping(value = "/writeBlog.html", method = RequestMethod.GET)
    public ModelAndView writeBlog(HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/writeBlog");
        String id = request.getParameter("id");
        if (id != null && id.length() == 32) {
            Article article = articleService.selectArticleById(id);
            String initData = null;
            InputStream inputStream = null;
            try {
                URL url = new URL(SystemConst.MARKDOWN_URL + id + ".txt");
                URLConnection connection = url.openConnection();
                inputStream = connection.getInputStream();
                initData = IOUtils.toString(inputStream, "utf8");
                modelAndView.addObject("initData", initData);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            modelAndView.addObject("article", article);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/writeBlog.html", method = RequestMethod.POST)
    public String writeBlog(@RequestBody JSONObject data, HttpSession session) {
        String username = (String) session.getAttribute("username");
        String markdown = data.getString("editormd-markdown-doc");
        String html = data.getString("editormd-html-code");
        String preHtml = BlogUtils.html2Text(html).substring(0,128);
        String id = data.getString("id");
        if (id == null || id.isEmpty()) {
            id = BlogUtils.getUUID();
        }
        File htmlFile = new File(SystemConst.PATH + "html" + File.separator + id + ".htm");
        File sourceFile = new File(SystemConst.PATH + "markdown" + File.separator + id + ".txt");
        try {
            FileUtils.writeStringToFile(htmlFile, html, "utf8" );
            FileUtils.writeStringToFile(sourceFile, markdown, "utf8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!BlogUtils.getLocalHostIp().trim().equals("120.25.246.250")) {
            ChannelSftp sftp = null;
            Session ftpSession = null;
            try {
                ftpSession = SFTPUtil.connect(SystemConst.HOST, null, SystemConst.USER, SystemConst.PASSWORD);
                Channel channel = ftpSession.openChannel("sftp");
                channel.connect();
                sftp = (ChannelSftp) channel;
                SFTPUtil.upload(SystemConst.TARGETPATH + "/html", htmlFile, sftp);
                SFTPUtil.upload(SystemConst.TARGETPATH + "/markdown", sourceFile, sftp);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (sftp != null) {
                    sftp.disconnect();
                }
                if (ftpSession != null) {
                    ftpSession.disconnect();
                }
            }
            if (!htmlFile.delete()) {
                System.out.println("删除html文件" + id + "失败");
            }

            if (!sourceFile.delete()) {
                System.out.println("删除source文件"+ id +"失败");
            }
        }

        Article article = new Article();
        article.setId(id);
        article.setUsername(username);
        article.setTag(data.getString("tag"));
        article.setTitle(data.getString("title"));
        article.setCreateTime(BlogUtils.getTime());
        article.setPreArticle(preHtml);
        article.setStatus(data.getByte("status"));

        articleService.saveArticle(article);
        return "/writeBlog";
    }

    @RequestMapping("/myArticle/*")
    public ModelAndView getArticle(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String uri = request.getRequestURI();
        String articleId = uri.substring(uri.lastIndexOf("/") + 1);
        articleId = articleId.substring(0, articleId.length() - 5);
        Article article = articleService.selectArticleById(articleId);
        modelAndView.setViewName("/myArticle");
        String initData = null;
        InputStream inputStream = null;
        try {
            URL url = new URL(SystemConst.MARKDOWN_URL + articleId + ".txt");
            URLConnection connection = url.openConnection();
            inputStream = connection.getInputStream();
            initData = IOUtils.toString(inputStream, "utf8");
            modelAndView.addObject("initData", initData);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String key = "article:ReadCount:" + articleId;
        if (!cacheService.exists(key)) {
            long value = articleService.getReadCount(articleId);
            cacheService.setLong(key, value);
        }
        cacheService.increment(key);
        long count = (long)cacheService.getLong(key);
        article.setReadCounts((int)count);
        modelAndView.addObject("article", BeanConvertor.convert2ArticleVo(article, Byte.valueOf("1")));
        modelAndView.addObject("initData", initData);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteBlog", method = RequestMethod.GET)
    public ModelAndView deleteBlog(HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/myBlogList.html");
        String id = request.getParameter("id");
        if (id != null && id.length() == 32) {
            articleService.deleteArticle(id);
        }
        return modelAndView;
    }

}
