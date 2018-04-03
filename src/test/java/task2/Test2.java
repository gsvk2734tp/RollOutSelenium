package task2;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
    public WebDriver driver;
    @Test
    public void test(){
        driver = new ChromeDriver();
        driver.get("http://yandex.ru");
        driver.get("http://yandex.ru");
        driver.quit();
    }
}