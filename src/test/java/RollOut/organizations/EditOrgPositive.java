package RollOut.organizations;

import RollOut.core.RandomStr;
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
public class EditOrgPositive extends RollOutOrganizations {
    public EditOrgPositive(WebDriver driver) {
        super(driver);
    }

    @Test
    public void editOrgPositive() throws InterruptedException {
        addOrgPositive("Быки и коровы", RandomStr.getStr(30));
        editOrgPostive("Быки и коровы", RandomStr.getStr(1));
        editOrgPostive("Быки и коровы", RandomStr.getStr(19));
        editOrgPostive("Быки и коровы", RandomStr.getStr(64));
        deleteOrg("Быки и коровы");
    }
}
