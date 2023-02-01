package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected void clickOnButton(WebElement button) {
        button.click();
    }

    protected void setValueToTxtField(WebElement textField, String value) {
        textField.sendKeys(value);
    }
}