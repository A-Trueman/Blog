package com.controller;

import com.bo.Article;
import com.common.SystemConst;
import com.common.util.BeanConvertor;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Lincg on 2017/6/2.
 */
@Controller
public class SearchController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ModelAndView getSearchResult(HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        String username = (String) session.getAttribute("username");
        String searchCond = request.getParameter("searchCond");
        if (searchCond != null && !searchCond.isEmpty()) {
            session.setAttribute("searchCond", searchCond);
        } else {
            searchCond = (String) session.getAttribute("searchCond");
        }
        String lastDateTime = request.getParameter("lastDateTime");
        String lessDateTime = request.getParameter("lessDateTime");
        String pageCount = request.getParameter("pageCount");
        List<Article> articles;
        articles = articleService.getArticleListByCond(searchCond, lastDateTime, lessDateTime, Byte.valueOf("1"));
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

        //查找标签
        List<String> tags = articleService.getTags(Byte.valueOf("1"));
        modelAndView.addObject("tags", tags);
        modelAndView.addObject("username", username);
        modelAndView.setViewName("/search");
        return modelAndView;
    }
}
