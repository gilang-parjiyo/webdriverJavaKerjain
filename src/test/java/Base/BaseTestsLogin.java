package Base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class BaseTestsLogin {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    @Parameters({"BrowserType"})
    public void setUp(String browserType) {
        if (browserType.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browserType.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.get("https://kerjain-team1.herokuapp.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void captureFailure(ITestResult result) {
        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
