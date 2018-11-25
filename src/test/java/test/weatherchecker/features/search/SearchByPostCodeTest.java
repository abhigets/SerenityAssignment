package test.weatherchecker.features.search;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.Before;
import test.weatherchecker.questions.FieldsOnWeatherCheckerPage;
import test.weatherchecker.questions.MessageOnWeatherDetailsPageIs;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import test.weatherchecker.questions.TotalFieldsOnWeatherCheckerPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import test.weatherchecker.tasks.OpenWeatherApplication;
import test.weatherchecker.tasks.GetWeatherDetails;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class SearchByPostCodeTest {

    Actor anna = Actor.named("Anna");

    //@Managed(uniqueSession = true,driver = "chrome")
    //@Managed(uniqueSession = true,driver = "firefox")
    //@Managed(uniqueSession = true,driver = "htmlunit")
    @Managed(uniqueSession = true,driver = "phantomjs")
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
        then(anna).should(eventually(seeThat(new TotalFieldsOnWeatherCheckerPage(), equalTo(14))));
        then(anna).should(eventually(seeThat(new FieldsOnWeatherCheckerPage("Time","22/11/2018 20:17:53"), is(true))));
        then(anna).should(eventually(seeThat(new FieldsOnWeatherCheckerPage("Summary","Partly Cloudy"), is(true))));
        then(anna).should(eventually(seeThat(new FieldsOnWeatherCheckerPage("Icon","partly-cloudy-night"), is(true))));
        then(anna).should(eventually(seeThat(new FieldsOnWeatherCheckerPage("Nearest Storm Distance","40"), is(true))));
        then(anna).should(eventually(seeThat(new FieldsOnWeatherCheckerPage("Precip Intensity","0"), is(true))));
        then(anna).should(eventually(seeThat(new FieldsOnWeatherCheckerPage("Precip Intensity Error",""), is(true))));
        then(anna).should(eventually(seeThat(new FieldsOnWeatherCheckerPage("Temperature","38.76"), is(true))));
        then(anna).should(eventually(seeThat(new FieldsOnWeatherCheckerPage("Apparent Temperature","35.01"), is(true))));
        then(anna).should(eventually(seeThat(new FieldsOnWeatherCheckerPage("Dew Point","36.1"), is(true))));
        then(anna).should(eventually(seeThat(new FieldsOnWeatherCheckerPage("Humidity","0.9"), is(true))));
        then(anna).should(eventually(seeThat(new FieldsOnWeatherCheckerPage("Pressure","1016.8"), is(true))));
        then(anna).should(eventually(seeThat(new FieldsOnWeatherCheckerPage("Wind Speed","5"), is(true))));
    }

    @Test
    public void should_be_able_to_see_valid_message_for_invalid_postcode() {

        givenThat(anna).wasAbleTo(openWeatherChecker);

        when(anna).attemptsTo(GetWeatherDetails.ByPostCode("Invalid PostCode"));
        then(anna).should(eventually(seeThat(new MessageOnWeatherDetailsPageIs(), is("Invalid postcode."))));
    }
}