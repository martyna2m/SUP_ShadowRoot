package chrome;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTestBase {
    public WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
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
