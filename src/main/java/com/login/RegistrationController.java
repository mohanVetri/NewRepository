package com.login;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    public static JSONObject jsonObject=new JSONObject();
    public static List <RegistrationDetails> list= new LinkedList<RegistrationDetails>();
    @RequestMapping("/registration")
    public ModelAndView registerDetails(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String email=request.getParameter("emailId");
        ModelAndView modelAndView=new ModelAndView();
        boolean notExist=true;
        if(!list.isEmpty()){
            for(RegistrationDetails details: list){
                if(userName.equals(details.userName)){
                    jsonObject.put("message", "UserName is Already existed");
                    notExist=false;
                }
                else if (email.equals(details.emailId)){
                    jsonObject.put("message", "EmailId is Already existed");
                    notExist=false;
                }
            }
        }
        if(notExist){
            list.add(new RegistrationDetails(firstName,lastName,userName,password,email));
            jsonObject.put("message", "You are successfully registered!!.Now You can login with your UserName and Password");
        }
        modelAndView.setViewName("registration.jsp");
        return modelAndView;
    }
}