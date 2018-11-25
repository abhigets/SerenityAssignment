package test.weatherchecker.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class WeatherCheckerPage {

    public static Target SEARCH_BOX = Target.the("Search Box").located(By.className("search_3"));
    public static final Target SEARCH_BUTTON = Target.the("Search Button").located(By.className("submit_3"));
    public static final Target ERROR_MESSAGE_LOCATOR = Target.the("Error Message").located(By.xpath("//h1"));
    public static Target FIELDS_COUNT_LOCATOR = Target.the("Filed count").located(By.xpath("//tr"));
    private static String FIELDS_AND_VALUE = "//tr/*[contains(text(),'%s')]/following-sibling::td";

    public static Target FIELDS_AND_VALUE_LOCATOR(String fieldName) {
        String xpath = String.format(FIELDS_AND_VALUE,  fieldName);
        return Target.the(fieldName).located(By.xpath(xpath));
    }
}
