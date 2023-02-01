package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterTest extends TestBase{

    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;

    @Test (priority = 1)
    public void userRegisterSuccessfully() {
        homePage = new HomePage(driver);
        homePage.openRegisterPage();

        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.userRegister("Moataz","Nabil", "testMail020@gmail.com", "123As@");

        Assert.assertTrue(userRegistrationPage.registerMsg.getText().contains("Your registration completed"));
    }

    @Test (dependsOnMethods = {"userRegisterSuccessfully"}, priority = 3)
    public void registeredUserCanLogout() {
        userRegistrationPage.userLogout();
    }

    @Test (dependsOnMethods = {"userRegisterSuccessfully"}, priority = 2)
    public void registeredUserCanLogin() {
        homePage.openLoginPage();

        loginPage = new LoginPage(driver);
        loginPage.userLogin("testMail020@gmail.com", "123As@");
        Assert.assertTrue(userRegistrationPage.logoutBtn.isDisplayed());
    }
}
