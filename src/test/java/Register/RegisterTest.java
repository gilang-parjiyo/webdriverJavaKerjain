package Register;

import Base.BaseTests;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTests {
    @Test
    public void testSuccessfulRegister(){
        RegisterPage registerPage = homePage.clickRegister();
        registerPage.setEmail("daftarworker1@mailinator.com");
        registerPage.setPassword("Asdf1234");
        registerPage.setConfirmPassword("Asdf1234");
    }
}
