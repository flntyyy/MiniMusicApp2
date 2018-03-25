package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    @FindBy(xpath = "//ul[contains(@class,'alt-menu-mid__list')]")
    WebElement mainMenu;

    @FindBy(xpath = "//li[5]/div[contains(@class,'alt-menu-collapser__area alt-menu-collapser__area_cols_3')]")
    WebElement insuranceSubMenu;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectMenuItem(String menuItem) {
        mainMenu.findElement(By.xpath(".//*[contains(@aria-label,'" + menuItem + "')]")).click();
    }

    public void waitTravelersInsuranceSubMenu(WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(insuranceSubMenu));
    }

    public void selectTravelersInsuranceSubMenu(String menuItem) {
        insuranceSubMenu.findElement(By.xpath("//*[contains(text(),'" + menuItem + "')]")).click();
    }

}