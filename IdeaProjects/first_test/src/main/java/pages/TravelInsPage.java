package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelInsPage {

    @FindBy(xpath = "//img[contains(@src,'id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53')]")
    public
    WebElement bannerZashitaTraveler;

    public TravelInsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
