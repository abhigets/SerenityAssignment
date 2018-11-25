package test.weatherchecker.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import test.weatherchecker.ui.WeatherCheckerPage;

public class GetWeatherDetails implements Task {

    private final String postCode;

    protected GetWeatherDetails(String postCode) {
        this.postCode = postCode;
    }

    @Step("GetWeatherDetails for #postcode")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(postCode)
                        .into(WeatherCheckerPage.SEARCH_BOX)
        );
        actor.attemptsTo(
                Click.on(WeatherCheckerPage.SEARCH_BUTTON)
        );
    }

    public static GetWeatherDetails byPostCode(String postCode) {
        return instrumented(GetWeatherDetails.class, postCode);
    }

}
