package RollOut.organizations;

import RollOut.core.RandomStr;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

/**
 * @author Golyshkin.Dmitriy on 17.04.2018.
 * Автотест, проверяющий позитивные сценарии редактирования Организации
 * TfsTestCase xxx-xxx
 */

@RunWith(value = Parameterized.class)
public class EditOrgPositive extends RollOutOrganizationsPage {
    private String orgName = "Быки и коровы";

    public EditOrgPositive(WebDriver driver) {
        super(driver);
    }

    @Test
    public void editOrgPositive() throws InterruptedException {
        addOrgPositive(orgName, RandomStr.getStr(30));
        editOrgPostive(orgName, RandomStr.getStr(1));
        editOrgPostive(orgName, RandomStr.getStr(19));
        editOrgPostive(orgName, RandomStr.getStr(64));
    }
    @After
    public void deleteOrg() throws InterruptedException {
        deleteOrg(orgName);
    }
}
