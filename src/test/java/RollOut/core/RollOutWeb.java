package RollOut.core;

import org.junit.Assert;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static RollOut.core.RollOutConstants.*;

/**
 * @author Golyshkin.Dmitriy on 28.03.2018.
 * Главный класс в RollOut
 */

public abstract class RollOutWeb {
    public WebDriver driver;
    public WebDriverWait wait;
    public int count = 0;
    public char[] specSumb = {'!', '#', '$', '%', '&', '\'', '*', '+', '-', '/', '=', '?', '^', '_', '`', '{', '|', '}', '~'};
    public char[] specSumbUserName = {'\\', '/', ':', '*', '?', '"', '<', '>', '|'};

    @Parameterized.Parameters
    public static List<Object> data() {
        Object[] data = new Object[]{
                new ChromeDriver(),
           //       new FirefoxDriver(),
           //        new EdgeDriver()
        };
        return Arrays.asList(data);
    }

    public RollOutWeb(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    public void inputText(By element, String text) {
        WebElement webElement = driver.findElement(element);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public boolean isElementDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }

    public String getValueText(By element) {
        return driver.findElement(element).getAttribute("value");
    }

    public String getText(By element) {
        return driver.findElement(element).getText();
    }

    public void checkElementEnabled(By element) {
        Assert.assertTrue(driver.findElement(element).isEnabled());
    }

    public void checkElementDisable(By element) {
        Assert.assertFalse(driver.findElement(element).isEnabled());
    }

    public void checkElementEmpty(By element) {
        Assert.assertTrue(driver.findElements(element).isEmpty());
    }

    public void clickButton(By element) {
        driver.findElement(element).click();
    }

    public void waitElementToBeClickable(By element) {
        wait.until(ExpectedConditions.elementToBeClickable((element)));
    }

    //TODO разобраться, что делает метод
    public void selectDropdownOption(By element, String value) {
        Select dropdown = new Select(driver.findElement(element));
        dropdown.selectByValue(value);
    }

    public void checkElementLogoInfotecs(String page) {
        if (page.equals("auth")) {
            driver.findElement(LOGO_AUTH);
            driver.findElement(LOGO_NSMS);
        }
        else {
            driver.findElement(LOGO);
            driver.findElement(LOGO_ROC);
        }
        driver.findElement(LOGO_VIPNET);
    }
}


