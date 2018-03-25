

import org.junit.Test;
import pages.MainPage;
import pages.RegistateInsurancePage;
import pages.TravelInsPage;
import pages.ChooseInsurancePage;
import steps.BaseSteps;

public class MyRefactoringTest extends BaseSteps {


    @Test

    public void newInsuranceTest() throws InterruptedException {

        MainPage mainPage =  new MainPage(driver);

        //Открыть окно с выбором страховок, подождать и выбрать Страхование путешественников
        mainPage.selectMenuItem("Раздел Застраховать себя  и имущество");
        mainPage.waitTravelersInsuranceSubMenu(driver);
        mainPage.selectTravelersInsuranceSubMenu("Страхование путешественников");

        //Нажимаем на баннер
        new TravelInsPage (driver).bannerZashitaTraveler.click();

        //Переключаемся на страницу
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        //Выбираем минимальную сумму и нажимаем кнопку Оформить
        new ChooseInsurancePage(driver).minimalButton.click();
        new ChooseInsurancePage(driver).registrateButton.click();

        //Заполняем форму
        RegistateInsurancePage registateInsurancePage = new RegistateInsurancePage(driver);
        registateInsurancePage.fillData("Фамилия застрахованного", "IVANOV");
        registateInsurancePage.fillData("Имя застрахованного", "LEV");
        registateInsurancePage.fillData("Дата рождения застрахованного", "01012011");
        registateInsurancePage.fillData("Фамилия страхователя", "Иванова");
        registateInsurancePage.fillData("Имя страхователя", "Елена");
        registateInsurancePage.fillData("Отчество страхователя", "Петровна");
        registateInsurancePage.fillData("Дата рождения страхователя", "02021984");
        registateInsurancePage.fillData("Пол страхователя", "");
        registateInsurancePage.fillData("Серия паспорта", "1234");
        registateInsurancePage.fillData("Номер паспорта", "567890");
        registateInsurancePage.fillData("Дата выдачи паспорта", "12022010");
        registateInsurancePage.fillData("Кем выдан", "Отделением ОВД по г. Москва");
        //Проверяем введенные поля
        RegistateInsurancePage checkField = new RegistateInsurancePage(driver);
        checkField.checkField("Фамилия застрахованного");
        checkField.checkField("Имя застрахованного");
        checkField.checkField("Дата рождения застрахованного");
        checkField.checkField("Фамилия страхователя");
        checkField.checkField("Имя страхователя");
        checkField.checkField("Отчество страхователя");
        checkField.checkField("Дата рождения страхователя");
        checkField.checkField("Пол страхователя");
        checkField.checkField("Серия паспорта");
        checkField.checkField("Номер паспорта");
        checkField.checkField("Дата выдачи паспорта");
        checkField.checkField("Кем выдан");

        //Нажимаем на кнопку продолжить
        RegistateInsurancePage clickButtonNext = new RegistateInsurancePage(driver);
        clickButtonNext.clickButton();
        //Проверить сообщение о ошибке
        clickButtonNext.checkMessegeError();
    }
}

