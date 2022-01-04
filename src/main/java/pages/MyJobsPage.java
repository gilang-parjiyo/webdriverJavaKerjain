package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyJobsPage {
    private WebDriver driver;
    private By heading4 = By.xpath("//h4[text()='Pekerjaan Aktif Anda']");
    private By menuButton = By.xpath("//div[@class='inline-flex gap-2']");
    private By logoutButton = By.xpath("//div[.='Logout']");

    public MyJobsPage(WebDriver driver){
        this.driver = driver;
    }
    public String getHeading4Text (){
        return driver.findElement(heading4).getText();
    }

    public void clickLogOut(){
        driver.findElement(menuButton).click();
        driver.findElement(logoutButton).click();
    }

}
