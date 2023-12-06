package firefox;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxTestBase {
    public WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterEach
    void closeDriver() {
        driver.quit();
    }

    protected void openWebsite(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
}
