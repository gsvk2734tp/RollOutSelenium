package RollOut.auth;

import RollOut.core.RollOutWeb;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static RollOut.core.RollOutConstants.URL_WINDOWS_AUTH;

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
    public void changeLanguage (String language) {
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

    public void checkElementLogoInfotecs() {
        driver.findElement(By.className("logo"));
        driver.findElement(By.xpath("//span[text()='ViPNet']"));
        driver.findElement(By.xpath("//span[text()='Network Security Management System']"));
    }

}
