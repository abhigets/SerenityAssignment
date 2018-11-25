package test.weatherchecker.features.search;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
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
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.notNullValue;

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

        when(anna).attemptsTo(GetWeatherDetails.ByPostCode("w6 0nw"));
        //then(anna).should(eventually(seeThat(new TotalFieldsOnWeatherCheckerPage(), equalTo(14))));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Time"), notNullValue())));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Summary"), notNullValue())));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Icon"), notNullValue())));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Nearest Storm Distance"), notNullValue())));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Precip Intensity"), notNullValue())));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Precip Intensity Error"),notNullValue())));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Temperature"), notNullValue())));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Apparent Temperature"), notNullValue())));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Dew Point"), notNullValue())));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Humidity"), notNullValue())));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Pressure"), notNullValue())));
        then(anna).should(eventually(seeThat(new ValueOnWeatherCheckerPageFor("Wind Speed"), notNullValue())));
    }

    @Test
    public void should_be_able_to_see_valid_message_for_invalid_postcode() {

        givenThat(anna).wasAbleTo(openWeatherChecker);

        when(anna).attemptsTo(GetWeatherDetails.ByPostCode("Invalid PostCode"));
        then(anna).should(eventually(seeThat(new MessageOnWeatherDetailsPageIs(), is("Invalid postcode."))));
    }
}