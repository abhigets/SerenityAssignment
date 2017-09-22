package net.gmbh.solutions.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import net.gmbh.solutions.ui.RegistrationForm;

public class AddUser implements Task {

    private final String name;
    private final String email;
    private final String pwd;
    private final String confirmPwd;

    protected AddUser(String name, String email, String pwd, String confirmPwd) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.confirmPwd = confirmPwd;
    }

    @Step("AddUser for #name")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(name)
                        .into(RegistrationForm.NAME),
                Enter.theValue(email)
                        .into(RegistrationForm.EMAIL),
                Enter.theValue(pwd)
                        .into(RegistrationForm.PASSWORD),
                Enter.theValue(confirmPwd)
                        .into(RegistrationForm.CONFIRM_PASSWORD)
                        .thenHit(ENTER)
        );
    }

    public static AddUser withFollowingDetails(String name, String email, String pwd, String confirmPwd) {
        return instrumented(AddUser.class, name, email, pwd, confirmPwd);
    }

}
