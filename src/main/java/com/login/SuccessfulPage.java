package com.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SuccessfulPage {
    public static JSONObject jsonObject=new JSONObject();
    @RequestMapping("/success")
    public ModelAndView successful(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("successful.jsp");
        jsonObject.clear();
        HttpSession session=request.getSession(false);
        jsonObject.put("session", session);
        if(session!=null){
        String name=(String) session.getAttribute("name");
        jsonObject.put("name", name);
        jsonObject.put("message", "You are successfully logged in!!!");
        }
        else{
            jsonObject.put("message","Login First!!");
        }
        return modelAndView;
    }

}
