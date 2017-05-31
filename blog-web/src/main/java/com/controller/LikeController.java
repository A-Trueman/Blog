package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.bo.Article;
import com.bo.Like;
import com.common.SystemConst;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        Like like = BeanConvertor.convertArticle2Like(article);
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

    @RequestMapping(value = "/like", method = RequestMethod.GET)
    public ModelAndView getLikeList(HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String username = (String) session.getAttribute("username");
        String lastDateTime = request.getParameter("lastDateTime");
        String lessDateTime = request.getParameter("lessDateTime");
        String pageCount = request.getParameter("pageCount");
        String tag = request.getParameter("tag");
        List<Like> likes;
        if (tag == null || tag.isEmpty()) {
            likes = likeService.getLikeList(username, lastDateTime, lessDateTime, Byte.valueOf("1"));
        } else {
            likes = likeService.getLikeTagList(username, tag, lastDateTime, lessDateTime, Byte.valueOf("1"));
        }
        modelAndView.addObject("tag", tag);
        if (pageCount == null || pageCount.isEmpty()) {
            modelAndView.addObject("pageCount","1");
            modelAndView.addObject("lessDateTime", null);
            if (likes != null && !likes.isEmpty() && (likes.size() > SystemConst.PAGESIZE)) {
                likes.remove(likes.size() - 1);
                modelAndView.addObject("lastDateTime", likes.get(likes.size() - 1).getCreateTime());
            } else {
                modelAndView.addObject("lastDateTime", null);
            }
        } else {
            if (lastDateTime != null && !lastDateTime.isEmpty()) {
                modelAndView.addObject("pageCount", Integer.parseInt(pageCount) + 1);
                modelAndView.addObject("lessDateTime", lastDateTime);
                if (likes != null && !likes.isEmpty() && (likes.size() > SystemConst.PAGESIZE)) {
                    likes.remove(likes.size() - 1);
                    modelAndView.addObject("lastDateTime", likes.get(likes.size() - 1).getCreateTime());
                } else {
                    modelAndView.addObject("lastDateTime", null);
                }
            } else if (lessDateTime != null && !lessDateTime.isEmpty()){
                modelAndView.addObject("pageCount", Integer.parseInt(pageCount) - 1);
                modelAndView.addObject("lastDateTime", lessDateTime);
                if (likes != null && !likes.isEmpty() && (likes.size() > SystemConst.PAGESIZE)) {
                    likes.remove(likes.size() - 1);
                    modelAndView.addObject("lessDateTime", likes.get(likes.size() - 1).getCreateTime());
                } else {
                    modelAndView.addObject("lessDateTime", null);
                }
            }
        }

        modelAndView.addObject("articles",
                               BeanConvertor.convertLikes2ArticleVos(likes));

        //查找标签
        List<String> tags = likeService.getTags(username, Byte.valueOf("1"));
        modelAndView.addObject("tags", tags);
        modelAndView.addObject("username", username);
        modelAndView.setViewName("/like");
        return modelAndView;
    }
}
