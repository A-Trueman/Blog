package com.controller;

import com.bo.Article;
import com.common.SystemConst;
import com.common.util.BeanConvertor;
import com.service.ArticleService;
import com.service.LikeService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Lincg on 2017/5/28.
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private LikeService likeService;

    @RequestMapping(value = "/article/*", method = RequestMethod.GET)
    public ModelAndView getArticle(HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        String username = (String) session.getAttribute("username");
        String uri = request.getRequestURI();
        String articleId = uri.substring(uri.lastIndexOf("/") + 1, uri.length() - 5);
        Article article = articleService.selectArticleById(articleId);
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
        modelAndView.setViewName("/article");
        modelAndView.addObject("username", username);
        modelAndView.addObject("article", BeanConvertor.convert2ArticleVo(article, Byte.valueOf("0")));

        if (username != null && !username.isEmpty()) {
            if (likeService.getLike(username, articleId, Byte.valueOf("1")) != null) {
                modelAndView.addObject("isCollected", true);
            }
        }
        return modelAndView;
    }

}
