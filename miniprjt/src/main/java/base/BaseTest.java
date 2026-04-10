package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import utils.BrowserFactory;
import utils.ConfigReader;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        ConfigReader.loadConfig();
        String browser = ConfigReader.get("browser");
        driver = BrowserFactory.getDriver(browser);
        driver.get(ConfigReader.get("url"));
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}