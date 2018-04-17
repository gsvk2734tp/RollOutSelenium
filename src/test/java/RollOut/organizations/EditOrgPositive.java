package RollOut.organizations;

//TODO Тест не сделан, блокирующий баг

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static RollOut.RollOutConstants.BUTTON_EDIT_ORG;

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
    public void editOrgPositive() {

    }



}
