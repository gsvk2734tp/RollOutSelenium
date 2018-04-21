package RollOut.organizations;

import RollOut.auth.RollOutAuthPage;
import RollOut.core.RollOutWeb;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static RollOut.core.RollOutConstants.*;

/**
 * @author Golyshkin.Dmitriy on 17.04.2018.
 * Класс, для работы со страниец Организации
 */
//TODO проверка уникальности, после интеграции с NSMS
//TODO после интеграции с NSMS добавить проверку на смену имени Организации

public class RollOutOrganizationsPage extends RollOutWeb {
    public Actions actions;

    public RollOutOrganizationsPage(WebDriver driver) {
        super(driver);
    }

    @Before
    public void setUp() {
        RollOutAuthPage authPage = new RollOutAuthPage(driver);
        authPage.logonSilsoDefault();
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    public void addOrgPositive(String nameOrg, String uri) throws InterruptedException {
        clickButton(BUTTON_ADD_ORG);
        waitElementToBeClickable((FIELD_URI_ORG));
        // Assert.assertEquals(driver.findElement(By.cssSelector(FIELD_NAME_ORG)).getCssValue("text"), "Выберите или введите название новой Организации"); Баг
        Assert.assertEquals(getValueText(FIELD_URI_ORG), "");
        Thread.sleep(1000);
        inputOrgName(nameOrg);
        clickButton(DROPDOWN_SELECT_ORG);
        inputOrgUrl(uri);
        Thread.sleep(100);
        clickButton(BUTTON_SAVE_ORG);
        Thread.sleep(2000);
        waitElementToBeClickable(getOrgNameElement(nameOrg));
    }

    public void deleteOrg(String nameOrg) throws InterruptedException {
        clickButton(getOrgNameElement(nameOrg));
        clickButton(BUTTON_DELETE_ORG);
        clickButton(BUTTON_DELETE_PRESS_YES_USER_AND_ORG);
        Thread.sleep(1000);
        checkElementEnabled(getOrgNameElement(nameOrg));
    }

    public void addOrgNegative(String nameOrg, String uri) throws InterruptedException {
        clickButton(BUTTON_ADD_ORG);
        waitElementToBeClickable(FIELD_URI_ORG);
        Thread.sleep(1000);
        inputOrgName(nameOrg);
        clickButton(DROPDOWN_SELECT_ORG);
        inputOrgUrl(uri);
        //Проверка, что кнопка сохранить не доступна и появилось сообщение об ошибке
        Thread.sleep(500);
        checkElementDisable(BUTTON_SAVE_ORG);
        checkElementEnabled(FIELD_ERROR_ORG);
        clickButton(BUTTON_CANCEL_ORG);
        checkElementEmpty(getOrgNameElement(nameOrg));
    }

    public void editOrgPostive(String nameOrg, String uri) throws InterruptedException {
        clickButton(getOrgNameElement(nameOrg));
        clickButton(BUTTON_EDIT_ORG);
        Thread.sleep(1000);
        Assert.assertEquals(getText(ORG_CUURENT_NAME), nameOrg);
        inputOrgUrl(uri);
        clickButton(BUTTON_SAVE_ORG);
        Thread.sleep(2000);
        waitElementToBeClickable(getOrgNameElement(nameOrg));
    }

    public void editOrgNegative(String nameOrg, String uri) throws InterruptedException {
        clickButton(getOrgNameElement(nameOrg));
        clickButton(BUTTON_EDIT_ORG);
        Thread.sleep(1000);
        Assert.assertEquals(getText(ORG_CUURENT_NAME), nameOrg);
        inputOrgUrl(uri);
        //Проверка, что кнопка сохранить не доступна и появилось сообщение об ошибке
        Thread.sleep(500);
        checkElementDisable(BUTTON_SAVE_ORG);
        checkElementEnabled(FIELD_ERROR_ORG);
        clickButton(BUTTON_CANCEL_ORG);
        checkElementEmpty(getOrgNameElement(nameOrg));
    }

    public void inputOrgName(String name) {
        driver.findElement((FIELD_NAME_ORG)).clear();
        inputText(FIELD_NAME_ORG, name);
    }

    public void inputOrgUrl(String uri) {
        driver.findElement((FIELD_URI_ORG)).clear();
        inputText(FIELD_URI_ORG, uri);
    }

    public By getOrgNameElement(String orgName) {
        return By.xpath("//td[text()='" + orgName + "']");
    }
}
