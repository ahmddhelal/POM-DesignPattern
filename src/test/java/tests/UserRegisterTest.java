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
    String firstName = "Moataz";
    String lastName = "Nabil";
    String email = "testMail020@gmail.com";
    String password = "123As@";

    @Test (priority = 1)
    public void userRegisterSuccessfully() {
        homePage = new HomePage(driver);
        homePage.openRegisterPage();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.userRegister(firstName, lastName, email, password);
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
        loginPage.userLogin(email, password);
        Assert.assertTrue(userRegistrationPage.logoutBtn.isDisplayed());
    }
}
