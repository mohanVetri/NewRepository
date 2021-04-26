package com.login;

// import java.io.FileWriter;
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
public class ValidationController {

    public static JSONObject jsonObject = new JSONObject();
 
    @RequestMapping("/validate")
    public ModelAndView validation(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        String name = request.getParameter("userName");
        String password = request.getParameter("password");
        ModelAndView modelAndView = new ModelAndView();
        boolean notExist = true;
        jsonObject.clear();
        if (!RegistrationController.list.isEmpty()) {
            for (RegistrationDetails details : RegistrationController.list) {
                if (name.equals(details.userName)) {
                    notExist=false;
                    break;
                }
            }
        }
        if (notExist) {
            modelAndView.setViewName("display.jsp");
            jsonObject.put("message", "Register First");
        } else {
            for (RegistrationDetails details : RegistrationController.list) {
                if (name.equals(details.userName)) {
                    if (password.equals(details.password)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("name", name);
                        modelAndView.setViewName("successful.jsp");
                        response.sendRedirect("success");
                    } else {
                        modelAndView.setViewName("display.jsp");
                        jsonObject.put("message", "Invalid Password");
                    }
                }
            }
        }
        return modelAndView;
    }
}
