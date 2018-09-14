package RollOut.auth;

import RollOut.core.RollOutWeb;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static RollOut.core.RollOutConstants.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * @author Golyshkin.Dmitriy on 28.03.2018.
 * Класс, для работы со страниец Авторизации
 */

public class RollOutAuthPage extends RollOutWeb {

    public RollOutAuthPage(WebDriver driver) {
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

    public void inputUserName(String userName) {
        inputText(NAME_FIElD, userName);
    }

    public void inputPassword(String password) {
        inputText(PASSWORD_FIELD, password);
    }

    public void clickLogin() {
        clickButton(LOGIN_BUTTON);
    }

    public void logonSilsoDefault() {
        driver.get(URL_WINDOWS_SITE);
        wait.until(titleIs(TITLE_SILSO));
        inputUserName(LOGIN);
        inputPassword(PASSWORD);
        clickLogin();
        wait.until(titleIs(TITLE_APP));
        waitElementToBeClickable(By.xpath("//td[text()='Core Network']"));
        clickButton(By.xpath("//td[text()='Core Network']"));

    }

    public void logonSilso(String userName, String password) {
        driver.get(URL_WINDOWS_SITE);
        wait.until(titleIs(TITLE_SILSO));
        inputUserName(userName);
        inputPassword(password);
        clickLogin();
        wait.until(titleIs(TITLE_APP));
        waitElementToBeClickable(By.xpath("//td[text()='Core Network']"));
    }


    public void changeLanguage(String language) {
        switch (language) {
            case "en": {
                driver.get(URL_WINDOWS_AUTH + "/Home/ChangeLanguage?culture=en-US&returnUrl=%2FAuthenticationInfo");
                break;
            }
            case "de": {
                driver.get(URL_WINDOWS_AUTH + "/Home/ChangeLanguage?culture=de-DE&returnUrl=%2FAuthenticationInfo");
                break;
            }
            case "pt": {
                driver.get(URL_WINDOWS_AUTH + "/Home/ChangeLanguage?culture=pt-BR&returnUrl=%2FAuthenticationInfo");
                break;
            }
            case "ru": {
                driver.get(URL_WINDOWS_AUTH + "/Home/ChangeLanguage?culture=ru-RU&returnUrl=%2FAuthenticationInfo");
                break;
            }
        }
    }
}
