package RollOut.organizations;

import RollOut.core.RandomStr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Golyshkin.Dmitriy on 17.04.2018.
 * Автотест, проверяющий негативные сценарии добавления Организации
 * TfsTestCase xxx-xxx
 */

@RunWith(value = Parameterized.class)
public class AddAndDeleteOrgNegative extends RollOutOrganizationsPage {
    private String orgUrl;
    private String orgName = "Быки и коровы";

    public AddAndDeleteOrgNegative(WebDriver driver) {
        super(driver);
    }

    @Test
    public void addAndDeleteOrg() throws InterruptedException {
        //Проверка на ввод более 64 символов
        orgUrl = RandomStr.getStr(128);
        addOrgPositive(orgName, orgUrl);
        checkElementEnabled(By.xpath("//td[text()='" + orgUrl.substring(0,64) + "']"));
        deleteOrg(orgName);

        //Проверка на пустой ввод
        addOrgNegative(orgName, "");

        /*Проверка на кириллицу, блокирующий баг
        addOrgNegative("Быки и коровы", "www + RandomStr.getRusStr(32)");
        addOrgNegative("Быки и коровы", RandomStr.getRusStr(11));
        addOrgNegative("Быки и коровы", RandomStr.getRusStr(64) + Com);
        addOrgNegative("Быки и коровы", 00 + RandomStr.getRusStr(35) + 00);
         */

        /*Проверка на сцепсимволы, блокирующий баг
        for (char sumb : specSumb) {
            addOrgNegative("Быки и коровы","www" + sumb + "com");
        }
         addOrgNegative("Быки и коровы","www com");
         */
    }
}
