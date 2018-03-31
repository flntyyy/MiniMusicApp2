package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps {

    @Step("Выбран пункт меню {0}")
    public void stepSelectMenuItem(String menuItem) {
        new MainPage(driver).selectMenuItem(menuItem);
    }


    @Step("Выбран вид страхования {0}")
    public void stepSelectTravelersInsuranceSubMenu() {
        new MainPage(driver).waitTravelersInsuranceSubMenu(driver);
        new MainPage(driver).selectTravelersInsuranceSubMenu("Страхование путешественников");
    }

}
