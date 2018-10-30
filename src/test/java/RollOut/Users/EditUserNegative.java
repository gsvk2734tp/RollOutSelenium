package RollOut.Users;

import RollOut.core.RandomStr;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

/**
 * @author Golyshkin.Dmitriy on 28.03.2018.
 * Автотест, проверяющий негативные сценарии редактирования свойств пользователя.
 * TfsTestCase xxx-xxx
 */

@RunWith(value = Parameterized.class)
public class EditUserNegative extends RollOutUsers {

    public EditUserNegative(WebDriver driver) {
        super(driver);
    }

    @Test
    public void editUsers() throws InterruptedException {
        Thread.sleep(3000);
        createUsers(2);

        /**Проверка имени негативные */
        //TODO editUserNegative("", "", "", ""); // все поля пустые
        editUserNegative("", null, null, null); // пустое user, Edge падает - особенность драйвера

        /* Проверка на спецсимволы в имени, запрещены, пока что баг 42860
        for (char sumb : specSumbUserName) {
            editUserNegative("User" + sumb, null, null, null);1
        } */

        editUserNegative(RandomStr.getStr(129), null, null, null); // имя 129
        editUserNegative(RandomStr.getStr(257), null, null, null); // имя 257

        /**Проверка email негативные*/
        editUserNegative(null, "@gmail.com", null, null); // локальная часть 0
        editUserNegative(null, RandomStr.getStr(64) + "@gmail.com" , null, null); // локальная часть 64

        /* Проверка на спецсимволы в локальной части, запрещены вначале в локальной части, баг 42860
        for (char sumb : specSumb) {
            editUserNegative(null, sumb + "@gmail.com", null, null);
        } */
        editUserNegative(null, "qwe@", null, null); // доменная 0
        editUserNegative(null, "qwe@" + RandomStr.getStr(64), null, null); // доменная более 63 без точки
        editUserNegative(null, "qwe@" + RandomStr.getStrDomain(253), null, null); // более 254 символов

        /** Проверка на спецсимволы, запрещены в доменной части */
        //TODO убрать из теста знак '_' после фикса бага
        for (char sumb : specSumb) {
            if (sumb != '-' && sumb != '.' && sumb != '_') editUserNegative(null, "alice@" + "gmail" + sumb + "com", null, null);
        }

        /**Проверка phone негативные - еще не реализовали валидацию */
        editUserNegative(null, null, "+7", null); //менее 2х симв
        editUserNegative(null, null, "+79212312312331321423154131", null); //более 15 симв
        editUserNegative(null, null, "qqqq+123", null); //буквы
        editUserNegative(null, null, "+ERDFS123", null); //буквы и + вначале
        editUserNegative(null, null, "+7(123)456-78-90", null); //буквы и + вначале
        editUserNegative(null, null, "   +712132123456789 ", null); //20 симв с пробелами
    }

    @After
    public void deleteAllUsersAfterTest() throws InterruptedException {
        deleteAllUsers();
    }
}
