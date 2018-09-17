package RollOut.Users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static RollOut.core.RollOutConstants.BUTTON_ADD_USER;

/**
 * @author Golyshkin.Dmitriy on 27.03.2018.
 * Автотест, проверяющий наличие элементов и правильность текстовок на вкладке Пользователи.
 * TfsTestCase xxx-xxx
 */

@RunWith(value = Parameterized.class)
public class UserElement extends RollOutUsers {

    public UserElement(WebDriver driver) {
        super(driver);
    }

    @Test
    public void editUser() throws InterruptedException {
        Thread.sleep(3000); //Пропуск анимации
        //Проверка центральной страницы
        driver.findElement(By.xpath("//h1[contains(text(),'Пользователи Core Network, зарегистрированные в ViPNet Rollout Center')]"));
        driver.findElement(By.xpath("//span[text()='Добавить пользователя']"));
        driver.findElement(By.xpath("//span[contains(text(),'Имя пользователя')]"));
        driver.findElement(By.xpath("//th[contains(text(),'Адрес электронной почты')]"));
        driver.findElement(By.xpath("//th[contains(text(),'Номер телефона')]"));
        driver.findElement(By.xpath("//th[contains(text(),'Статус')]"));
        driver.findElement(By.xpath("//p[text()='Выберите пользователя']"));
        driver.findElement(By.cssSelector("img.properties-image"));

        //Проверка элементов на странице добавления пользователя
        clickAddUserButton();
        driver.findElement(By.xpath("//h1[text()='Новый пользователь']"));
        driver.findElement(By.xpath("//span[text()='Имя пользователя:']"));
        driver.findElement(By.xpath("//span[text()='Адрес электронной почты:']"));
        driver.findElement(By.xpath("//span[text()='Номер телефона:']"));
        driver.findElement(By.xpath("//span[text()='Описание:']"));

        checkElementLogoInfotecs("RollOut");
    }
}
