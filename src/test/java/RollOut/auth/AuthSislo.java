package RollOut.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

/**
 * @author Golyshkin.Dmitriy on 27.03.2018.
 * Автотест, проверяющий авторизацию
 * TfsTestCase xxx-xxx
 */

//TODO Тест не сделан, будет доработан после интеграции с NSMS

@RunWith(value = Parameterized.class)
public class AuthSislo extends RollOutAuthPage {
    public AuthSislo(WebDriver driver) {
        super(driver);
    }

    @Test
    public void auth() throws InterruptedException {
        logonSilsoDefault();
    }
}
