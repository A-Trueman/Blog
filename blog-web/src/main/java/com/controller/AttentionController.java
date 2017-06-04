package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.bo.Article;
import com.bo.Attention;
import com.bo.Like;
import com.common.ICacheService;
import com.common.SystemConst;
import com.common.util.BeanConvertor;
import com.common.util.BlogUtils;
import com.service.ArticleService;
import com.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * Created by Lincg on 2017/5/29.
 */

@Controller
public class AttentionController {

    @Autowired
    private AttentionService attentionService;

    @Autowired
    private ArticleService articleService;

    @Resource
    private ICacheService cacheService;

    @RequestMapping(value = "/attention/paid")
    @ResponseBody
    public String payAttention(String authorName, HttpSession session) throws Exception {
        String username = (String) session.getAttribute("username");
        try {
            authorName = URLDecoder.decode(authorName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (username == null || username.isEmpty()) {
            throw (new Exception());
        }
        if (attentionService.isAttention(username, authorName) == 1) {
            throw (new Exception());
        } else {
            if(attentionService.saveAttention(username, authorName) == 1)
                return "1";
            else
                return "0";
        }
    }


    @RequestMapping(value = "/attention/cancel")
    @ResponseBody
    public String cancelAttention(String authorName, HttpSession session) throws Exception {
        String username = (String) session.getAttribute("username");
        if (username == null || username.isEmpty()) {
            throw (new Exception());
        }
        try {
            authorName = URLDecoder.decode(authorName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (attentionService.cancelAttention(username, authorName) != 1) {
            throw (new Exception());
        } else {
            return "1";
        }
    }


    @RequestMapping(value = "/attention", method = RequestMethod.GET)
    public ModelAndView getArticleList(HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String username = (String) session.getAttribute("username");
        String lastDateTime = request.getParameter("lastDateTime");
        String lessDateTime = request.getParameter("lessDateTime");
        String pageCount = request.getParameter("pageCount");
        List<String> authorNames = attentionService.getFollowee(username);
        List<Article> articles = articleService.getUsersArticles(authorNames, lastDateTime, lessDateTime, Byte.valueOf("1"));
        String key;
        long count = 0;
        for (Article article : articles){
            count = 0;
            key = "article:ReadCount:" + article.getId();
            if (cacheService.exists(key)) {
                count = (long)cacheService.getLong(key);
            }
            article.setReadCounts((int)count);
        }
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

        modelAndView.addObject("username", username);
        modelAndView.setViewName("/attention");
        return modelAndView;
    }
}
