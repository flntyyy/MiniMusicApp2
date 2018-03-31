package steps;

import pages.ChooseInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class ChooseInsuranceSteps extends BaseSteps {

    @Step("Выбрана минимальная сумма")
    public void stepChooseMinSum() {
        new ChooseInsurancePage(driver).minimalButton.click();
    }

    @Step("Нажата кнопка - Оформить")
    public void stepClickRegistrateButton() {
        new ChooseInsurancePage(driver).registrateButton.click();
    }
}
