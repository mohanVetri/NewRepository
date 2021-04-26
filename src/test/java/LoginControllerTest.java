import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.LoginController;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

public class LoginControllerTest {
    @Mock
    HttpServletRequest requestWithSession;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpServletRequest requestWithoutSession;

    @Mock
    HttpSession session;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(requestWithSession.getSession(false)).thenReturn(session);
        when(requestWithoutSession.getSession(false)).thenReturn(null);
    }


    @Test
    public void test_ModelAndViewWithSession() throws IOException{
        ModelAndView expectedModelAndView=new ModelAndView();
        expectedModelAndView.setViewName("login.jsp");
        assertEquals(expectedModelAndView.toString(),new LoginController().loginPage(requestWithSession, response).toString());
    }

    @Test
    public void test_ModelAndViewWithoutSession() throws IOException{
        ModelAndView expectedModelAndView=new ModelAndView();
        expectedModelAndView.setViewName("login.jsp");
        assertEquals(expectedModelAndView.toString(),new LoginController().loginPage(requestWithoutSession, response).toString());
    }

    @Test
    public void test_Json_WithoutSession() throws IOException{
        new LoginController().loginPage(requestWithoutSession, response);
        assertTrue(LoginController.jsonObject.isEmpty());
    }

    @Test
    public void test_Json_WithSession() throws IOException{
        JSONObject expectedJsonObject= new JSONObject();
        expectedJsonObject.put("session", requestWithSession.getSession(false));
        expectedJsonObject.put("message", "You are already logged in!!");
        new LoginController().loginPage(requestWithSession, response);
        assertEquals(expectedJsonObject.toString(), LoginController.jsonObject.toString());
    }
}
