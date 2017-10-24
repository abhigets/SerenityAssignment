package test.springernature.features.search;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.Before;
import test.springernature.questions.ArticleDetailsPageTitled;
import test.springernature.questions.MessageOnSearchResultPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import test.springernature.questions.TotalResultsOnSearchResultPage;
import test.springernature.tasks.SelectArticle;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import test.springernature.tasks.OpenBMCApplication;
import test.springernature.tasks.SearchBMCArticles;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class SearchArticleBmcTest {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true, driver = "chrome")
    public WebDriver herBrowser;

    @Steps
    OpenBMCApplication openBMCApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void should_be_able_to_search_an_article_and_view_article_details() {

        givenThat(anna).wasAbleTo(openBMCApplication);

        when(anna).attemptsTo(SearchBMCArticles.withArticleName("Molecular"));
        then(anna).should(eventually(seeThat(new TotalResultsOnSearchResultPage(), greaterThan(107764))));
        and(anna).attemptsTo(SelectArticle.onSearchPageTitled("Molecular Biology And Animal Breeding"));
        then(anna).should(eventually(seeThat(new ArticleDetailsPageTitled("Molecular Biology And Animal Breeding"), is(true))));

    }

    @Test
    public void should_be_able_to_see_valid_message_for_zero_results() {

        givenThat(anna).wasAbleTo(openBMCApplication);

        when(anna).attemptsTo(SearchBMCArticles.withArticleName("IJustWantZeroArticle"));
        then(anna).should(eventually(seeThat(new MessageOnSearchResultPage(), is("Sorry - we couldn't find what you are looking for. Why not..."))));
    }
}