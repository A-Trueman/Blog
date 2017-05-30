package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Lincg on 2017/5/20.
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURI = httpServletRequest.getRequestURI();
        String[] allowPath = {"/index", "/blog/", "/user/", "/article/", "/allSite"};
        for (String path : allowPath) {
            if (requestURI.contains(path)) {
                return true;
            }
        }

        HttpSession session = httpServletRequest.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null || username.isEmpty()) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/index.html");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
