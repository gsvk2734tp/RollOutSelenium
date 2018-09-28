package RollOut.organizations;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static RollOut.core.RollOutConstants.*;

/**
 * @author Golyshkin.Dmitriy on 28.03.2018.
 * Автотест, проверяющий видимость элементов на странице с Организациями
 * TfsTestCase xxx-xxx
 */

//TODO: Проверить видимость элементов боковой панели
//TODO: Проверка видимость элементов на верхней панели

@RunWith(value = Parameterized.class)
public class OrgElement extends RollOutOrganizationsPage {

    public OrgElement(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    @Test
    public void checkElementsVisiable() throws InterruptedException {
        //Проверка текстовок и всех элементов на центральной странице
        driver.findElement(By.xpath("//h1[contains(text(),'Организации, зарегистрированные в ViPNet Rollout Center')]"));
        driver.findElement(By.xpath("//a[text()='Добавить организацию']"));
        driver.findElement(By.xpath("//th[text()='Название']"));
        driver.findElement(By.xpath("//th[text()='Поддомен']"));
        driver.findElement(By.xpath("//td[text()='Core Network']"));

        //Проверка невидимого элемента Редактировать у первой в списке Орг
        clickButton(By.xpath("//td[text()='Core Network']")); // Делает данную организацию активной, все проверки далее идут с ней
        checkElementEnabled(BUTTON_EDIT_ORG);

        //TODO добавить недостающие поля и поля со 2 вкладки Проверка элементов в карточке Организации
        clickButton(BUTTON_EDIT_ORG);
        driver.findElement(By.xpath("//div[contains(text(),'Данные организации в ViPNet Rollout Center')]"));
        driver.findElement(By.xpath("//div[contains(text(),'Название:')]"));
        driver.findElement(By.xpath("//div[contains(text(),'Поддомен:')]"));
        clickButton(BUTTON_CANCEL_ORG);
        Thread.sleep(1000);

        //Проверка невидимого элемента Удалить
        checkElementEnabled(BUTTON_DELETE_ORG);
        //Проверка элементов в карточке подтверждения удаления организации
        clickButton(BUTTON_DELETE_ORG);
        driver.findElement(By.xpath("//div[contains(text(),'Удаление организации')]"));
        driver.findElement(By.xpath("//div[contains(text(),'Подтвердите удаление')]"));
        clickButton(BUTTON_CANCEL_ORG);
        Thread.sleep(1000);

        //Проверка лого
        checkElementLogoInfotecs("RollOut");
    }
}
