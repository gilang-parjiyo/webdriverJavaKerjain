package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private By Login = By.xpath("//button[text()='Login']");
    private By Register = By.xpath("//button[text()='Join Us']");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage clickLogin(){
        driver.findElement(Login).click();
        return new LoginPage(driver);
    }
    public RegisterPage clickRegister(){
        driver.findElement(Register).click();
        return new RegisterPage(driver);
    }

    public String getLink(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Login));
        return driver.getCurrentUrl();
    }

    public MyJobsPage myJobsPageReturnDriver(){
        return new MyJobsPage(driver);
    }

}
