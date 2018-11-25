package test.weatherchecker.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class WeatherCheckerPage {

    public static final Target ERROR_MESSAGE_LOCATOR = Target.the("Error Message").located(By.xpath("//h1"));
    public static Target FIELDS_COUNT_LOCATOR = Target.the("Filed count").located(By.xpath("//tr"));
    public static Target SEARCH_BOX = Target.the("Search Box").located(By.className("search_3"));
    private static String FIELDS_AND_VALUE = "//tr/*[contains(text(),'%s') and ../*[contains(text(),'%s')]]";

    public static Target FIELDS_AND_VALUE_LOCATOR(String fieldValue, String fieldName) {
        String xpath = String.format(FIELDS_AND_VALUE, fieldValue , fieldName);
        return Target.the(fieldName + ":" + fieldValue).located(By.xpath(xpath));
    }
}
