import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.RegistrationController;
import com.login.RegistrationDetails;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

public class RegistrationControllerTest {
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(request.getParameter("firstName")).thenReturn("Mohan");
        when(request.getParameter("lastName")).thenReturn("Raj");
        when(request.getParameter("userName")).thenReturn("Mohanraj123");
        when(request.getParameter("password")).thenReturn("abc123");
        when(request.getParameter("emailId")).thenReturn("abc@123");
    }

    @After
    public void tearDown(){
        RegistrationController.list.clear();
    }

    @Test
    public void test_Json_EmptyList() throws IOException{
        new RegistrationController().registerDetails(request, response);
        JSONObject expectedjsonObject=new JSONObject();
        expectedjsonObject.put("message", "You are successfully registered!!.Now You can login with your UserName and Password");
        assertEquals(expectedjsonObject.toString(), RegistrationController.jsonObject.toString());
    }

    @Test
    public void test_Json_WithoutSameParameters() throws IOException {
        RegistrationController.list.add(new RegistrationDetails("Mohan", "Raj", "mohan", "password", "emailId"));
        JSONObject expectedjsonObject=new JSONObject();
        expectedjsonObject.put("message", "You are successfully registered!!.Now You can login with your UserName and Password");
        new RegistrationController().registerDetails(request, response);
        assertEquals(expectedjsonObject.toString(), RegistrationController.jsonObject.toString());
    }

    @Test
    public void test_Json_SameUserName() throws IOException{
        RegistrationController.list.add(new RegistrationDetails("Mohan", "Raj", "Mohanraj123", "password", "abc"));
        JSONObject expectedJsonObject=new JSONObject();
        expectedJsonObject.put("message", "UserName is Already existed");
        new RegistrationController().registerDetails(request, response);
        assertEquals(expectedJsonObject.toString(),RegistrationController.jsonObject.toString());
    }

    @Test
    public void test_Json_SameEmailId() throws IOException{
        RegistrationController.list.add(new RegistrationDetails("Mohan", "Raj", "mohan", "password", "abc@123"));
        JSONObject expectedJsonObject=new JSONObject();
        expectedJsonObject.put("message", "EmailId is Already existed");
        new RegistrationController().registerDetails(request, response);
        assertEquals(expectedJsonObject.toString(),RegistrationController.jsonObject.toString());

    }

    @Test
    public void test_ModelAndView_Empty() throws IOException{
        ModelAndView expectedModelAndView=new ModelAndView();
        expectedModelAndView.setViewName("registration.jsp");
        assertEquals(expectedModelAndView.toString(), new RegistrationController().registerDetails(request, response).toString());
    }

    @Test
    public void test_ModelAndView_WithoutSameParameter() throws IOException{
        RegistrationController.list.add(new RegistrationDetails("Mohan", "Raj", "mohan", "password", "emailId"));
        ModelAndView expectedModelAndView=new ModelAndView();
        expectedModelAndView.setViewName("registration.jsp");
        assertEquals(expectedModelAndView.toString(), new RegistrationController().registerDetails(request, response).toString());
    }

    @Test
    public void test_ModelAndView_SameUserName() throws IOException{
        RegistrationController.list.add(new RegistrationDetails("Mohan", "Raj", "Mohanraj123", "password", "emailId"));
        ModelAndView expectedModelAndView=new ModelAndView();
        expectedModelAndView.setViewName("registration.jsp");
        assertEquals(expectedModelAndView.toString(), new RegistrationController().registerDetails(request, response).toString());
    }

    @Test
    public void test_ModelAndView_SamePassword() throws IOException{
        RegistrationController.list.add(new RegistrationDetails("Mohan", "Raj", "mohan", "password", "abc@123"));
        ModelAndView expectedModelAndView=new ModelAndView();
        expectedModelAndView.setViewName("registration.jsp");
        assertEquals(expectedModelAndView.toString(), new RegistrationController().registerDetails(request, response).toString());
    }

    @Test
    public void test_ListSize_EmptyList() throws IOException{
        new RegistrationController().registerDetails(request, response);
        assertEquals(1, RegistrationController.list.size());
    }

    @Test
    public void test_ListSize_WithoutSameParameter() throws IOException{
        RegistrationController.list.add(new RegistrationDetails("Mohan", "Raj", "mohan", "password", "emailId"));
        new RegistrationController().registerDetails(request, response);
        assertEquals(2, RegistrationController.list.size());
    }

    @Test
    public void test_ListSize_SameUserName() throws IOException{
        RegistrationController.list.add(new RegistrationDetails("Mohan", "Raj", "Mohanraj123", "password", "emailId"));
        new RegistrationController().registerDetails(request, response);
        assertEquals(1, RegistrationController.list.size());
    }

    @Test
    public void test_ListSize_SamePassword() throws IOException{
        RegistrationController.list.add(new RegistrationDetails("Mohan", "Raj", "mohan", "password", "abc@123"));
        new RegistrationController().registerDetails(request, response);
        assertEquals(1, RegistrationController.list.size());
    }
}
