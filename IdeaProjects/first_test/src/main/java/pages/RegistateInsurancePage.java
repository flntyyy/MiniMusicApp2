package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistateInsurancePage {

    @FindBy(name = "insured0_surname")
    WebElement insuredSurname;

    @FindBy(name = "insured0_name")
    WebElement insuredName;

    @FindBy(name = "insured0_birthDate")
    WebElement insuredBirthDate;

    @FindBy(name = "surname")
    WebElement surname;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "middlename")
    WebElement middlename;

    @FindBy(name = "birthDate")
    WebElement birthDate;

    @FindBy(name = "female")
    WebElement female;

    @FindBy(name = "passport_series")
    WebElement passportSeries;

    @FindBy(name = "passport_number")
    WebElement passportNumber;

    @FindBy(name = "issueDate")
    WebElement issueDate;

    @FindBy(name = "issuePlace")
    WebElement issuePlace;

    @FindBy(xpath = "//span[text()='Продолжить']")
    WebElement nextReg;

    @FindBy(xpath = "//div[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")
    WebElement errorMassage;

    public RegistateInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(birthDate));
        wait.until(ExpectedConditions.visibilityOf(nextReg));
    }

    public void clickButton() {
        nextReg.click();
    }

    public void checkMessegeError() {
        assertEquals("Отсутствует сообщение об ошибке", "Заполнены не все обязательные поля", errorMassage.getText());
    }

    public void fillData(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                fillData(insuredSurname, value);
                break;
            case "Имя застрахованного":
                fillData(insuredName, value);
                break;
            case "Дата рождения застрахованного":
                fillData(insuredBirthDate, value);
                break;
            case "Фамилия страхователя":
                fillData(surname, value);
                break;
            case "Имя страхователя":
                fillData(name, value);
                break;
            case "Отчество страхователя":
                fillData(middlename, value);
                break;
            case "Дата рождения страхователя":
                birthDate.click();
                fillData(birthDate, value);
                break;
            case "Пол страхователя":
                female.click();
                break;
            case "Серия паспорта":
                fillData(passportSeries, value);
                break;
            case "Номер паспорта":
                fillData(passportNumber, value);
                break;
            case "Дата выдачи паспорта":
                fillData(issueDate, value);
                break;
            case "Кем выдан":
                fillData(issuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");

        }
    }

    //Метод для заполнения полей
    public void fillData(WebElement element, String value) {
        element.clear();//очищаем поле перед заполнением
        element.sendKeys(value);//заполнение
    }

    public void checkField(String checkFieldName) {
        switch (checkFieldName) {
            case "Фамилия застрахованного":
                assertEquals("Неверно заполнено поле", "IVANOV", insuredSurname.getAttribute("value"));
                break;
            case "Имя застрахованного":
                assertEquals("Неверно заполнено поле", "LEV", insuredName.getAttribute("value"));
                break;
            case "Дата рождения застрахованного":
                assertEquals("Неверно заполнено поле", "01.01.2011", insuredBirthDate.getAttribute("value"));
                break;
            case "Фамилия страхователя":
                assertEquals("Неверно заполнено поле", "Иванова1", surname.getAttribute("value"));
                break;
            case "Имя страхователя":
                assertEquals("Неверно заполнено поле", "Елена", name.getAttribute("value"));
                break;
            case "Отчество страхователя":
                assertEquals("Неверно заполнено поле", "Петровна", middlename.getAttribute("value"));
                break;
            case "Дата рождения страхователя":
                assertEquals("Неверно заполнено поле", "02.02.1984", birthDate.getAttribute("value"));
                break;
            case "Пол страхователя":
                assertTrue("Неверно заполнен пол", female.isSelected());
                break;
            case "Серия паспорта":
                assertEquals("Неверно заполнено поле", "1234", passportSeries.getAttribute("value"));
                break;
            case "Номер паспорта":
                assertEquals("Неверно заполнено поле", "567890", passportNumber.getAttribute("value"));
                break;
            case "Дата выдачи паспорта":
                assertEquals("Неверно заполнено поле", "12.02.2010", issueDate.getAttribute("value"));
                break;
            case "Кем выдан":
                assertEquals("Неверно заполнено поле", "Отделением ОВД по г. Москва", issuePlace.getAttribute("value"));
                break;
            default:
                throw new AssertionError("Поле '" + checkFieldName + "' не объявлено на странице");
        }


    }
}
