package test.weatherchecker.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import test.weatherchecker.ui.WeatherCheckerPage;

public class ValueOnWeatherCheckerPageFor implements Question<Boolean>{

    private String fieldName;

    public ValueOnWeatherCheckerPageFor(String fieldName) {

        this.fieldName = fieldName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Text.of(WeatherCheckerPage.FIELDS_AND_VALUE_LOCATOR(fieldName)).viewedBy(actor).asBoolean();
    }
}
