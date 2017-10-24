package test.springernature.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import test.springernature.ui.Header;

public class SearchBMCArticles implements Task {

    private final String searchTerm;

    protected SearchBMCArticles(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Step("SearchBMCArticles for #name")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(searchTerm)
                        .into(Header.SEARCH_BOX)
                        .thenHit(ENTER)
        );
    }

    public static SearchBMCArticles withArticleName(String searchTerm) {
        return instrumented(SearchBMCArticles.class, searchTerm);
    }

}
