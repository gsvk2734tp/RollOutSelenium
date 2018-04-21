package RollOut.Users;

import RollOut.auth.RollOutAuthPage;
import RollOut.core.RollOutWeb;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static RollOut.core.RollOutConstants.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * @author Golyshkin.Dmitriy on 28.03.2018.
 * Класс, для работы со страниец Пользователи
 */
//TODO добавить в тесты проверку на наличие пользователей, перед созданием

public abstract class RollOutUsers extends RollOutWeb {

    public RollOutUsers(WebDriver driver) {
        super(driver);
    }

    @Before
    public void setUp() throws InterruptedException {
        RollOutAuthPage authPage = new RollOutAuthPage(driver);
        authPage.logonSilsoDefault();
        selectFirstOrganization();
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    public static boolean checkNumberRegExp(String line) {
        Pattern p;
        if (line.charAt(0) == '+') {
            p = Pattern.compile("^[+0-9][0-9]{2,16}$");
        } else {
            p = Pattern.compile("^[+0-9][0-9]{2,15}$");
        }
        Matcher m = p.matcher(line);
        return m.matches();
    }

    public void selectFirstOrganization() throws InterruptedException {
        driver.get(URL_WINDOWS_USERS);
        wait.until(titleIs(TITLE_APP));
        Thread.sleep(1000);
        clickButton(By.cssSelector("div.header-menu_icon-link"));
        clickButton(By.className("dropdown-menu_item"));
    }

    public void createUsers(int number) throws InterruptedException {
        for (int i = 0; i < number; i++) {
            clickButton(BUTTON_ADD_USER);
            waitElementToBeClickable(TITLE_USER_FORM);
            Thread.sleep(1000);
            createUser("User" + count, "gmail@gmail", "+7876543210");
        }
    }

    public void createUser(String userName, String email, String mobile) throws InterruptedException {
        clickButton(BUTTON_ADD_USER);
        waitElementToBeClickable(TITLE_USER_FORM);
        Thread.sleep(1000);
        inputUserFields(userName, email, mobile);
        clickButton(BUTTON_SAVE_USER);
        waitElementToBeClickable(getUserNameElement("Создан пользователь " + userName));
        count++;
        //Проверка, что пользователь появился в списке
        waitElementToBeClickable(getUserNameElement(userName));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='" + email + "']")));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='" + mobile + "']")));
    }

    public void createUser(String userName, String email, String mobile, String about) throws InterruptedException {
        //Открытие карточки для создания пользователя
        clickButton(BUTTON_ADD_USER);
        waitElementToBeClickable(TITLE_USER_FORM);
        Thread.sleep(1000);
        inputUserFields(userName, email, mobile, about);
        clickButton(BUTTON_SAVE_USER);
        waitElementToBeClickable(getUserNameElement("Создан пользователь " + userName));
        count++;
        //Проверка, что пользователь появился в списке
        waitElementToBeClickable(getUserNameElement(userName));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='" + email + "']")));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='" + mobile + "']")));
    }

    public void createUserNegative(String userName, String email, String mobile) throws InterruptedException {
        //Открытие карточки для создания пользователя
        clickButton(BUTTON_ADD_USER);
        waitElementToBeClickable(TITLE_USER_FORM);
        Thread.sleep(1000);
        if (email == null) {
            inputUserName(userName);
            inputUserPhone(mobile);
            Assert.assertTrue(checkNumberRegExp(getValueText(FIELD_USER_PHONE)));
            checkElementEnabled(BUTTON_SAVE_USER);
            checkElementEmpty(FIELD_ERROR_USER);
            return;
        }
        inputUserFields(userName, email, mobile);
        checkElementDisable(BUTTON_SAVE_USER);
        checkElementEnabled(FIELD_ERROR_USER);
    }

    public void createUserNegativeChechAboutField(String userName, String email, String mobile, String about) throws InterruptedException {
        //Открытие карточки для создания пользователя
        clickButton(BUTTON_ADD_USER);
        waitElementToBeClickable(TITLE_USER_FORM);
        Thread.sleep(1000);
        inputUserFields(userName, email, mobile, about);
        Assert.assertEquals(getValueText(FIELD_USER_ABOUT), (about.substring(0, 128)));
        checkElementEnabled(BUTTON_SAVE_USER);
        checkElementEmpty(FIELD_ERROR_USER);
        //TODO Зайти в описание и проверить, что появилось описание
    }

    public void deleteAllUsers() throws InterruptedException {
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='a']")));
        clickButton(CHECKBOX_SELECT_ALL_USERS);
        waitElementToBeClickable(BUTTON_GROUP_OPER_DELETE_USERS);
        clickButton(BUTTON_DELETE_ALL_USERS);
        waitElementToBeClickable(BUTTON_DELETE_PRESS_YES_USER_AND_ORG);
        clickButton(BUTTON_DELETE_PRESS_YES_USER_AND_ORG);
        Thread.sleep(1000);
    }

    public void editUserPositive(String name, String email, String phone, String about) throws InterruptedException {
        clickButton(getUserNameElement("User" + (count - 1)));
        Thread.sleep(1000);
        if (name != null) {
            inputUserName(name);
        }
        if (email != null) {
            inputUserEmail(email);
        }
        if (phone != null) {
            inputUserPhone(phone);
        }
        if (about != null) {
            inputUserAbout(about);
        }
        driver.findElement((BUTTON_SAVE_USER)).click();
        Thread.sleep(1000);
        if (name != null) {
            waitElementToBeClickable(getUserNameElement(name.trim()));
        }
        if (email != null) {
            waitElementToBeClickable(getUserNameElement(email.trim()));
        }
        if (phone != null) {
            waitElementToBeClickable(getUserNameElement(phone.trim()));
        }
        count--;
    }

    public void editUserNegative(String name, String email, String phone, String about) throws InterruptedException {
        if (count % 2 == 0) clickButton(getUserNameElement("User0"));
        else clickButton(getUserNameElement("User1"));
        Thread.sleep(1000);
        if (name != null) {
            inputUserName(name);
        }
        if (email != null) {
            inputUserEmail(email);
        }
        if (phone != null) {
            inputUserPhone(phone);
            if (phone.length() > 3) {
                Assert.assertTrue(checkNumberRegExp(getValueText(FIELD_USER_PHONE)));
                checkElementEnabled(BUTTON_SAVE_USER);
                checkElementEmpty(FIELD_ERROR_USER);
                count++;
                return;
            }
        }
        if (about != null) {
            inputUserAbout(about);
            Assert.assertEquals(getValueText(FIELD_USER_ABOUT), (about.substring(0, 128)));
            checkElementEnabled(BUTTON_SAVE_USER);
            checkElementEmpty(FIELD_ERROR_USER);
            count++;
            return;
        }
        Thread.sleep(500);
        checkElementDisable(BUTTON_SAVE_USER);
        checkElementEnabled(FIELD_ERROR_USER);
        count++;
    }

    public void inputUserFields(String name, String email, String phone) {
        inputUserName(name);
        inputUserEmail(email);
        inputUserPhone(phone);
    }

    public void inputUserFields(String name, String email, String phone, String about) {
        inputUserName(name);
        inputUserEmail(email);
        inputUserPhone(phone);
        inputUserAbout(about);
    }

    public void inputUserName(String name) {
        driver.findElement(FIELD_USER_NAME).clear();
        inputText(FIELD_USER_NAME, name);
    }

    public void inputUserEmail(String email) {
        driver.findElement(FIELD_USER_EMAIL).clear();
        inputText(FIELD_USER_EMAIL, email);
    }

    public void inputUserPhone(String phone) {
        driver.findElement(FIELD_USER_PHONE).clear();
        inputText(FIELD_USER_PHONE, phone);
    }

    public void inputUserAbout(String about) {
        driver.findElement(FIELD_USER_ABOUT).clear();
        inputText(FIELD_USER_ABOUT, about);
    }

    public By getUserNameElement(String userName) {
        return By.xpath("//td[text()='" + userName + "']");
    }
}
