package net.gmbh.solutions.features.user;

import net.gmbh.solutions.questions.AllUsersContainsUser;
import net.gmbh.solutions.questions.ErrorMessageOnNewUserFor;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import net.gmbh.solutions.tasks.OpenTheManageUserApplication;
import net.gmbh.solutions.tasks.AddUser;

import static com.jayway.awaitility.Awaitility.given;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class ManageUserStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true,driver = "chrome")
    public WebDriver herBrowser;

    @Steps
    OpenTheManageUserApplication openTheManageUserApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
        SerenityRest.rest().
                when().delete("http://85.93.17.135:9000/user/all");

    }

    @Test
    public void should_be_able_to_add_an_user() {

        givenThat(anna).wasAbleTo(openTheManageUserApplication);

        when(anna).attemptsTo(AddUser.withFollowingDetails("John Doe","john.doe@gmail.com","Passw0rd!","Passw0rd!"));

        then(anna).should(eventually(seeThat(new AllUsersContainsUser("John Doe"), is(true))));
    }

    @Test
    public void should_be_able_to_verify_validation_for_all_required_field() {

        givenThat(anna).wasAbleTo(openTheManageUserApplication);

        when(anna).attemptsTo(AddUser.withFollowingDetails("","","",""));

        then(anna).should(eventually(seeThat(new ErrorMessageOnNewUserFor("name"), is("Required"))));
        then(anna).should(eventually(seeThat(new ErrorMessageOnNewUserFor("email"), is("Required"))));
        then(anna).should(eventually(seeThat(new ErrorMessageOnNewUserFor("password"), is("Required"))));

    }

    @Test
    public void should_be_able_to_verify_validation_for_password_miss_match() {

        givenThat(anna).wasAbleTo(openTheManageUserApplication);

        when(anna).attemptsTo(AddUser.withFollowingDetails("John Doe","john.doe@gmail.com","Passw0rd!","miss match password"));

        then(anna).should(eventually(seeThat(new ErrorMessageOnNewUserFor("confirmationPassword"), is("passwords are not the same"))));
    }

    @Test
    public void should_be_able_to_verify_validation_for_unique_username_and_unique_email() {

        should_be_able_to_add_an_user();

        givenThat(anna).wasAbleTo(openTheManageUserApplication);

        when(anna).attemptsTo(AddUser.withFollowingDetails("John Doe","john.doe@gmail.com","Passw0rd!","Passw0rd!"));

        then(anna).should(eventually(seeThat(new ErrorMessageOnNewUserFor("name"), is("Must be unique"))));
        then(anna).should(eventually(seeThat(new ErrorMessageOnNewUserFor("email"), is("Must be unique"))));
    }

    @Test
    public void should_be_able_to_verify_validation_for_password_length() {

        givenThat(anna).wasAbleTo(openTheManageUserApplication);

        when(anna).attemptsTo(AddUser.withFollowingDetails("John Doe","john.doe@gmail.com","123","123"));

        then(anna).should(eventually(seeThat(new ErrorMessageOnNewUserFor("password"), is("passwords must be min 6 characters"))));
    }
}