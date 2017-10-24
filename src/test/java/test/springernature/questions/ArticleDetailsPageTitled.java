package test.springernature.questions;

import test.springernature.ui.ArticleDetailsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;

public class ArticleDetailsPageTitled implements Question<Boolean> {
    String title;

    public ArticleDetailsPageTitled(String title) {
        this.title = title ;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Presence.of(ArticleDetailsPage.getTitleLocator(title)).viewedBy(actor).asBoolean();
    }
}
