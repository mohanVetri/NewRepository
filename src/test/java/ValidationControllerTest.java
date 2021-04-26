import com.login.RegistrationDetails;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.RegistrationController;
import com.login.ValidationController;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

public class ValidationControllerTest {
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    HttpSession session;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(request.getParameter("userName")).thenReturn("Mohan");
        when(request.getParameter("password")).thenReturn("abc123");
        when(request.getSession()).thenReturn(session);
    }

    @After
    public void tearDown(){
        RegistrationController.list.clear();
    }

    @Test
    public void test_Json_EmptyList() throws IOException, ServletException{
        RegistrationController.list.clear();
        JSONObject expectedJsonObject= new JSONObject();
        expectedJsonObject.put("message", "Register First");
        new ValidationController().validation(request, response);
        assertEquals(expectedJsonObject.toString(), ValidationController.jsonObject.toString());
    }

    @Test
    public void test_Json_ListWithOneElement_ValidParameters() throws IOException, ServletException{
        RegistrationController.list.add(new RegistrationDetails("hello", "hello", "Mohan", "abc123", "abc@abc"));
        JSONObject expectedJsonObject= new JSONObject();
        new ValidationController().validation(request, response);
        assertEquals(expectedJsonObject.toString(), ValidationController.jsonObject.toString());
    }
    
    @Test
    public void test_Json_ListWithOneElement_InValidPassword() throws IOException, ServletException{
        RegistrationController.list.add(new RegistrationDetails("hello", "hello", "Mohan", "Abc123", "abc@abc"));
        JSONObject expectedJsonObject= new JSONObject();
        expectedJsonObject.put("message", "Invalid Password");
        new ValidationController().validation(request, response);
        assertEquals(expectedJsonObject.toString(), ValidationController.jsonObject.toString());
    }

    @Test
    public void test_ModelAndView_EmptyList() throws IOException, ServletException{
        RegistrationController.list.clear();
        ModelAndView expectedModelAndView=new ModelAndView();
        expectedModelAndView.setViewName("display.jsp");
        assertEquals(expectedModelAndView.toString(), new ValidationController().validation(request, response).toString());
    }

    @Test
    public void test_ModelAndView_ListWithOneElement_ValidParameters() throws IOException, ServletException{
        RegistrationController.list.add(new RegistrationDetails("hello", "hello", "Mohan", "abc123", "abc@abc"));
        ModelAndView expectedModelAndView=new ModelAndView();
        expectedModelAndView.setViewName("successful.jsp");
        assertEquals(expectedModelAndView.toString(),new ValidationController().validation(request, response).toString());
    }

    @Test
    public void test_ModelAndView_ListWithOneElement_InValidPassword() throws IOException, ServletException{
        RegistrationController.list.add(new RegistrationDetails("hello", "hello", "Mohan", "Abc123", "abc@abc"));
        ModelAndView expectedModelAndView=new ModelAndView();
        expectedModelAndView.setViewName("display.jsp");
        assertEquals(expectedModelAndView.toString(), new ValidationController().validation(request, response).toString());
    }

    @Test
    public void test_Session() throws IOException, ServletException{
        RegistrationController.list.add(new RegistrationDetails("hello", "hello", "Mohan", "abc123", "abc@abc"));
        new ValidationController().validation(request, response);
        verify(session,times(1)).setAttribute("name", request.getParameter("userName"));
    }
}
