import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.LogoutController;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

public class LogoutControllerTest {
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
        when(session.getAttribute("name")).thenReturn("Mohan");
    }

    @Test
    public void test_ModelAndView_WithSession() throws IOException, ServletException{
        ModelAndView expectedModelAndView=new ModelAndView();
        expectedModelAndView.setViewName("logoutPage.jsp");
        assertEquals(expectedModelAndView.toString(), new LogoutController().logouPage(requestWithSession, response).toString());
    }

    @Test
    public void test_ModelAndView_WithoutSession() throws IOException, ServletException{
        ModelAndView expectedModelAndView=new ModelAndView();
        expectedModelAndView.setViewName("logoutPage.jsp");
        assertEquals(expectedModelAndView.toString(), new LogoutController().logouPage(requestWithoutSession, response).toString());
    }

    @Test 
    public void test_Json_WithSession() throws IOException, ServletException{
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("session", session);
        jsonObject.put("name","Mohan");
        jsonObject.put("message", "You are successfully logged out!!");
        new LogoutController().logouPage(requestWithSession, response);
        assertEquals(jsonObject.toString(), LogoutController.jsonObject.toString());
    }

    @Test 
    public void test_Json_WithoutSession() throws IOException, ServletException{
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("session", requestWithoutSession.getSession(false));
        jsonObject.put("message", "Login First!!");
        new LogoutController().logouPage(requestWithoutSession, response);
        assertEquals(jsonObject.toString(), LogoutController.jsonObject.toString());
    }
}
