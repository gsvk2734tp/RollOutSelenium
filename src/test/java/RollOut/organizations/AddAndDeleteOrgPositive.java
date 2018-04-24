package RollOut.organizations;

import RollOut.core.RandomStr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Golyshkin.Dmitriy on 17.04.2018.
 * Автотест, проверяющий позитивные сценарии добавления Организации
 * TfsTestCase xxx-xxx
 */

@RunWith(value = Parameterized.class)
public class AddAndDeleteOrgPositive extends RollOutOrganizationsPage {
    private String orgName = "Быки и коровы";

    public AddAndDeleteOrgPositive(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    @Test
    public void addAndDeleteOrg() throws InterruptedException {
        addOrgPositive(orgName, RandomStr.getStr(1));
        deleteOrg(orgName);
        addOrgPositive(orgName, RandomStr.getStr(35));
        deleteOrg(orgName);
        addOrgPositive(orgName, RandomStr.getStr(64));
        deleteOrg(orgName);
    }
}
