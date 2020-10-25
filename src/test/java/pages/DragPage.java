package pages;

import base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragPage extends Testbase {

    @FindBy(id = "draggable")
    WebElement dragBox;

    public DragPage() {
        PageFactory.initElements(driver, this);
    }

    public void dragMe() {
        Actions action = new Actions(driver);
        action.dragAndDropBy(dragBox, 100, 50).perform();
    }


}
