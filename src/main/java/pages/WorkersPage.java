package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkersPage {

    private WebDriver driver;
    private By workerPage = By.xpath("//div[@class='mb-2 text-lg font-bold font-sub']");
    private By listWorkers = By.cssSelector(".grid > div");
    private By workerAgeField = By.xpath("//div[4]//input[2]");
    private By workRatePayRate = By.xpath("//div[6]//input[2]");
    private By workerCard = By.cssSelector(".grid > div:nth-of-type(1) > .w-full");
    private By sort = By.cssSelector(".rounded-xl > .inline-flex");
    private By cheapest = By.cssSelector(".mt-1.flex > div:nth-of-type(2)");
    private By recruitFirstCard = By.cssSelector(".grid > div:nth-of-type(1) button:nth-of-type(1)");

    public WorkersPage(WebDriver driver) {
        this.driver = driver;
    }

    private void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitElementDisappear(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitWorkersPageLoad() {
        waitElement(workerPage);
        waitElement(listWorkers);
    }

    public void setAgeRange(String age) {
        waitElement(workerAgeField);
        driver.findElement(workerAgeField).clear();
        driver.findElement(workerAgeField).sendKeys(age, Keys.ENTER);
        waitElementDisappear(listWorkers);
    }

    public ArrayList<String> getListWorkerAge() {
        ArrayList<String> list = new ArrayList<>();
        waitElement(workerCard);
        List<WebElement> workers = driver.findElements(listWorkers);
        for (int i = 1; i <= workers.size(); i++) {
            String str = driver.findElement(By.cssSelector(".grid > div:nth-of-type(" + i + ") div:nth-of-type(3)")).getText();
            str = str.substring(0, 2);
            list.add(str);
        }
        return list;
    }

    public ArrayList<String> getListWorkerPayRate() {
        ArrayList<String> list = new ArrayList<>();
        waitElement(workerCard);
        List<WebElement> workers = driver.findElements(listWorkers);
        for (int i = 1; i <= workers.size(); i++) {

            //get text from locator
            String str = driver.findElement(By.cssSelector(".grid > div:nth-of-type(" + i + ") div:nth-of-type(1) > div:nth-of-type(3) span:nth-of-type(1)")).getText();

            //Regex get
            String regex = "\\d+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            String pay = "";
            while (matcher.find()) {
                pay += matcher.group();
            }
            list.add(pay); // add regex result to arrayList
        }
        return list;
    }

    public void setWorkRatePerDay(String rate) {
        waitElement(workRatePayRate);
        driver.findElement(workRatePayRate).clear();
        driver.findElement(workRatePayRate).sendKeys(rate, Keys.ENTER);
        waitElementDisappear(listWorkers);
    }

    public void sortCheapest() {
        driver.findElement(sort).click();
        driver.findElement(cheapest).click();
        waitElementDisappear(listWorkers);

    }

    public ContractsPage clickCheapestContract(){
        waitElement(recruitFirstCard);
        driver.findElement(recruitFirstCard).click();
        return new ContractsPage(driver);
    }
}
