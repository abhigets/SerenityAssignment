package net.gmbh.solutions.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AllUsers {

    private static String USER_NAME_LOCATOR = "//*[@id='users']//*[contains(text(),'%s')]";

    public static Target locateUser(String userName) {
        String xpath = String.format(USER_NAME_LOCATOR, userName);
        return Target.the(userName + ": User in all users table").located(By.xpath(xpath));
    }
}
