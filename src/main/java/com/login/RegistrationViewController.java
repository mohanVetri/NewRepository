package com.login;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationViewController {
    
    @RequestMapping("/registrationView")
    public ModelAndView registrationView() throws IOException{
        ModelAndView modelAndView=new ModelAndView();
        RegistrationController.jsonObject.clear();
        modelAndView.setViewName("registration.jsp");
        return modelAndView;
    }
}
