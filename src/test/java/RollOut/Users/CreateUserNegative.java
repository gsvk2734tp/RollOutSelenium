package RollOut.Users;

import RollOut.core.RandomStr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * @author Golyshkin.Dmitriy on 02.04.2018.
 * Класс, содержащий методы для тестирования пользователей
 * TfsTestCase xxx-xxx
 */

@RunWith(value = Parameterized.class)
public class CreateUserNegative extends RollOutUsers {

    public CreateUserNegative(WebDriver driver) {
        super(driver);
    }

    @Test
    public void createNewUserAndCheckVisible() throws IOException, InterruptedException {
        Thread.sleep(3000); //Пропуск анимации

        /** Проверка имени */
        //TODO Изменили логику, нужно переделать проверку createUserNegative("", "", ""); //Все поля пустые
        //TODO createUserNegative("", "gmail@gmail.com", ""); // пустое user
        /* Проверка на спецсимволы в имени, запрещены, пока что баг 42860
        for (char sumb : specSumbUserName) {
            createUserNegative("User" + sumb, "gmail@gmail.com", "");
        } */

        createUserNegative(RandomStr.getStr(129), "gmail@gmail.com", ""); //имя 129
        createUserNegative(RandomStr.getStr(257), "gmail@gmail.com", ""); //имя 257

        /**Проверка email */
        createUserNegative("User", "@" + "gmail.com", ""); // локальная 0 симв
        createUserNegative("User", RandomStr.getStr(64) + "@" + "gmail.com", ""); // локальная 64 симв

        /* Проверка на спецсимволы в локальной части, запрещены вначале в локальной части, баг 41648
        for (char sumb : specSumb) {
            createUserNegative("User", sumb + "@" + RandomStr.getStr(3), "");
        } */

        createUserNegative("User", "alice" + "@", ""); // доменная 0 симв
        createUserNegative("User", "alice" + "@" + RandomStr.getStr(64), ""); // доменная более 63 без точки
        createUserNegative("User", "1" + "@" + RandomStr.getStrDomain(253), ""); // более 252 симв

        /** Проверка на спецсимволы, запрещены в доменной части */
        //TODO убрать из теста знак '_' после фикса бага
        for (char sumb : specSumb) {
            if (sumb != '-' && sumb != '.' && sumb != '_') createUserNegative("User", "User" + "@" + "gmail" + sumb + "com", "");
        }
        //TODO createUserNegative("User", "User" + "@" + "gmail--com", ""); // не согласовано с требованиями, но в RFC есть правило
        createUserNegative("User", "User" + "@" + "gmail..com", "");


        /**Проверка phone негативные*/
        createUserNegative("User" + count, "gmail@gmail.com", "+7"); //менее 2х симв
        createUserNegative("User" + count, null, "+79212312312331321423154131"); //более 15 симв
        //createUserNegative("User" + count, null, "79212312312331321423154131"); //более 15 симв, баг
        createUserNegative("User" + count, null, "qqqq123"); //буквы
        createUserNegative("User" + count, null, "+ERDFS+123"); //буквы и + вначале
        createUserNegative("User" + count, null, "+7(123)456-78-90"); // маска и + вначале
        createUserNegative("User" + count, null, "   +712132123456789 "); //20 симв с пробелами


        /** Проверка Описания негативные*/
        createUserNegativeChechAboutField("User" + count, "gmail@gmail.com", "+71234", RandomStr.getStr(129)); // 129 симв
        createUserNegativeChechAboutField("User" + count, "gmail@gmail.com", "", RandomStr.getStr(129)); // 129 симв
        createUserNegativeChechAboutField("User" + count, "", "+71234", RandomStr.getStr(129)); // 129 симв
    }
}
