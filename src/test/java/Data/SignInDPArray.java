package Data;

import org.testng.annotations.DataProvider;

public class SignInDPArray {
    @DataProvider(name = "signIn-provider")
    public static Object[][] signInData() {
        Object[][] data = new Object[3][3];

        data[0][0] = "geelangtester@gmail.com";
        data[0][1] = "321*sdfG";
        data[0][2] = true;

        data[1][0] = "user";
        data[1][1] = "321*sdfG";
        data[1][2] = false;

        data[2][0] = "geelangtester@gmail.com";
        data[2][1] = "password";
        data[2][2] = false;

        return data;
    }
}
