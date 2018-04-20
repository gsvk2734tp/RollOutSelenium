package RollOut.Users;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static RollOut.RollOutConstants.BUTTON_DELETE_USER;
import static RollOut.RollOutConstants.BUTTON_DELETE_PRESS_YES_USER_AND_ORG;

/**
 * @author Golyshkin.Dmitriy on 27.03.2018.
 * Автотест, проверяющий удаление пользователя.
 * TfsTestCase xxx-xxx
 */

@RunWith(value = Parameterized.class)
public class DeleteUser extends RollOutUsers {

    public DeleteUser(WebDriver driver) {
        super(driver);
    }

    @Test
    public void deleteUsersAndCheckVisible() throws InterruptedException {
        int number = 3;
        Thread.sleep(1000);
        createUsers(number);

        for (int i = number - 1; i >= 0; i--) {
            driver.findElement(By.xpath("//td[text()='User" + i + "']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BUTTON_DELETE_USER)));
            driver.findElement(By.cssSelector(BUTTON_DELETE_USER)).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BUTTON_DELETE_PRESS_YES_USER_AND_ORG)));
            driver.findElement(By.cssSelector(BUTTON_DELETE_PRESS_YES_USER_AND_ORG)).click();
            Thread.sleep(2000);
            //Проверяем, что пользователь удален
            Assert.assertTrue(driver.findElements(By.xpath("//td[text()='User" + i + "']")).isEmpty());
        }
    }
}
