package test.springernature.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchResultPage {

    public static String ARTICLE_TITLE_LOCATOR = "//a[contains(text(),'%s')]";

    public static By getArticleTitleLocator(String title) {
    //public static Target getArticleTitleLocator(String title) {
        String xpathForArticleTitle = String.format(ARTICLE_TITLE_LOCATOR, title);
        //return Target.the("Article Titled " + title).located(By.xpath(xpathForArticleTitle));
        return By.xpath(xpathForArticleTitle);
    }
}
