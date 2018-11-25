package test.weatherchecker.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import test.weatherchecker.ui.WeatherChecker;

public class OpenWeatherApplication implements Task {

    WeatherChecker WeatherChecker;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(WeatherChecker)
        );
    }
}
