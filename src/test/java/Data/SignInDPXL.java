package Data;

import org.testng.annotations.DataProvider;
import utils.XLUtils;
import java.io.IOException;

public class SignInDPXL {
    @DataProvider(name = "signIn-provider")
    public static Object[][] getData() throws IOException {

        //get the data from excel
        String path = "resources/data/loginData.xlsx";
        XLUtils xlutils = new XLUtils(path);

        int totalRows = xlutils.getRowCount("Sheet1");
        int totalCols = xlutils.getCellCount("Sheet1", 1);

        Object loginData[][] = new Object[totalRows][totalCols];


        for (int i = 1; i <= totalRows; i++) //1
        {
            for (int j = 0; j < totalCols; j++) //0
            {
                loginData[i - 1][j] = xlutils.getCellData("Sheet1", i, j);
            }

        }

        return loginData;
    }
}
