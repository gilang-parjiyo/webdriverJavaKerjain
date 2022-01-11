package Auth;

import Base.BaseTestsLogin;
import Data.SignInDPObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.MyJobsPage;

import static org.testng.Assert.assertEquals;

public class DDT_LoginTest extends BaseTestsLogin {
    private WebDriver driver;

    @Test(dataProviderClass = SignInDPObject.class, dataProvider = "signIn-provider")
    public void testLogin(String username, String password, boolean success) {
        var login = homePage.clickLogin();
        login.setEmail(username);
        login.setPassword(password);
        MyJobsPage myJobPage = login.clickLoginButton();

        System.out.println("Sign In Credentials: " + "\n" +
                " Username = " + username + "\n" +
                " Password = " + password + "\n" +
                " Successful Login = " + success + "\n");

        assertEquals(myJobPage.getHeading4Text(),
                "PEKERJAAN AKTIF ANDA",
                "Heading 4 Is Incorrect");
        myJobPage.clickLogOut();
    }
}
