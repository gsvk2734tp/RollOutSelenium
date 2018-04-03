package RollOut.auth;

import RollOut.RollOutWeb;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static RollOut.RollOutConstants.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

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

    public void logonSilsoDefault() {
        driver.get(URL_WINDOWS_SITE);
        wait.until(titleIs(TITLE_SILSO));
        driver.findElement(By.id("UserName")).sendKeys(LOGIN);
        driver.findElement(By.id("Password")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector(BUTTON_LOGIN)).click();
        wait.until(titleIs(TITLE_APP));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='Ромашка']")));
    }

}
