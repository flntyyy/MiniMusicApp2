package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChooseInsurancePage {

    @FindBy(xpath = "//div[@class='b-form-box-title ng-binding'][contains(text(),'Минимальная')]")
    public WebElement minimalButton;

    @FindBy(xpath = "//span[@class='b-continue-btn'][contains(text(),'Оформить')]")
    public WebElement registrateButton;

    public ChooseInsurancePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        Wait<WebDriver> wait = new WebDriverWait(driver,10,1000);
        wait.until(ExpectedConditions.visibilityOf(minimalButton));
    }
}
