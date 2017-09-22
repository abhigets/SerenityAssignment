package net.gmbh.solutions.questions;

import net.gmbh.solutions.ui.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ErrorMessageOnNewUserFor implements Question<String> {
    String field;

    public ErrorMessageOnNewUserFor(String field) {
        this.field = field;
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(RegistrationForm.getErrorMessageLocatorFor(field)).viewedBy(actor).asString();
    }
}
