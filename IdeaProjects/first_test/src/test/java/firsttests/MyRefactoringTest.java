package firsttests;

import org.junit.Test;
import pages.ChooseInsurancePage;
import pages.MainPage;
import pages.RegistrateInsurancePage;
import pages.TravelInsPage;
import steps.BaseSteps;

public class MyRefactoringTest extends BaseSteps {


    @Test


    public void newInsuranceTest() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);

        //Открыть окно с выбором страховок, подождать и выбрать Страхование путешественников
        mainPage.selectMenuItem("Раздел Застраховать себя  и имущество");
        mainPage.waitTravelersInsuranceSubMenu(driver);
        mainPage.selectTravelersInsuranceSubMenu("Страхование путешественников");

        //Нажимаем на баннер
        new TravelInsPage(driver).bannerZashitaTraveler.click();

        //Переключаемся на страницу
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        //Выбираем минимальную сумму и нажимаем кнопку Оформить
        new ChooseInsurancePage(driver).minimalButton.click();
        new ChooseInsurancePage(driver).registrateButton.click();

        //Заполняем форму
        RegistrateInsurancePage registateInsurancePage = new RegistrateInsurancePage(driver);
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
        RegistrateInsurancePage checkField = new RegistrateInsurancePage(driver);
        checkField.getCheckField("Фамилия застрахованного");
        checkField.getCheckField("Имя застрахованного");
        checkField.getCheckField("Дата рождения застрахованного");
        checkField.getCheckField("Фамилия страхователя");
        checkField.getCheckField("Имя страхователя");
        checkField.getCheckField("Отчество страхователя");
        checkField.getCheckField("Дата рождения страхователя");
        checkField.getCheckField("Пол страхователя");
        checkField.getCheckField("Серия паспорта");
        checkField.getCheckField("Номер паспорта");
        checkField.getCheckField("Дата выдачи паспорта");
        checkField.getCheckField("Кем выдан");


    }
}

