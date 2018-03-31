package firsttests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import static org.junit.Assert.*;

public class InsuranceTest extends BaseSteps {


    @Test
    @Ignore
    public void testInsurance() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[contains(text(),'Застраховать')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
             driver.findElement(By.xpath("//*[contains(text(),'Страхование путешественников')]"))));
        driver.findElement(By.xpath("//*[contains(text(),'Страхование путешественников')]")).click();

        driver.findElement(By.xpath("//img[contains(@src,'id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53')]")).click();


        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        wait.until(ExpectedConditions.visibilityOf(
               driver.findElement(By.xpath("//*[contains(text(),'Минимальная')]"))));
        driver.findElement(By.xpath("//*[contains(text(),'Минимальная')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Оформить')]")).click();


        fillField(By.name("insured0_surname"), "SMIRNOVASASASASASDADADASASADADADADADQADADDADQDQ");
        fillField(By.name("insured0_name"), "ALEKSANDR");

        assertEquals("SMIRNOVASASASASASDADADASASADADADADADQADADDADQDQ", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("ALEKSANDR", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        driver.findElement(By.xpath("//*[contains(text(),'Продолжить')]")).click();
        assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//div[contains(@ng-show, 'tryNext && myForm.$invalid')]")).getText());
    }






}