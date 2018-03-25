package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//div[contains(@class,'alt-menu-mid') and contains(@xpath,'1')]")
    WebElement insuranceMenuItem;

    @FindBy(xpath = "//*[contains(text(),'Страхование путешественников')]")
    WebElement travelersInsuranceSubMenu;

    public MainPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void selectInsuranceMenuItem (String menuItem){
        "//*[contains(text(),'Застраховать')]"

    }

    public void selectTravelersInsuranceSubMenu (String menuItem){

    }

}
