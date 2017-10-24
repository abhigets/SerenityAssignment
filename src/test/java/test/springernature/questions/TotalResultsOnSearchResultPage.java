package test.springernature.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import test.springernature.ui.Header;

public class TotalResultsOnSearchResultPage implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return Text.of(Header.RESULT_COUNT_LOCATOR).viewedBy(actor).asInteger();
    }
}
