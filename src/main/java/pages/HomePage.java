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

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
    WebElement loginBtn;

    public void openRegisterPage() {
        clickOnButton(registerBtn);
    }

    public void openLoginPage() {
        clickOnButton(loginBtn);
    }



}
