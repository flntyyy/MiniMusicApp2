

        import java.util.concurrent.TimeUnit;
        import org.junit.*;
        import static org.junit.Assert.*;
        import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.Wait;
        import org.openqa.selenium.support.ui.WebDriverWait;

public class insurance {
    private WebDriver driver;
    private String baseUrl;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");

        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//*[contains(text(),'Застраховать')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//*[contains(text(),'Страхование путешественников')]"))));
        driver.findElement(By.xpath("//*[contains(text(),'Страхование путешественников')]")).click();

        driver.findElement(By.xpath("//img[contains(@src,'id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53')]")).click();
        String winHandleBefore = driver.getWindowHandle();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Wait<WebDriver> wait2 = new WebDriverWait(driver, 5, 1000);
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

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


    private void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }


}