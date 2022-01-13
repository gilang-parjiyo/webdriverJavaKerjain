package Regression;

import Base.BaseTestsRegression;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyJobsPage;
import pages.ProfilePage;
import pages.WorkersPage;
import utils.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RegressionTest extends BaseTestsRegression {

    @Test(priority = 0)
    @Epic("User should be able login in login page")
    @Feature("Login")
    @Description("Test user successful login ")
    @Severity(SeverityLevel.CRITICAL)
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setEmail("geelangtester@gmail.com");
        loginPage.setPassword("321*sdfG");
        MyJobsPage myJobPage = loginPage.clickLoginButton();
        Assert.assertEquals(myJobPage.getHeading4Text(),
                "PEKERJAAN AKTIF ANDA",
                "Heading 4 Is Incorrect");
        System.out.println("User successfully login");
    }

    @Test(priority = 3, dependsOnMethods = {"testSuccessfulLogin"})
    @Epic("User should be able to log out")
    @Feature("Log Out")
    @Description("Test user successful log Out ")
    @Severity(SeverityLevel.NORMAL)
    public void testSuccessfullyLogOut() {
        MyJobsPage myJobsPage = homePage.myJobsPageReturnDriver();
        myJobsPage.clickLogOut();
        myJobsPage.waitLogOutDisappear();
        Assert.assertEquals(myJobsPage.getLink(), "https://kerjain-team1.herokuapp.com/", "tst");
        System.out.println("User successfully logout");
    }


    @Test(priority = 1, dependsOnMethods = {"testSuccessfulLogin"})
    @Epic("User should be able to update profile")
    @Feature("Update Profile")
    @Description("Test user successful update profile ")
    @Severity(SeverityLevel.NORMAL)
    public void testUpdateProfile() {

        /**
         * Variable in profile page
         */
        String imagePath = "C:/Users/Gilang_R831/IdeaProjects/webdriverJavaKerjain/resources/screenshots/testUpdateProfile.png";
        RandomName randomName = new RandomName();
        RandomSpeciality randomSpeciality = new RandomSpeciality();
        RandomCity randomCity = new RandomCity();
        RandomSeniority randomSeniority = new RandomSeniority();
        RandomRatePerDay randomRatePerDay = new RandomRatePerDay();
        RandomDOB randomDOB = new RandomDOB();

        String fullName = randomName.getRandomName();
        String speciality = randomSpeciality.getRandomJob();
        String seniority = randomSeniority.getSeniority();
        String city = randomCity.getRandomCity();
        String rate = randomRatePerDay.getRatePerDay();

        /**
         * Web driver action in profile page
         */
        MyJobsPage myJobsPage = homePage.myJobsPageReturnDriver();
        ProfilePage profilePage = myJobsPage.clickProfile();
        profilePage.setFullName(fullName);
        profilePage.selectJobSpeciality(speciality);
        profilePage.setDateOfBirth("01-09-1993");
        profilePage.setJobSeniority(seniority);
        profilePage.setRatePerDay(rate);
        profilePage.setImageProfile(imagePath);
        profilePage.selectCity(city);
        profilePage.clickUpdateProfileButton();

        /**
         * Assertion profile page
         */
        Assert.assertEquals(profilePage.getMessageUpdateProfile(), "Update Profile Success", "Message success invalid");
        profilePage.popUpSuccessDisappear();
        Assert.assertEquals(profilePage.getFullNameText(), fullName, "Invalid full name");
        Assert.assertEquals(profilePage.getChooseSpeciality(), speciality, "Invalid speciality");
        Assert.assertEquals(profilePage.getJobSeniority(), seniority, "Invalid seniority");
        Assert.assertEquals(profilePage.getRatePerDay(), rate, "Invalid rate");
        Assert.assertEquals(profilePage.getChooseCity(), city, "Invalid city");
        System.out.println("User successfully logout");
    }

    @Test(priority = 2, dependsOnMethods = {"testSuccessfulLogin"})
    @Epic("User should be able filter workers")
    @Feature("Filter workers")
    @Description("Test user successful filter workers ")
    @Severity(SeverityLevel.NORMAL)
    public void testFilterWorkers() {
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

}
