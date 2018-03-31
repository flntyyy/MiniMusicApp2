package steps;

import pages.TravelInsPage;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelInsSteps extends BaseSteps {

    @Step ("Выполнено нажатие на баннер - Оформить онлайн")
    public void stepBannerZashitaTraveler () {
        new TravelInsPage(driver).bannerZashitaTraveler.click();
    }
}
