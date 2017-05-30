package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.bo.Article;
import com.bo.Like;
import com.common.util.BeanConvertor;
import com.common.util.BlogUtils;
import com.service.ArticleService;
import com.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Lincg on 2017/5/29.
 */
@Controller
public class LikeController {

    @Autowired
    ArticleService articleService;

    @Autowired
    LikeService likeService;

    @RequestMapping(value = "/like/collect", method = RequestMethod.POST)
    @ResponseBody
    public String collectArticle(@RequestBody JSONObject json, HttpSession session) throws Exception {
        String articleId = json.getString("articleId");
        String username = (String) session.getAttribute("username");
        if (username == null || username.isEmpty()) {
            throw (new Exception());
        }
        Article article = articleService.selectArticleById(articleId);
        Like like = BeanConvertor.converArticle2Like(article);
        like.setId(BlogUtils.getUUID());
        like.setUsername(username);
        like.setStatus(Byte.valueOf("1"));
        like.setCreateTime(BlogUtils.getTime());
        if (likeService.saveLike(like) == 1) {
            return "1";
        } else {
            return "0";
        }
    }


    @RequestMapping(value = "/like/cancelCollect", method = RequestMethod.POST)
    @ResponseBody
    public String deleteLike(@RequestBody JSONObject json, HttpSession session) throws Exception {
        String articleId = json.getString("articleId");
        String username = (String) session.getAttribute("username");
        if (username == null || username.isEmpty()) {
            throw (new Exception());
        }
        if (likeService.deleteLike(username, articleId) == 1)
            return "1";
        else
            return "0";
    }
}
