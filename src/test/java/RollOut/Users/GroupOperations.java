package RollOut.Users;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

/**
 * @author Golyshkin.Dmitriy on 27.03.2018.
 * Автотест, проверяющий групповые операции.
 * TfsTestCase xxx-xxx
 */

@RunWith(value = Parameterized.class)
public class GroupOperations extends RollOutUsers {
    public GroupOperations(WebDriver driver) {
        super(driver);
    }

    @Test
    public void checkGroupOperations() throws InterruptedException {
        //Массовое удаление
        createUsers(10);
        deleteAllUsers();
    }
}
