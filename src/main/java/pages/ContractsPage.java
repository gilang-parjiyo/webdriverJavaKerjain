package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContractsPage {

    private WebDriver driver;
    private By upload = By.id("fileAttach");
    private By startDateField = By.id("startDate");
    private By endDateField = By.id("dueDate");
    private By descriptionField = By.id("description");
    private By saveContract = By.cssSelector(".float-right");
    private By successCreateContract = By.cssSelector(".text-3xl");


    public ContractsPage(WebDriver driver){
        this.driver = driver;
    }

    private void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitLoadPage(){
        waitElement(saveContract);
    }

    public void attachFile(String path){
        driver.findElement(upload).sendKeys(path);
    }

    public void setStartDate(String date){
        driver.findElement(startDateField).sendKeys(date);
    }

    public void setDueDate(String date){
        driver.findElement(endDateField).sendKeys(date);
    }

    public void setDescription(String description){
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void saveContract(){
        driver.findElement(saveContract).click();
    }

    public String successCreateContractMessage(){
        waitElement(successCreateContract);
        return driver.findElement(successCreateContract).getText();
    }


}
