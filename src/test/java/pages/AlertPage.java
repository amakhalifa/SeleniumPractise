package pages;

import base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage extends Testbase {

    @FindBy(xpath = "//a[@href='#example-1-tab-1']")
    WebElement simpleAlert;

    @FindBy(xpath = "//button")
    WebElement alertBtn;

    @FindBy(className = "demo-frame")
    WebElement actionFrame;

    public AlertPage() {
        PageFactory.initElements(driver, this);
    }
    public void clickAlert() {
        alertBtn.click();
    }


}
