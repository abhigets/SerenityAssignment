package net.gmbh.solutions.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistrationForm {
    public static Target NAME = Target.the("user field").located(By.id("name"));
    public static Target EMAIL = Target.the("user field").located(By.id("email"));
    public static Target PASSWORD = Target.the("user field").located(By.id("password"));
    public static Target CONFIRM_PASSWORD = Target.the("user field").located(By.id("confirmationPassword"));
    public static String ERROR_MESSAGE_LOCATOR = "user.%s.error";

    public static Target getErrorMessageLocatorFor(String field) {
        String idForErrorMessage = String.format(ERROR_MESSAGE_LOCATOR, field);
        return Target.the("Error Message for " + field).located(By.id(idForErrorMessage));
    }
}
