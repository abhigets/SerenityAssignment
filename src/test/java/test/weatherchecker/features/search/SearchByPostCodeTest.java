package test.weatherchecker.features.search;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.hamcrest.text.IsEmptyString;
import org.junit.Before;
import test.weatherchecker.questions.ValueOnWeatherCheckerPageFor;
import test.weatherchecker.questions.MessageOnWeatherDetailsPageIs;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import test.weatherchecker.tasks.OpenWeatherApplication;
import test.weatherchecker.tasks.GetWeatherDetails;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class SearchByPostCodeTest {

    Actor anna = Actor.named("Anna");



    //@Managed(uniqueSession = true,driver = "chrome")
    //@Managed(uniqueSession = true,driver = "htmlunit")
    //@Managed(uniqueSession = true,driver = "phantomjs")
    @Managed(uniqueSession = true,driver = "firefox")
    public WebDriver herBrowser;
    @Steps
    OpenWeatherApplication openWeatherChecker;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void should_be_able_to_search_a_postcode_and_see_weather_details() {

        givenThat(anna).wasAbleTo(openWeatherChecker);

        when(anna).attemptsTo(GetWeatherDetails.byPostCode("w6 0nw"));

        //all the below field are mandatory
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Time"), is(not("")))));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Temperature"), is(not("")))));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Humidity"), is(not("")))));

        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Summary"), is(not("")))));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Icon"), is(not("")))));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Nearest Storm Distance"), is(not("")))));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Precip Intensity"), is(not("")))));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Precip Probability:"), is(not("")))));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Apparent Temperature"), is(not("")))));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Dew Point"), is(not("")))));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Pressure"), is(not("")))));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Wind Speed"), is(not("")))));

        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Precip Intensity Error"),anyOf(notNullValue(),is("")))));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Precip Type"),anyOf(notNullValue(),is("")))));
    }

    @Test
    public void should_be_able_to_see_error_message_for_invalid_postcode() {

        givenThat(anna).wasAbleTo(openWeatherChecker);

        when(anna).attemptsTo(GetWeatherDetails.byPostCode("Invalid PostCode"));
        then(anna).should(eventually(seeThat(new MessageOnWeatherDetailsPageIs(), is("Invalid postcode."))));
    }

    @Test
    public void should_be_able_to_see_error_message_for_non_existing_postcode() {

        givenThat(anna).wasAbleTo(openWeatherChecker);

        when(anna).attemptsTo(GetWeatherDetails.byPostCode("B99 9AA"));
        then(anna).should(eventually(seeThat(new MessageOnWeatherDetailsPageIs(), is("Unable to find the postcode."))));
    }


}