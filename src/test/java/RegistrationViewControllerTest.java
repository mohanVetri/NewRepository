import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import com.login.RegistrationController;
import com.login.RegistrationViewController;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class RegistrationViewControllerTest {
    @Test
    public void test_Object(){
        RegistrationViewController registrationViewController =new RegistrationViewController();
        assertNotNull(registrationViewController);
    }

    @Test
    public void test_ModelAndView() throws IOException{
        ModelAndView expectedModelAndView = new ModelAndView();
        expectedModelAndView.setViewName("registration.jsp");
        assertEquals(expectedModelAndView.toString(),new RegistrationViewController().registrationView().toString());
    }

    @Test
    public void test_JsonObject() throws IOException{
        new RegistrationViewController().registrationView();
        assertTrue(RegistrationController.jsonObject.isEmpty());
    }
}
