package test.springernature.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import test.springernature.ui.BMCHomePage;

public class OpenBMCApplication implements Task {

    BMCHomePage BMCHomePage;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(BMCHomePage)
        );
    }
}
