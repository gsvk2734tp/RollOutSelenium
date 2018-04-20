package RollOut.auth;

import RollOut.RollOutWeb;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static RollOut.RollOutConstants.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
/**
 * @author Golyshkin.Dmitriy on 28.03.2018.
 * Класс, для работы со страниец Авторизации
 */

public class RollOutAuth extends RollOutWeb {

    public RollOutAuth(WebDriver driver) {
        super(driver);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
