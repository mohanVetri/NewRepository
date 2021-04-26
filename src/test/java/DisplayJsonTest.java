import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.login.*;
import com.login.DisplayJson;
import com.login.ValidationController;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DisplayJsonTest {

    @Mock
    HttpServletResponse response;
    
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void test_Object(){
        DisplayJson displayJson=new DisplayJson();
        assertNotNull(displayJson);
    }

    @Test
    public void test_displayJson() throws IOException, ParseException{
        ValidationController.jsonObject.put("hello", "I am here");
        assertEquals( "{\"hello\":\"I am here\"}",new DisplayJson().display_Json(response));
        ValidationController.jsonObject.clear();
    }

    @Test
    public void test_loginJson() throws IOException, ParseException{
        LoginController.jsonObject.put("hello", "I am here");
        assertEquals( "{\"hello\":\"I am here\"}",new DisplayJson().login_Json(response));
        LoginController.jsonObject.clear();
    }

    @Test
    public void test_logoutJson() throws IOException, ParseException{
        LogoutController.jsonObject.put("hello", "I am here");
        assertEquals( "{\"hello\":\"I am here\"}",new DisplayJson().logout_Json(response));
        LogoutController.jsonObject.clear();
    }

    @Test
    public void test_registerJson() throws IOException, ParseException{
        RegistrationController.jsonObject.put("hello", "I am here");
        assertEquals( "{\"hello\":\"I am here\"}",new DisplayJson().register_Json(response));
        RegistrationController.jsonObject.clear();
    }

    @Test
    public void test_successJson() throws IOException, ParseException{
        SuccessfulPage.jsonObject.put("hello", "I am here");
        assertEquals( "{\"hello\":\"I am here\"}",new DisplayJson().success_Json(response));
        SuccessfulPage.jsonObject.clear();
    }

    @Test
    public void test_welcomeJson() throws IOException, ParseException{
        ProfileController.jsonObject.put("hello", "I am here");
        assertEquals( "{\"hello\":\"I am here\"}",new DisplayJson().welcome_Json(response));
        ProfileController.jsonObject.clear();
    }
}
