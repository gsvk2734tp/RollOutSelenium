package RollOut.organizations;

import RollOut.RollOutWeb;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static RollOut.RollOutConstants.*;

/**
 * @author Golyshkin.Dmitriy on 17.04.2018.
 * Класс, для работы со страниец Организации
 */

public class RollOutOrganizations extends RollOutWeb {
    public Actions actions;

    public RollOutOrganizations(WebDriver driver) {
        super(driver);
    }

    @Before
    public void setUp() {
        logonSilsoDefault();
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    public void addOrg(String nameOrg, String uri) throws InterruptedException {
        driver.findElement(By.cssSelector(BUTTON_ADD_ORG)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(FIELD_URI_ORG)));
        // Assert.assertEquals(driver.findElement(By.cssSelector(FIELD_NAME_ORG)).getCssValue("text"), "Выберите или введите название новой Организации"); Баг
        Assert.assertEquals(driver.findElement(By.cssSelector(FIELD_URI_ORG)).getCssValue("text"), "");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(FIELD_NAME_ORG)).sendKeys(nameOrg + Keys.ENTER);
        driver.findElement(By.cssSelector(FIELD_URI_ORG)).sendKeys(uri);
        driver.findElement(By.cssSelector(BUTTON_SAVE_ORG)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//td[text()='" + nameOrg + "']"))));
    }

    public void deleteOrg(String nameOrg) throws InterruptedException {
        driver.findElement(By.xpath("//td[text()='" + nameOrg + "']")).click();
        driver.findElement(By.cssSelector(BUTTON_DELETE_ORG)).click();
        driver.findElement(By.cssSelector(BUTTON_DELETE_PRESS_YES_USER_AND_ORG)).click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElements(By.xpath("//td[text()='" + nameOrg + "']")).isEmpty());
    }

    public void addOrgNegative(String nameOrg, String uri) throws InterruptedException {
        driver.findElement(By.cssSelector(BUTTON_ADD_ORG)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(FIELD_URI_ORG)));
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(FIELD_NAME_ORG)).sendKeys(nameOrg + Keys.ENTER);
        driver.findElement(By.cssSelector(FIELD_URI_ORG)).sendKeys(uri);
        //Проверка, что кнопка сохранить не доступна и появилось сообщение об ошибке
        Thread.sleep(500);
        Assert.assertFalse(driver.findElement(By.cssSelector(BUTTON_SAVE_ORG)).isEnabled());
        Assert.assertTrue(driver.findElement(By.cssSelector(FIELD_ERROR_ORG)).isEnabled());
        driver.findElement(By.cssSelector(BUTTON_CANCEL_ORG)).click();
        Assert.assertTrue(driver.findElements(By.xpath("//td[text()='" + nameOrg + "']")).isEmpty());
    }
    public void editOrgPostive(String nameOrg, String uri) throws InterruptedException {
        driver.findElement(By.xpath("//td[text()='" + nameOrg + "']")).click();
        driver.findElement(By.cssSelector(BUTTON_EDIT_ORG)).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector(FIELD_NAME_ORG)).getCssValue("text"), nameOrg);
        driver.findElement(By.cssSelector(FIELD_URI_ORG)).clear();
        driver.findElement(By.cssSelector(FIELD_URI_ORG)).sendKeys(uri);
    }
}
