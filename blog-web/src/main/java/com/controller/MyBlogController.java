package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.bo.Article;
import com.common.SystemConst;
import com.common.util.BlogUtils;
import com.common.util.SFTPUtil;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import com.service.ArticleService;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Lincg on 2017/5/19.
 */

@Controller
public class MyBlogController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/myBlog.html")
    public String getBlog(HttpSession session){
        return "/myBlog";
    }


    @RequestMapping(value = "/myBlogList.html",method = RequestMethod.GET)
    public String getMyBlog(HttpSession session, HttpServletRequest request) {

        String username = (String) session.getAttribute("username");
        String lastDateTime = request.getParameter("lastDateTime");
        String lessDateTime = request.getParameter("lessDateTime");

        return "myBlogList";
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
        ChannelSftp sftp = null;
        Session ftpSession = null;
        try {
            ftpSession = SFTPUtil.connect(SystemConst.HOST, null, SystemConst.USER, SystemConst.PASSWORD);
            Channel channel = ftpSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            SFTPUtil.upload(SystemConst.TARGETPath + "/html", htmlFile, sftp);
            SFTPUtil.upload(SystemConst.TARGETPath + "/markdown", sourceFile, sftp);
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

}
