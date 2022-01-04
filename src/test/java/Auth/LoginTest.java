package Auth;

import Base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyJobsPage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setEmail("geelangtester@gmail.com");
        loginPage.setPassword("321*sdfG");
        MyJobsPage myJobPage = loginPage.clickLoginButton();
        assertEquals(myJobPage.getHeading4Text(),
                "PEKERJAAN AKTIF ANDA",
                "Heading 4 Is Incorrect");
    }
}
