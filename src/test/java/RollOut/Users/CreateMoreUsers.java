package RollOut.Users;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static RollOut.RollOutConstants.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * @author Golyshkin.Dmitriy on 17.04.2018.
 * Класс для множественного добавления пользователей, ручной запуск
 * TfsTestCase xxx-xxx
 */

public class CreateMoreUsers {
    WebDriver driver;
    WebDriverWait wait;
    int count = 0;

//    @Test
    public void create500Users() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.get(URL_NSMS_SITE);
        wait.until(titleIs(TITLE_SILSO));
        driver.findElement(By.id("UserName")).sendKeys("alice");
        driver.findElement(By.id("Password")).sendKeys("P@ssw0rd");
        driver.findElement(By.cssSelector(BUTTON_LOGIN)).click();
        wait.until(titleIs(TITLE_APP));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='Ромашка']")));
        driver.get(URL_NSMS_USERS);
        Thread.sleep(5000);
        for (int i = 0; i < 20; i++) {
            driver.findElement(By.cssSelector(BUTTON_ADD_USER)).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.header_title")));
            Thread.sleep(2000);
            List<WebElement> elements = driver.findElements(By.cssSelector("div.host_input input"));
            elements.get(0).sendKeys("User" + count);
            elements.get(1).sendKeys("q@q");
            elements.get(2).sendKeys("+79251234444");
            driver.findElement(By.cssSelector("textarea")).sendKeys("123qwe");
            driver.findElement(By.cssSelector(BUTTON_SAVE_USER)).click();
            count++;
            Thread.sleep(1000);
        }
    }
}
