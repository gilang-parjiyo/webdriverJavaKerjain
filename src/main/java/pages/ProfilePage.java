package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private WebDriver driver;

    /**
     * Object repository
     */
    private By fullNameField = By.id("fullName");
    private By emailField = By.id("emailAddress");
    private By dateOfBirth = By.xpath("//input[@id='dateOfBirth']");
    private By jobSeniority = By.id("jobSeniority");
    private By ratePerDay = By.id("ratePerDay");
    private By imageProfile = By.xpath("//input[@id='imageProfile']");
    private By chooseSpeciality = By.cssSelector("[placeholder='Choose a specialty...']");
    private By chooseCity = By.cssSelector("[placeholder='Choose a city...']");
    private By updateProfileButton = By.xpath("//button[text()='Update Profile']");
    private By messageSuccessUpdateProfile = By.cssSelector(".text-3xl");
    private By companyNameField = By.id("companyName");

    /**
     * Constructor profile page conatin of driver
     *
     * @param driver
     */
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void setCompanyName(String name) {
        waitElement(companyNameField);
        driver.findElement(companyNameField).clear();
        driver.findElement(companyNameField).sendKeys(name);
    }

    public void setFullName(String fullName) {
        driver.findElement(fullNameField).clear();
        driver.findElement(fullNameField).sendKeys(fullName);
    }

    public void setDateOfBirth(String DOB) {
        driver.findElement(dateOfBirth).clear();
        driver.findElement(dateOfBirth).sendKeys(DOB);
    }

    public void setJobSeniority(String years) {
        driver.findElement(jobSeniority).clear();
        driver.findElement(jobSeniority).sendKeys(years);
    }

    public void setRatePerDay(String rate) {
        driver.findElement(ratePerDay).clear();
        driver.findElement(ratePerDay).sendKeys(rate);
    }

    public void setImageProfile(String path) {
        driver.findElement(imageProfile).clear();
        driver.findElement(imageProfile).sendKeys(path);
    }

    public void selectJobSpeciality(String option) {
        driver.findElement(chooseSpeciality).clear();
        driver.findElement(chooseSpeciality).sendKeys(option, Keys.ARROW_DOWN, Keys.ENTER);

    }

    public void selectCity(String option) {
        driver.findElement(chooseCity).clear();
        driver.findElement(chooseCity).sendKeys(option, Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void clickUpdateProfileButton() {
        driver.findElement(updateProfileButton).click();
    }

    public String getMessageUpdateProfile() {
        waitElement(messageSuccessUpdateProfile);
        return driver.findElement(messageSuccessUpdateProfile).getText();
    }

    public void popUpSuccessDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(messageSuccessUpdateProfile));
    }

    /**
     * This method wait locator appear than get attribute values
     *
     * @param locator locator to wait and to get attribute values
     * @return text attribute values
     */
    private String waitElementGetAttribute(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getAttribute("value");
    }

    /**
     * This method get attribute values of an element or locator
     *
     * @param locator to get attribute
     * @return text attribute values
     */
    private String getAttributeValue(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }

    /**
     * @return text value attribute
     */
    public String getCompanyName() {
        return waitElementGetAttribute(companyNameField);
    }

    public String getFullNameText() {
        return getAttributeValue(fullNameField);
    }

    public String getJobSeniority() {
        return getAttributeValue(jobSeniority);
    }

    public String getRatePerDay() {
        return getAttributeValue(ratePerDay);
    }

    public String getChooseCity() {
        return getAttributeValue(chooseCity);
    }

    public String getChooseSpeciality() {
        return getAttributeValue(chooseSpeciality);
    }

    public String getDateOfBirth() {
        return getAttributeValue(dateOfBirth);
    }


}
