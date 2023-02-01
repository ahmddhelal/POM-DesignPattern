package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement genderMaleRdoBtn;

    @FindBy(id = "FirstName")
    WebElement firstNameTxtBox;

    @FindBy(id = "LastName")
    WebElement lastNameTxtBox;

    @FindBy(id = "Email")
    WebElement emailTxtBox;

    @FindBy(id = "Password")
    WebElement passwordTxtBox;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTxtBox;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(css = "div.result")
    public WebElement registerMsg;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
    public WebElement logoutBtn;

    public void userRegister(String firstName, String lastName, String email, String password) {
        setValueToTxtField(firstNameTxtBox, firstName);
        setValueToTxtField(lastNameTxtBox, lastName);
        setValueToTxtField(emailTxtBox, email);
        setValueToTxtField(passwordTxtBox, password);
        setValueToTxtField(confirmPasswordTxtBox, password);
        clickOnButton(registerBtn);
    }

    public void userLogout() {
        clickOnButton(logoutBtn);
    }

}
