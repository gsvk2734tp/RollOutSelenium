package RollOut.Users;

import RollOut.core.RandomStr;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

import static RollOut.core.RollOutConstants.*;

/**
 * @author Golyshkin.Dmitriy on 27.03.2018.
 * Автотест, проверяющий позитивные сценарии создания пользователя
 * TfsTestCase xxx-xxx
 */

@RunWith(value = Parameterized.class)
public class CreateUserPositive extends RollOutUsers {

    public CreateUserPositive(WebDriver driver) {
        super(driver);
    }

    @Test
    public void createNewUserAndCheckVisible() throws IOException, InterruptedException {
        //Проверка, что поля в карточке пользователя пустые по умолчанию
        Thread.sleep(3000); // Пропуск анимации
        clickButton(BUTTON_ADD_USER);
        waitElementToBeClickable(By.cssSelector("span.header_title"));
        Thread.sleep(1000);
        Assert.assertEquals(getValueText(FIELD_USER_NAME), "");
        Assert.assertEquals(getValueText(FIELD_USER_EMAIL), "");
        Assert.assertEquals(getValueText(FIELD_USER_PHONE), "");
        Assert.assertEquals(getValueText(FIELD_USER_ABOUT), "");

        //Проверка имени позитивные сценарии
        createUser("1", "alice@gmail.com", "+792423154131"); // 1 символ в имени
        createUser("a", "alice@gmail.com", "+792423154131");// 1 буква в имени
        createUser(RandomStr.getStr(128), "alice@gmail.com", "+792423154131"); //128 символов
        //createUser("a", "gmail@gmail.com", "+792423154131"); // имена не уникальны, баг

        //Проверка email позитивные сценарии
        createUser("User" + count, "z@1", "+7123"); // 1 симв
        createUser("User" + count, RandomStr.getStr(63) + "@" + "g", "+7123"); //63 и 1 симв
        //createUser("User" + count, "A" + "@" + RandomStr.getStrDomain(252), "+7123"); // 1 и 252, баг 42892
        createUser("User" + count, "3" + SPEC_SYMBOLS + "@d", "+7123"); // спецсимволы в локальной части
        //createUser("User" + count, (RandomStr.getStr(60) + "@" + RandomStr.getStrDomain(193)), "+7123"); // 254 cимв, баг 42892

        //Проверка телефона позитивные сценарии
        createUser("User" + count, "z@1", "123"); // от трех симв
        createUser("User" + count, "z@1", "+000"); // + вначале
        createUser("User" + count, "z@1", "987654321099999"); // 15 символов
        createUser("User" + count, "z@1", "+987654321099999"); // 15 символов и +
        createUser("User" + count, "alice@gmail.com", "   +7123456789 "); //15 симв с пробелами

        //Проверка Описание позитивные сценарии
        createUser("User" + count, "z@1", "+7123", "."); // 1 симв
        createUser("User" + count, "z@1", "+7123", SPEC_SYMBOLS); // спецсимволы
        createUser("User" + count, "z@1", "+7123", RandomStr.getStr(128)); // 128 симв
    }
    @After
    public void deleteAllUsersAfterTest() throws InterruptedException {
        deleteAllUsers();
    }
}








