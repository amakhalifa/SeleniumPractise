package pages;

import base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrameWindowPage extends Testbase {

    @FindBy(xpath = "//a[text()='New Browser Tab']")
    WebElement newBrowserTab;

    @FindBy(css = "div.internal_navi > ul > li:nth-child(2) > a")
    WebElement openSeprateNewWindow;

    @FindBy(css = "div p > a")
    WebElement openSeprateNewWindowBtn;


    public FrameWindowPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickNewBrowserTab() {
        newBrowserTab.click();
    }

    public void openSeprateNewWindow() {
        openSeprateNewWindow.click();
    }

    public void clickSeprateNewWindowBtn() {
        waitForElementToBeClickable(openSeprateNewWindowBtn, 10);
        openSeprateNewWindowBtn.click();
    }

    public void switchToSeprateNewWindowFrame() {
        driver.switchTo().frame(1);
    }




}
