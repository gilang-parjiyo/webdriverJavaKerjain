package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By emailField = By.name("email");
    private By sendButton = By.xpath("//button[text()='SEND']");
    private By successMessage = By.cssSelector(".text-3xl");
    private By homeImage = By.xpath("//img[@alt='hero']");


    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void sendForgotEmail() {
        driver.findElement(sendButton).click();
    }

    public String getMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).getText();
    }

    public HomePage goHomePage(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeImage));
        return new HomePage(driver);
    }

}
