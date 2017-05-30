package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.bo.Attention;
import com.common.util.BlogUtils;
import com.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by Lincg on 2017/5/29.
 */

@Controller
public class AttentionController {

    @Autowired
    private AttentionService attentionService;

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
}
