package RollOut.Users;

import RollOut.auth.RollOutAuthPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static RollOut.core.RollOutConstants.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * @author Golyshkin.Dmitriy on 17.04.2018.
 * Класс для множественного добавления пользователей, ручной запуск
 * TfsTestCase xxx-xxx
 */

//@RunWith(value = Parameterized.class)
public class CreateMoreUsers extends RollOutUsers {

    public CreateMoreUsers(WebDriver driver) {
        super(driver);
    }

//    @Test
    public void create500Users() throws InterruptedException {
        Thread.sleep(3000);
        for (int i = 0; i < 12000; i++) {
            clickButton(BUTTON_ADD_USER);
            waitElementToBeClickable(TITLE_USER_FORM);
            Thread.sleep(400);
            inputUserFields("UserStep3" + count, "gmail@gmail.com", "+79268762282");
            clickButton(BUTTON_SAVE_USER);
            count++;
            Thread.sleep(400);
        }
    }
}
