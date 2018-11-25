package test.weatherchecker.questions;

import test.weatherchecker.ui.WeatherCheckerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MessageOnWeatherDetailsPageIs implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(WeatherCheckerPage.ERROR_MESSAGE_LOCATOR).viewedBy(actor).asString();
    }
}
