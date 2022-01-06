package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By emailField = By.xpath("//*/input[@name='email']");
    private By passwordField = By.xpath("//*/input[@name='password']");
    private By loginButton = By.xpath("//button[text()='LOGIN']");

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

}
