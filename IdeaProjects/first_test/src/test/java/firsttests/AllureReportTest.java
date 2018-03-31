package firsttests;

import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;


public class AllureReportTest extends BaseSteps {


    @Test
    @Title("Страхование")
    public void testInsurance() {
        MainSteps mainSteps = new MainSteps();
        TravelInsSteps travelInsSteps = new TravelInsSteps();
        ChooseInsuranceSteps chooseInsuranceSteps = new ChooseInsuranceSteps();
        RegistrateInsuranceSteps registrateInsuranceSteps = new RegistrateInsuranceSteps();

        mainSteps.stepSelectMenuItem("Раздел Застраховать себя  и имущество");
        mainSteps.stepSelectTravelersInsuranceSubMenu();


        travelInsSteps.stepBannerZashitaTraveler();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        chooseInsuranceSteps.stepChooseMinSum();
        chooseInsuranceSteps.stepClickRegistrateButton();

        HashMap<String, String> testData = new HashMap<>();

        testData.put("Фамилия застрахованного", "");
        testData.put("Имя застрахованного", "LEV");
        testData.put("Дата рождения застрахованного", "01.01.2017");
        testData.put("Фамилия страхователя", "Иванова");
        testData.put("Имя страхователя", "Елена");
        testData.put("Отчество страхователя", "Петровна");
        testData.put("Дата рождения страхователя", "02.02.1984");
        testData.put("Пол страхователя", "");
        testData.put("Серия паспорта", "1234");
        testData.put("Номер паспорта", "567890");
        testData.put("Дата выдачи паспорта", "12.02.2010");
        testData.put("Кем выдан", "Отделением ОВД по г. Москва");

        registrateInsuranceSteps.stepFillData(testData);
        registrateInsuranceSteps.checkFillFields(testData);

        registrateInsuranceSteps.stepClickButtonNextReg();
        registrateInsuranceSteps.stepCheckMessegeError("Не заполнен телефон");


    }

}
