package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyJobsPage {
    private WebDriver driver;
    private By heading4 = By.xpath("//h4[text()='Pekerjaan Aktif Anda']");
    private By menuButton = By.xpath("//div[@class='inline-flex gap-2']");
    private By logoutButton = By.xpath("//div[.='Logout']");
    private By profileButton = By.xpath("//div[.='Setting Profile']");
    private By workerListingButton = By.cssSelector(".mx-2 > div:nth-of-type(2)");
    private By workerDashboard = By.xpath("//li[.='MyBoard']");

    public MyJobsPage(WebDriver driver) {
        this.driver = driver;
    }

    private void waitElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getHeading4Text() {
        waitElement(heading4);
        return driver.findElement(heading4).getText();
    }

    public String loadMyJobHire(){
        waitElement(workerDashboard);
        return driver.findElement(workerDashboard).getText();
    }

    public void clickLogOut() {
        driver.findElement(menuButton).click();
        driver.findElement(logoutButton).click();
    }

    public ProfilePage clickProfile() {
        driver.findElement(menuButton).click();
        driver.findElement(profileButton).click();
        return new ProfilePage(driver);
    }

    public void waitLogOutDisappear(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(menuButton));
    }

    public String getLink(){
        return driver.getCurrentUrl();
    }

    public WorkersPage clickWorkerListing(){
        driver.findElement(workerListingButton).click();
        return new WorkersPage(driver);
    }

}
