package net.gmbh.solutions.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import net.gmbh.solutions.ui.ManageUserPage;

public class OpenTheManageUserApplication implements Task {

    ManageUserPage manageUserPage;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(manageUserPage)
        );
    }
}
