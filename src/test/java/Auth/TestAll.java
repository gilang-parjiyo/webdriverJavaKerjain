package Auth;

import Base.BaseTestsAll;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyJobsPage;
import pages.ProfilePage;
import utils.*;

public class TestAll extends BaseTestsAll {

    @Test(priority = 0)
    @Epic("User should be able login in login page")
    @Feature("This is a feature")
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
    }

    @Test(priority = 2)
    public void testSuccessfullyLogOut() {
        MyJobsPage myJobsPage = homePage.homePageReturnDriver();
        myJobsPage.clickLogOut();
        myJobsPage.waitLogOutDisappear();
        Assert.assertEquals(myJobsPage.getLink(), "https://kerjain-team1.herokuapp.com/", "tst");


    }

    @Test(priority = 1)
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
        MyJobsPage myJobsPage = homePage.homePageReturnDriver();
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
    }

}
