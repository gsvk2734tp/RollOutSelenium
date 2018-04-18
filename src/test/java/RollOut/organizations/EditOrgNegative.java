package RollOut.organizations;

import RollOut.RandomStr;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Golyshkin.Dmitriy on 18.04.2018.
 * Автотест, проверяющий негативные сценарии редактирования Организации
 * TfsTestCase xxx-xxx
 */

@RunWith(value = Parameterized.class)
public class EditOrgNegative extends RollOutOrganizations {
    private String orgUrl;

    public EditOrgNegative(WebDriver driver) {
        super(driver);
    }
    @Test
    public void editOrgNegative() throws InterruptedException {
        //Проверка на ввод более 64 символов
        orgUrl = RandomStr.getStr(128);
        editOrgPostive("Ромашка", orgUrl);
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='" + orgUrl.substring(0,64) + "']")).isEnabled());

        /*Проверка на пустой ввод, блокирующий баг
        editOrgNegative("Ромашка", ""); */

        /*Проверка на кириллицу, блокирующий баг
        editOrgNegative("Быки и коровы", "www + RandomStr.getRusStr(32)");
        editOrgNegative("Быки и коровы", RandomStr.getRusStr(11));
        editOrgNegative("Быки и коровы", RandomStr.getRusStr(64) + Com);
        editOrgNegative("Быки и коровы", 00 + RandomStr.getRusStr(35) + 00);
         */

        /*Проверка на сцепсимволы, блокирующий баг
        for (char sumb : specSumb) {
            editOrgNegative("Быки и коровы","www" + sumb + "com");
        }
         editOrgNegative("Быки и коровы","www com");
         */
    }
}
