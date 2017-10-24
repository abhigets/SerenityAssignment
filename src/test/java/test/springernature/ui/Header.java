package test.springernature.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Header {
    public static Target SEARCH_BOX = Target.the("search box").located(By.id("publisherSearch"));
    public static Target ERROR_MESSAGE_LOCATOR = Target.the("Error message on page").located(By.xpath("//div[@id='search-container']//h3"));
    public static Target RESULT_COUNT_LOCATOR = Target.the("Result count").located(By.cssSelector(".ResultsCount"));
}
