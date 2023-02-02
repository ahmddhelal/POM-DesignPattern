package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{
    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    String firstName = "Moataz";
    String lastName = "Nabil";
    String email = "testMail040@gmail.com";
    String password = "123As@";
    String newPassword = "123As@123";

    @Test(priority = 1)
    public void userRegisterSuccessfully() {
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.userRegister(firstName, lastName, email, password);
        Assert.assertTrue(userRegistrationPage.registerMsg.getText().contains("Your registration completed"));
    }

    @Test (dependsOnMethods = {"userRegisterSuccessfully"}, priority = 2)
    public void registeredUserCanLogin() {
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.userLogin(email, password);
        Assert.assertTrue(userRegistrationPage.logoutBtn.isDisplayed());
    }

    @Test (dependsOnMethods = {"registeredUserCanLogin", "userRegisterSuccessfully"}, priority = 3)
    public void registeredUserCanChangePassword() throws InterruptedException {
        homePage.openMyAccountPage();
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickChangePasswordLinkBtn();
        myAccountPage.changePassword(password, newPassword);
        Assert.assertTrue(myAccountPage.getChangePasswordMsg().contains("Password was changed"));
    }



}
