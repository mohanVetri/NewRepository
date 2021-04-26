package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
    public static JSONObject jsonObject=new JSONObject();
    @RequestMapping("/profile")
    public ModelAndView profilePage(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        jsonObject.clear();
        HttpSession session = request.getSession(false);
        ModelAndView modelAndView = new ModelAndView();
        jsonObject.put("session", session);
        modelAndView.setViewName("welcome.jsp");
        if (session != null) {
            String name=(String) session.getAttribute("name");
            jsonObject.put("name", name);
            jsonObject.put("message", "Welcome");
        } else {
            jsonObject.put("message", "Login First!!");
        }

        return modelAndView;
    }
}
