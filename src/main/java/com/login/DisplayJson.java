package com.login;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisplayJson {
    @RequestMapping(value = "/displayJson", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String display_Json(HttpServletResponse response) throws IOException, ParseException{
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
        return ValidationController.jsonObject.toString();
    }

    @RequestMapping(value = "/loginJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String login_Json(HttpServletResponse response) throws IOException, ParseException{
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
        return LoginController.jsonObject.toString();
    }

    @RequestMapping(value="/logoutJson" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String logout_Json(HttpServletResponse response) throws IOException, ParseException {
        // FileReader reader=new FileReader("C:\\Users\\User\\VisualStudioCode\\LoginUsingSpringMVC\\src\\main\\webapp\\logout.json");
        // JSONParser parser=new JSONParser();
        // Object object=parser.parse(reader);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
        return LogoutController.jsonObject.toString();
    }

    @RequestMapping(value = "/registerJson",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String register_Json(HttpServletResponse response) throws IOException, ParseException{
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
        return RegistrationController.jsonObject.toString();
    }

    @RequestMapping(value = "/successJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String success_Json(HttpServletResponse response) throws IOException, ParseException{
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
        return SuccessfulPage.jsonObject.toString();
    }

    @RequestMapping(value = "/welcomeJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String welcome_Json(HttpServletResponse response) throws IOException, ParseException{
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
        return ProfileController.jsonObject.toString();
    }

}
