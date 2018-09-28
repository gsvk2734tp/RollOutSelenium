package RollOut.organizations;

import RollOut.core.RandomStr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static RollOut.core.RollOutConstants.orgName;

/**
 * @author Golyshkin.Dmitriy on 17.04.2018.
 * Автотест, проверяющий негативные сценарии добавления Организации
 * TfsTestCase xxx-xxx
 */

@RunWith(value = Parameterized.class)
public class AddAndDeleteOrgNegative extends RollOutOrganizationsPage {

    public AddAndDeleteOrgNegative(WebDriver driver) {
        super(driver);
    }

    @Test
    public void addAndDeleteOrg() throws InterruptedException {
        String orgUrl = RandomStr.getStr(128);

        //Проверка на ввод более 64 символов
        addOrgPositive(orgName, orgUrl);
        checkElementEnabled(By.xpath("//td[text()='" + orgUrl.substring(0,63) + "']"));
        deleteOrg(orgName);

        //TODO Проверка на пустой ввод (кнопка сохранить не активна
        addOrgNegative(orgName, " ");

        //Проверка на кириллицу, блокирующий баг
        addOrgNegative("Сеть организации 1", "www" + RandomStr.getRusStr(32));
        addOrgNegative("Сеть организации 1", RandomStr.getRusStr(11));
        addOrgNegative("Сеть организации 1", RandomStr.getRusStr(64) + "com");
        addOrgNegative("Сеть организации 1", 00 + RandomStr.getRusStr(35) + 00);

        //Проверка на сцепсимволы, блокирующий баг
        for (char sumb : specSumb) {
            addOrgNegative("Сеть организации 1","www" + sumb + "com");
        }
         addOrgNegative("Сеть организации 1","www com");
    }
}
