package com.controller;

import com.bo.Article;
import com.common.SystemConst;
import com.common.util.BeanConvertor;
import com.service.ArticleService;
import com.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Created by Lincg on 2017/5/29.
 */
@Controller
public class UserController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private AttentionService attentionService;

    @RequestMapping(value = "/blog/*", method = RequestMethod.GET)
    public ModelAndView getUserBlog(HttpSession session, HttpServletRequest request) {
        String username = (String) session.getAttribute("username");
        String uri = request.getRequestURI();
        String authorName = uri.substring(uri.lastIndexOf("/") + 1, uri.length() - 5);
        try {
            authorName = URLDecoder.decode(authorName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();

        if (authorName == null) {
            modelAndView.setViewName("redirect:/index");
            return modelAndView;
        }
        if (username != null && !username.isEmpty()) {
            if (username.equals(authorName)) {
                modelAndView.setViewName("redirect:/myBlog");
                return modelAndView;
            }
        }
        String lastDateTime = request.getParameter("lastDateTime");
        String lessDateTime = request.getParameter("lessDateTime");
        String pageCount = request.getParameter("pageCount");
        String tag = request.getParameter("tag");
        List<Article> articles;
        if (tag == null || tag.isEmpty()) {
            articles = articleService.getUserArticleList(authorName, lastDateTime, lessDateTime, Byte.valueOf("1"));
        } else {
            articles = articleService.getUserTagArticleList(authorName, tag, lastDateTime, lessDateTime, Byte.valueOf("1"));
        }
        modelAndView.addObject("tag", tag);
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
                BeanConvertor.convert2ArticleVos(articles, Byte.valueOf("0")));
        modelAndView.addObject("authorName", authorName);
        //查找标签
        List<Map<String, Object>> tagVos = articleService.selectTagsByUsername(authorName, Byte.valueOf("1"));
        modelAndView.addObject("tagVos", tagVos);
        modelAndView.addObject("username", username);
        if (username != null && !username.isEmpty()) {
            if (attentionService.isAttention(username, authorName) == 1) {
                modelAndView.addObject("isAttention", true);
            }
        }
        modelAndView.setViewName("/userBlogList");

        return modelAndView;
    }
}
