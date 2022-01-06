package Data;

import org.testng.annotations.DataProvider;

public class SignInDP {
    @DataProvider(name = "signIn-provider")
    public static Object[][] signInData() {
        Object[][] data = new Object[3][3];

        data[0][0] = "geelangtester@gmail.com";
        data[0][1] = "321*sdfG";
        data[0][2] = true;

        data[1][0] = "geelangtester@gmail.com";
        data[1][1] = "password";
        data[1][2] = false;

        data[2][0] = "user";
        data[2][1] = "321*sdfG";
        data[2][2] = false;

        return data;
    }
}
