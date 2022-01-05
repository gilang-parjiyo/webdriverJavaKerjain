package Data;

import org.testng.annotations.DataProvider;

public class SignInDP {
    @DataProvider(name = "signIn-provider")
    public static Object[][] signInData() {
        Object[][] data = new Object[3][3];

        data[0][0] = "geelangtester@gmail.com";
        data[0][1] = "321*sdfG";
        data[0][2] = false;

        data[1][0] = "geelangtester@gmail.com";
        data[1][1] = "321*sdfG";
        data[1][2] = true;

        data[2][0] = "admin";
        data[2][1] = "geelangtester@gmail.com";
        data[2][2] = false;

        return data;
    }
}
