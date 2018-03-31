package steps;

import org.openqa.selenium.WebElement;
import pages.RegistrateInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class RegistrateInsuranceSteps extends BaseSteps {

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillData(String field, String value) {
        new RegistrateInsurancePage(driver).fillData(field, value);
    }

    @Step("Заполняются поля:")
    public void stepFillData(HashMap<String, String> fields) {
        fields.forEach(this::stepFillData);
    }

    @Step("поле {0} заполнено значением {1}")
    public void stepCheckFillField(String field, String value) {

        String actual = new RegistrateInsurancePage(driver).getCheckField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }


    @Step("Поля заполнены верно:")
    public void checkFillFields(HashMap<String, String> fields) {
        fields.forEach((k, v) -> stepCheckFillField(k, v));
    }

    @Step("Пол заполнен верно")
    public void stepCheckMale(WebElement female) {
        new RegistrateInsurancePage(driver).female.click();
        assertTrue("Неверно заполнен пол", female.isSelected());
    }


    @Step("Выполнено нажатие на кнопку - Продолжить")
    public void stepClickButtonNextReg() {
        new RegistrateInsurancePage(driver).nextReg.click();
    }

    @Step("Выполнена проверка наличия ошибки на странице")
    public void stepCheckMessegeError(String expecteErrorMassage) {
        String actualErrorMassage = new RegistrateInsurancePage(driver).errorMassage.getText();
        assertEquals(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualErrorMassage, expecteErrorMassage), expecteErrorMassage, actualErrorMassage);
    }

}
