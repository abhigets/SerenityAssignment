package test.weatherchecker.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;
import test.weatherchecker.ui.WeatherCheckerPage;

public class FieldsOnWeatherCheckerPage implements Question<Boolean>{

    private String fieldName;
    private String fieldValue;

    public FieldsOnWeatherCheckerPage(String fieldName, String fieldValue) {

        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Presence.of(WeatherCheckerPage.FIELDS_AND_VALUE_LOCATOR(fieldValue,fieldName)).viewedBy(actor).asBoolean();
    }
}
