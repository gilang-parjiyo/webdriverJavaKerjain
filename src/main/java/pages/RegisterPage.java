package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By confirmPasswordField = By.name("confirmPassword");
    private By employerToggle = By.xpath("//input[@data-testid='role-employer']");
    private By workerToggle = By.xpath("//input[@data-testid='role-worker']");
    private By registerButton = By.xpath("//button[text()='REGISTER']");

    public RegisterPage (WebDriver driver){
        this.driver = driver;
    }
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void setConfirmPassword(String confirmPassword){
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

}
