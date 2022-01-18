package Auth;

import Base.BaseTestsLogin;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyJobsPage;

import static org.testng.Assert.assertEquals;

public class LoginHireTest extends BaseTestsLogin {

    @Test
    @Epic("User should be able login in login page")
    @Feature("This is a feature")
    @Description("Test user successful login ")
    @Severity(SeverityLevel.CRITICAL)
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setEmail("testhire10@mailinator.com");
        loginPage.setPassword("Asdf1234!");

        MyJobsPage myJobPage = loginPage.clickLoginButton();
        assertEquals(myJobPage.loadMyJobHire(),
                "MyBoard",
                "Dashboard hire loaded");

        System.out.println("Hire successfully login");
    }

}
