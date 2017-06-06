package com.controller;

import com.bo.Like;
import com.bo.User;
import com.common.ICacheService;
import com.common.SystemConst;
import com.common.util.BeanConvertor;
import com.service.LikeService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Lincg on 2017/5/11.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private LikeService likeService;

    @Resource
    private ICacheService cacheService;

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("username", session.getAttribute("username"));
        String admin = "admin";
        String lastDateTime = request.getParameter("lastDateTime");
        String lessDateTime = request.getParameter("lessDateTime");
        String pageCount = request.getParameter("pageCount");
        String tag = request.getParameter("tag");
        List<Like> likes;
        if (tag == null || tag.isEmpty()) {
            likes = likeService.getLikeList(admin, lastDateTime, lessDateTime, Byte.valueOf("1"));
        } else {
            likes = likeService.getLikeTagList(admin, tag, lastDateTime, lessDateTime, Byte.valueOf("1"));
        }
        String key;
        long count = 0;
        for (Like article : likes){
            count = 0;
            key = "article:ReadCount:" + article.getId();
            if (cacheService.exists(key)) {
                count = (long)cacheService.getLong(key);
            }
            article.setReadCounts((int)count);
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
        List<String> tags = likeService.getTags(admin, Byte.valueOf("1"));
        modelAndView.addObject("tags", tags);
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    @RequestMapping("/user/login.html")
    public ModelAndView login(@RequestBody User user, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        if (userService.login(user.getUsername(), user.getPassword())) {
            session.setAttribute("username", user.getUsername());
            modelAndView.addObject("result","success");
        } else {
            modelAndView.addObject("result", "failed");
        }

        return modelAndView;
    }


    @RequestMapping("/user/register.html")
    @ResponseBody
    public String register(@RequestBody User user) {
        int result = userService.registerUser(user);
        return String.valueOf(result);
    }


    @RequestMapping("/user/logout")
    public ModelAndView logout(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username != null && !username.isEmpty()) {
            session.removeAttribute("username");
        }
        return new ModelAndView("redirect:/index");
    }
}
