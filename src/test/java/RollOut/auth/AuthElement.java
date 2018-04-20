package RollOut.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static RollOut.core.RollOutConstants.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * @author Golyshkin.Dmitriy on 27.03.2018.
 * Автотест, проверяющий наличие элементов на вкладке с авторизацией
 * TfsTestCase xxx-xxx
 */

@RunWith(value = Parameterized.class)
public class AuthElement extends RollOutAuth {
    public AuthElement(WebDriver driver) {
        super(driver);
    }

    @Test
    public void CheckElements() throws InterruptedException {
        driver.get(URL_WINDOWS_AUTH);
        wait.until(titleIs(TITLE_SILSO));

        //Rus
        changeLanguage("ru");
        checkElementLogoInfotecs();
        driver.findElement(By.xpath("//span[text()='© 2018, ОАО «ИнфоТеКС»']"));
        driver.findElement(By.cssSelector(SELECT_LANGUAGE_AUTH));
        driver.findElement(By.xpath("//label[text()='Имя учетной записи:']"));
        driver.findElement(By.xpath("//label[text()='Пароль:']"));
        driver.findElement(By.xpath("//button[text()='Войти']"));

        //English
        Thread.sleep(2000);
        wait.until(titleIs(TITLE_SILSO));
        changeLanguage("en");
        checkElementLogoInfotecs();
        driver.findElement(By.xpath("//span[text()='© 2018, Infotecs']"));
        driver.findElement(By.cssSelector(SELECT_LANGUAGE_AUTH));
        driver.findElement(By.xpath("//label[text()='User name:']"));
        driver.findElement(By.xpath("//label[text()='Password:']"));
        driver.findElement(By.xpath("//button[text()='Log on']"));

        //Deutsch
        driver.get(URL_WINDOWS_AUTH + "");
        Thread.sleep(2000);
        wait.until(titleIs(TITLE_SILSO));
        changeLanguage("de");
        checkElementLogoInfotecs();
        driver.findElement(By.xpath("//span[text()='© 2018, Infotecs']"));
        driver.findElement(By.cssSelector(SELECT_LANGUAGE_AUTH));
        driver.findElement(By.xpath("//label[text()='Benutzername:']"));
        driver.findElement(By.xpath("//label[text()='Passwort:']"));
        driver.findElement(By.xpath("//button[text()='Anmelden']"));

        //Portugues
        driver.get(URL_WINDOWS_AUTH + "");
        Thread.sleep(2000);
        wait.until(titleIs(TITLE_SILSO));
        changeLanguage("pt");
        checkElementLogoInfotecs();
        driver.findElement(By.xpath("//span[text()='© 2018, Infotecs']"));
        driver.findElement(By.cssSelector(SELECT_LANGUAGE_AUTH));
        driver.findElement(By.xpath("//label[text()='Nome de usuário:']"));
        driver.findElement(By.xpath("//label[text()='Senha:']"));
        driver.findElement(By.xpath("//button[text()='Logon']"));
    }
}
