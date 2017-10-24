package test.springernature.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ArticleDetailsPage {

    private static String TITLE_LOCATOR = "//div[@class='MainTitleSection']/h1[contains(text(),'%s')]";

    public static Target getTitleLocator(String title) {
        String xpath = String.format(TITLE_LOCATOR, title);
        return Target.the(title).located(By.xpath(xpath));
    }
}
