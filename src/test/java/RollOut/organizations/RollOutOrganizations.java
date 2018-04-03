package RollOut.organizations;

import RollOut.RollOutWeb;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class RollOutOrganizations extends RollOutWeb {
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
}
