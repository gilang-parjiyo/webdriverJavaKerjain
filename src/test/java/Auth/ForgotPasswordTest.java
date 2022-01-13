package Auth;

import Base.BaseTestsLogin;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;


public class ForgotPasswordTest extends BaseTestsLogin {

    @Test
    @Epic("Kerjain ui automation")
    @Feature("Forgot Password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User should be able receive email forgot password")
    @Description("User send email forgot password")
    public void testForgotPassword(){
        LoginPage loginPage = homePage.clickLogin();
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPasswordButton();
        forgotPasswordPage.setEmail("geelangtester@gmail.com");
        forgotPasswordPage.sendForgotEmail();

        Assert.assertEquals(forgotPasswordPage.getMessage(), "Request success", "Text message is invalid");

        HomePage homePage = forgotPasswordPage.goHomePage();
        Assert.assertEquals(homePage.getLink(), "https://kerjain-team1.herokuapp.com/", "Link is invalid");

        System.out.println("User successfully forget password");

    }


}
