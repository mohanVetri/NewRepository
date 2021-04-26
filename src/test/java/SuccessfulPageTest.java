import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.SuccessfulPage;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

public class SuccessfulPageTest {
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
        when(session.getAttribute("name")).thenReturn("UserName");
    }

    @Test
    public void test_ModelAndView_WithSession() throws IOException, ServletException{
        ModelAndView expectedModelAndView= new ModelAndView();
        expectedModelAndView.setViewName("successful.jsp");
        assertEquals(expectedModelAndView.toString(),new SuccessfulPage().successful(requestWithSession, response).toString());
    }

    @Test
    public void test_ModelAndView_WithoutSession() throws IOException, ServletException{
        ModelAndView expectedModelAndView= new ModelAndView();
        expectedModelAndView.setViewName("successful.jsp");
        assertEquals(expectedModelAndView.toString(),new SuccessfulPage().successful(requestWithoutSession, response).toString());
    }

    @Test
    public void test_Json_WithSession() throws IOException, ServletException{
        JSONObject expectedJsonObject=new JSONObject();
        expectedJsonObject.put("session", requestWithSession.getSession(false));
        expectedJsonObject.put("message","You are successfully logged in!!!");
        expectedJsonObject.put("name","UserName");
        new SuccessfulPage().successful(requestWithSession, response);
        assertEquals(expectedJsonObject.toString(), SuccessfulPage.jsonObject.toString());
    }

    @Test
    public void test_Json_WithoutSession() throws IOException, ServletException{
        JSONObject expectedJsonObject=new JSONObject();
        expectedJsonObject.put("session", requestWithoutSession.getSession(false));
        expectedJsonObject.put("message","Login First!!");
        new SuccessfulPage().successful(requestWithoutSession, response);
        assertEquals(expectedJsonObject.toString(), SuccessfulPage.jsonObject.toString());
    }

    @Test
    public void test_Session() throws IOException, ServletException{
        new SuccessfulPage().successful(requestWithSession, response);
        verify(session,times(1)).getAttribute("name");
    }
}
