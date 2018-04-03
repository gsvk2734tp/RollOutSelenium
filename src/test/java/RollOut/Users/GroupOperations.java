package RollOut.Users;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static RollOut.RollOutConstants.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * @author Golyshkin.Dmitriy on 27.03.2018.
 * Автотест, проверяющий групповые операции.
 * TfsTestCase xxx-xxx
 */

@RunWith(value = Parameterized.class)
public class GroupOperations extends RollOutUsers {
    public GroupOperations(WebDriver driver) {
        super(driver);
    }

    @Test
    public void checkGroupOperations() throws InterruptedException {
        //Массовое удаление
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='User1']")));
        driver.findElement(By.cssSelector(CHECKBOX_SELECTALL_USERS)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Удалить пользователей']")));
        driver.findElement(By.cssSelector(BUTTOM_DELETE_ALL_USERS)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BUTTON_DELETE_YES_USER)));
        driver.findElement(By.cssSelector(BUTTON_DELETE_YES_USER)).click();
        Thread.sleep(1000);
    }
}
