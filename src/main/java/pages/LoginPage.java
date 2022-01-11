package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private By emailField = By.xpath("//*/input[@name='email']");
    private By passwordField = By.xpath("//*/input[@name='password']");
    private By loginButton = By.xpath("//button[text()='LOGIN']");
    private By forgotPassword = By.linkText("Forgot Password?");

    public  LoginPage (WebDriver driver){
        this.driver = driver;
    }
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public MyJobsPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new MyJobsPage(driver);
    }
    public ForgotPasswordPage clickForgotPasswordButton(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPassword));
        driver.findElement(forgotPassword).click();
        return new ForgotPasswordPage(driver);
    }

}
