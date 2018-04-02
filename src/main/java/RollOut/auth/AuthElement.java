package RollOut.auth;

import RollOut.Users.RollOutUsers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static RollOut.RollOutConstants.TITLE_SILSO;
import static RollOut.RollOutConstants.URL_NSMS_SITE_TEST;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * @author Golyshkin.Dmitriy on 27.03.2018.
 * Автотест, проверяющий наличие элементов на вкладке с авторизацией
 * TfsTestCase xxx-xxx
 */

@RunWith(value = Parameterized.class)
public class AuthElement extends RollOutUsers {
    public AuthElement(WebDriver driver) {
        super(driver);
    }

    @Before
    public void setUp() {
    }

    @Test
    public void auth() throws InterruptedException {
        driver.get(URL_NSMS_SITE_TEST);
        wait.until(titleIs(TITLE_SILSO));
        driver.findElement(By.className("logo"));
        driver.findElement(By.xpath("//span[text()='ViPNet']"));
        driver.findElement(By.xpath("//span[text()='Network Security Management System']"));
        driver.findElement(By.xpath("//span[text()='© 2018, ОАО «ИнфоТеКС»']"));
        driver.findElement(By.className("language-dropdown-toggle-text"));
        driver.findElement(By.xpath("//label[text()='Имя учетной записи:']"));
        driver.findElement(By.xpath("//label[text()='Пароль:']"));
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
