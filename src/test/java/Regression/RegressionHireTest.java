package Regression;

import Base.BaseTestsRegression;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.*;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class RegressionHireTest extends BaseTestsRegression {

    @Test()
    @Epic("Hire should be able login in login page")
    @Feature("Login")
    @Description("Test hire successful login ")
    @Severity(SeverityLevel.CRITICAL)
    public void testSuccessfulLoginHire() {
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setEmail("testhire10@mailinator.com");
        loginPage.setPassword("Asdf1234!");

        MyJobsPage myJobPage = loginPage.clickLoginButton();
        assertEquals(myJobPage.loadMyJobHire(),
                "MyBoard",
                "Dashboard hire loaded");
        System.out.println("hire successfully login");
    }

    @Test(priority = 1, dependsOnMethods = {"testSuccessfulLoginHire"})
    @Epic("hire should be able to update profile")
    @Feature("Update Profile")
    @Description("Test hire successful update profile ")
    @Severity(SeverityLevel.NORMAL)
    public void testSuccessfulUpdateHireProfile() {

        /**
         * Variable in profile page
         */
        String imagePath = "C:/Users/Gilang_R831/IdeaProjects/webdriverJavaKerjain/resources/screenshots/testUpdateProfile.png";
        RandomName randomName = new RandomName();
        RandomCity randomCity = new RandomCity();
        RandomCompanyName randomCompanyName = new RandomCompanyName();

        String fullName = randomName.getRandomName();
        String city = randomCity.getRandomCity();
        String company = randomCompanyName.getRandomName();

        /**
         * Web driver action in profile page
         */
        MyJobsPage myJobsPage = homePage.myJobsPageReturnDriver();
        ProfilePage profilePage = myJobsPage.clickProfile();
        profilePage.setCompanyName(company);
        profilePage.setFullName(fullName);
        profilePage.setDateOfBirth("01-09-1993");
        profilePage.setImageProfile(imagePath);
        profilePage.selectCity(city);
        profilePage.clickUpdateProfileButton();

        /**
         * Assertion profile page
         */
        Assert.assertEquals(profilePage.getMessageUpdateProfile(), "Update Profile Success", "Message success invalid");
        profilePage.popUpSuccessDisappear();
        Assert.assertEquals(profilePage.getCompanyName(), company, "Invalid Company name");
        Assert.assertEquals(profilePage.getFullNameText(), fullName, "Invalid full name");
        Assert.assertEquals(profilePage.getChooseCity(), city, "Invalid city");

        System.out.println("Test successfully update profile");
    }

    @Test(priority = 2, dependsOnMethods = {"testSuccessfulLoginHire"})
    @Epic("hire should be able filter workers")
    @Feature("Filter workers")
    @Description("Test hire successful filter workers ")
    @Severity(SeverityLevel.NORMAL)
    public void testSuccessfulFilterWorkers() {
        MyJobsPage myJobsPage = homePage.myJobsPageReturnDriver();
        WorkersPage workersPage = myJobsPage.clickWorkerListing();

        workersPage.waitWorkersPageLoad();
        workersPage.setAgeRange("25");

        /**
         * Assert result filter worker age
         */

        for (String str : workersPage.getListWorkerAge()) {
            int age = Integer.parseInt(str);
            Assert.assertTrue(age <= 25 && age >= 18, "Age is greater than limit");
        }
        System.out.println("Test successfully filter age workers");

        /**
         * Assert result filter worker pay rate
         */
        workersPage.setWorkRatePerDay("100000");
        for (String str : workersPage.getListWorkerPayRate()) {
            int rate = Integer.parseInt(str);
            Assert.assertTrue(rate < 100000 && rate > 0, "Pay rate is greater than 100000");
        }
        System.out.println("Test successfully filter pay rate workers");


        /**
         * Assert sorting
         */

        workersPage.sortCheapest();
        int initialRate = 0;
        for (int i = 0; i < workersPage.getListWorkerPayRate().size(); i++) {
            ArrayList<String> str = workersPage.getListWorkerPayRate();
            int rate = Integer.parseInt(str.get(i));
            if (i == 0 || initialRate < rate) initialRate = rate;
            Assert.assertTrue(initialRate <= rate, "Sorting cheapest is invalid");
        }
        System.out.println("Test successfully sorting cheapest");

    }

    @Test(priority = 3, dependsOnMethods = {"testSuccessfulLoginHire"})
    @Epic("hire should be able create contracts")
    @Feature("Recruit workers")
    @Description("Test  hire success recruit workers")
    @Severity(SeverityLevel.NORMAL)
    public void testSuccessfulCreateContracts() {
        String path = "C:/Users/Gilang_R831/IdeaProjects/webdriverJavaKerjain/resources/data/WhatsapChatBot.pdf";

        MyJobsPage myJobsPage = homePage.myJobsPageReturnDriver();
        WorkersPage workersPage = myJobsPage.clickWorkerListing();

        workersPage.waitWorkersPageLoad();
        workersPage.sortCheapest();

        ContractsPage contractsPage = workersPage.clickCheapestContract();
        contractsPage.waitLoadPage();
        contractsPage.attachFile(path);
        contractsPage.setStartDate("20-01-2022");
        contractsPage.setDueDate("30-01-2022");
        contractsPage.setDescription("Description");
        contractsPage.saveContract();

        Assert.assertEquals(contractsPage.successCreateContractMessage(), "Create Success", "Create contract invalid");
        System.out.println("Test successfully create contract");
        workersPage.waitWorkersPageLoad();

    }

    @Test(priority = 4, dependsOnMethods = {"testSuccessfulLoginHire"})
    @Epic("hire should be able to log out")
    @Feature("Log Out")
    @Description("Test hire successful log Out ")
    @Severity(SeverityLevel.NORMAL)
    public void testSuccessfulHireLogOut() {
        MyJobsPage myJobsPage = homePage.myJobsPageReturnDriver();
        myJobsPage.clickLogOut();
        myJobsPage.waitLogOutDisappear();
        Assert.assertEquals(myJobsPage.getLink(), "https://kerjain-team1.herokuapp.com/", "tst");
        System.out.println("hire successfully logout");
    }

}
