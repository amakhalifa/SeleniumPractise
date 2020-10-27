package pages;

import base.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DropDownPage extends Testbase {
    public DropDownPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "select")
    WebElement select;

    @FindBy(css = "div.internal_navi > ul > li:nth-child(2) > a")
    WebElement enterCountryTab;

    @FindBy(css = "div.ui-widget > span > input")
    WebElement searchField;

    @FindBy(css = "ul[id='ui-id-1'] li")
    List<WebElement> ctryList;

    public void typeInitialsOfEgyptCountry() {
        searchField.sendKeys("eg");
    }

    public void clearSearchField() {
        searchField.clear();
    }

    public void clickOnEnterCountryTab() {
        enterCountryTab.click();
    }


    public String getCurrentList() {
        List<String> currentCountryList = new ArrayList<String>();
        Iterator<WebElement> it = ctryList.listIterator();
        while (it.hasNext()) {
            String ctry = it.next().getText().toLowerCase();
            currentCountryList.add(ctry);
        }
        String listString = "";
        for (String s : currentCountryList)
        {
            listString += s + "\t";
        }
        System.out.println(listString);
        return listString;
    }

    public Select dropDownSelect() {
        return new Select(select);
    }

    public void selectCountry(){
        dropDownSelect().selectByValue("Albania");
    }

    public String getSelectedCountry(){
         return (dropDownSelect().getFirstSelectedOption().getText());
    }
}
