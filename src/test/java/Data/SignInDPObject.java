package Data;

import org.testng.annotations.DataProvider;

public class SignInDPObject {
    @DataProvider(name = "signIn-provider")
    public static Object[][] signInData() {
        Object data[][] = {
                {"geelangtester@gmail.com", "321*sdfG", "true"},
                {"user", "321*sdfG", "false"},
                {"geelangtester@gmail.com", "password", "false"},
        };

        return data;
    }
}
