package Register;

import Base.BaseTestsLogin;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTestsLogin {
    @Test
    @Epic("User should be able to Register")
    @Feature("Register")
    @Description("Test user register ")
    @Severity(SeverityLevel.NORMAL)
    public void testSuccessfulRegister(){
        RegisterPage registerPage = homePage.clickRegister();
        registerPage.setEmail("daftarworker1@mailinator.com");
        registerPage.setPassword("Asdf1234");
        registerPage.setConfirmPassword("Asdf1234");
    }
}
