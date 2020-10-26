package pages;

import base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Testbase {

    @FindBy(css = "div.row > div:nth-child(6) > ul > li > a")
    WebElement alertBtn;

    @FindBy(css = "div.row > div:nth-child(1) > ul > li:nth-child(1) > a")
    WebElement dragBtn;

    @FindBy(css = "div.row > div:nth-child(3) > ul > li:nth-child(1) > a")
    WebElement frameWindowBtn;

    @FindBy(css = "div.row > div:nth-child(4) > ul > li:nth-child(1) > a")
    WebElement dynamicElementBtn;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public AlertPage clickOnAlertLink() {
        waitForElementToBeClickable(alertBtn, 10);
        alertBtn.click();
        return new AlertPage();
    }

    public DragPage clickOnDragLink() {
        waitForElementToBeClickable(dragBtn, 10);
        dragBtn.click();
        return new DragPage();
    }

    public FrameWindowPage clickOnFrameWindLink() {
        waitForElementToBeClickable(frameWindowBtn, 10);
        frameWindowBtn.click();
        return new FrameWindowPage();
    }

    public DynamicElementsPage clickOnDynamicElementsLink() {
        waitForElementToBeClickable(dynamicElementBtn, 10);
        dynamicElementBtn.click();
        return new DynamicElementsPage();
    }
}
