import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.login.RegistrationDetails;

import org.junit.Test;

public class RegistrationDetailsTest {

        RegistrationDetails  registrationDetails=new RegistrationDetails("firstName", "lastName", "userName", "password", "emailId");

    @Test
    public void test_Object(){
        assertNotNull(registrationDetails);
    }

    @Test
    public void test_FirstName(){
        assertEquals("firstName",registrationDetails.firstName);
    }

    @Test
    public void test_lastName(){
        assertEquals("lastName",registrationDetails.lastName);
    }

    @Test
    public void test_userName(){
        assertEquals("userName",registrationDetails.userName);
    }

    @Test
    public void test_Password(){
        assertEquals("password",registrationDetails.password);
    }

    @Test
    public void test_EmailId(){
        assertEquals("emailId",registrationDetails.emailId);
    }
}
