package com.login;

// import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    
    public static JSONObject jsonObject=new JSONObject();


    @RequestMapping("/login")
    public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
        jsonObject.clear();
        HttpSession session=request.getSession(false);
        jsonObject.put("session", session);
        ModelAndView modelAndView =new ModelAndView();
        if(session!=null){
        jsonObject.put("message", "You are already logged in!!");
        }
        modelAndView.setViewName("login.jsp");
        return modelAndView;
    }
}
