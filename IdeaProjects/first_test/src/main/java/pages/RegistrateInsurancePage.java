package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrateInsurancePage {

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
    public
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
    public
    WebElement nextReg;

    @FindBy(xpath = "//div[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")
    public
    WebElement errorMassage;

    public RegistrateInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(birthDate));
        wait.until(ExpectedConditions.visibilityOf(nextReg));
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

    public String getCheckField(String checkFieldName) {
        switch (checkFieldName) {
            case "Фамилия застрахованного":
                return insuredSurname.getAttribute("value");
            case "Имя застрахованного":
                return insuredName.getAttribute("value");
            case "Дата рождения застрахованного":
                return insuredBirthDate.getAttribute("value");
            case "Фамилия страхователя":
                return surname.getAttribute("value");
            case "Имя страхователя":
                return name.getAttribute("value");
            case "Отчество страхователя":
                return middlename.getAttribute("value");
            case "Дата рождения страхователя":
                return birthDate.getAttribute("value");
            case "Пол страхователя":
                if (female.isSelected()){
                    return "";
                }
                else {return "Неверный пол";}
            case "Серия паспорта":
                return passportSeries.getAttribute("value");
            case "Номер паспорта":
                return passportNumber.getAttribute("value");
            case "Дата выдачи паспорта":
                return issueDate.getAttribute("value");
            case "Кем выдан":
                return issuePlace.getAttribute("value");

        }
        throw new AssertionError("Поле не объявлено на странице");


    }
}
