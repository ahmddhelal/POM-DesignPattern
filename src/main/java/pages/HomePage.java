package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registerBtn ;

    @FindBy(className = "ico-login")
    WebElement loginBtn;

    @FindBy(className = "ico-account")
    WebElement myAccountBtn;

    public void openRegisterPage() {
        clickOnButton(registerBtn);
    }

    public void openLoginPage() {
        clickOnButton(loginBtn);
    }

    public void openMyAccountPage() {
        clickOnButton(myAccountBtn);
    }



}
