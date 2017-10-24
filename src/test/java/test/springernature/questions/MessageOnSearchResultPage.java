package test.springernature.questions;

import test.springernature.ui.Header;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MessageOnSearchResultPage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(Header.ERROR_MESSAGE_LOCATOR).viewedBy(actor).asString();
    }
}
