package test.weatherchecker.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TheSize;
import test.weatherchecker.ui.WeatherCheckerPage;

public class TotalFieldsOnWeatherCheckerPage implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return TheSize.of(WeatherCheckerPage.FIELDS_COUNT_LOCATOR).viewedBy(actor).asInteger();
    }
}
