package test.springernature.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebElement;
import test.springernature.ui.SearchResultPage;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectArticle implements Task{
    private final String title;

    protected SelectArticle(String title){
        this.title = title;
    }

    @Step("Select Article with article for #title")
    public <T extends Actor> void performAs(T actor) {
        /*actor.attemptsTo(
                Click.on(SearchResultPage.getArticleTitleLocator(title))
        );*/
        /*BrowseTheWeb.as(actor).withAction()
                .moveToElement(titleElement,3,10)
                .click()
                .build()
                .perform();*/

        WebElement titleElement = BrowseTheWeb.as(actor)
                .getDriver()
                .findElement(SearchResultPage.getArticleTitleLocator(title));

        String href = titleElement.getAttribute("href");
        BrowseTheWeb.as(actor).getDriver().navigate().to(href);
    }

    public static SelectArticle onSearchPageTitled(String title) {
        return instrumented(SelectArticle.class,title);
    }
}
