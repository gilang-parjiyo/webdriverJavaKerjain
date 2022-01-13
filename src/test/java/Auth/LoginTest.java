package Auth;

import Base.BaseTestsLogin;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyJobsPage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTestsLogin {

    @Test
    @Epic("User should be able login in login page")
    @Feature("This is a feature")
    @Description("Test user successful login ")
    @Severity(SeverityLevel.CRITICAL)
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setEmail("geelangtester@gmail.com");
        loginPage.setPassword("321*sdfG");

        MyJobsPage myJobPage = loginPage.clickLoginButton();
        assertEquals(myJobPage.getHeading4Text(),
                "PEKERJAAN AKTIF ANDA",
                "Heading 4 Is Incorrect");

        System.out.println("User successfully login");
    }

}
