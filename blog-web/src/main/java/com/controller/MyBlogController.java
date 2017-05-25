package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.bo.Article;
import com.common.SystemConst;
import com.common.util.BeanConvertor;
import com.common.util.BlogUtils;
import com.common.util.SFTPUtil;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import com.service.ArticleService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Lincg on 2017/5/19.
 */

@Controller
public class MyBlogController {

    @Autowired
    private ArticleService articleService;

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
        List<Article> articles = articleService.getUserArticleList(username, lastDateTime, lessDateTime, Byte.valueOf("1"));
        modelAndView.setViewName("/myBlogList");

        modelAndView.addObject("lessDateTime", lastDateTime);
        if (articles != null && !articles.isEmpty() && (articles.size() > SystemConst.PAGESIZE)) {
            articles.remove(articles.size() - 1);
            modelAndView.addObject("lastDateTime", articles.get(articles.size() - 1).getCreateTime());
        } else {
            modelAndView.addObject("lastDateTime", null);
        }
        modelAndView.addObject("articles",
                               BeanConvertor.convert2ArticleVos(articles, Byte.valueOf("1")));
        return modelAndView;
    }


    @RequestMapping(value = "/writeBlog.html", method = RequestMethod.GET)
    public String writeBlog(HttpSession session) {
        return "/writeBlog";
    }

    @RequestMapping(value = "/writeBlog.html", method = RequestMethod.POST)
    public String writeBlog(@RequestBody JSONObject data, HttpSession session) {
        String username = (String) session.getAttribute("username");
        String markdown = data.getString("editormd-markdown-doc");
        String html = data.getString("editormd-html-code");
        String preHtml = BlogUtils.html2Text(html).substring(0,128);
        String id = BlogUtils.getUUID();
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
        String url = request.getRequestURI();
        String articleId = url.substring(url.lastIndexOf("/") + 1);
        articleId = articleId.substring(0, articleId.length() - 1);
        Article article = articleService.selectArticleById(articleId);
        modelAndView.setViewName("/myArticle");
        modelAndView.addObject("article", BeanConvertor.convert2ArticleVo(article, Byte.valueOf("1")));
        return modelAndView;
    }


}
