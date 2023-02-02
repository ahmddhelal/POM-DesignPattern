package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "OldPassword")
    WebElement oldPasswordTxtBox;

    @FindBy(id = "NewPassword")
    WebElement newPasswordTxtBox;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmPasswordTxtBox;

    @FindBy(css = "button.button-1.change-password-button")
    WebElement changePasswordBtn;

    @FindBy(css = "p.content")
    WebElement changePasswordMsg;

    @FindBy(partialLinkText = "Change password")
    WebElement changePasswordLinkBtn;

    public void clickChangePasswordLinkBtn() {
        clickOnButton(changePasswordLinkBtn);
    }

    public void changePassword(String oldPassword, String newPassword) {
        setValueToTxtField(oldPasswordTxtBox, oldPassword);
        setValueToTxtField(newPasswordTxtBox, newPassword);
        setValueToTxtField(confirmPasswordTxtBox, newPassword);
        clickOnButton(changePasswordBtn);
    }

    public String getChangePasswordMsg() {
        return changePasswordMsg.getText();
    }
}
