package firefox;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ShadowRootTest extends TestBase {

    @Test
    void getShadowRootsWithSearchContext() {

        openWebsite("about:preferences");

        WebElement shadowHost1 = driver.findElement(By.cssSelector("#searchInput"));
        SearchContext shadowRoot1 = shadowHost1.getShadowRoot();

        WebElement searchInput = shadowRoot1.findElement(By.cssSelector("input"));
        searchInput.sendKeys("Hello");

    }

    @Test
    @Tag("basic")
    void getShadowRootsWithSearchContext2() {
        openWebsite("about:preferences");
        WebElement searchInput = driver.findElement(By.cssSelector("#searchInput")).getShadowRoot().findElement(By.cssSelector("input"));
        searchInput.sendKeys("Hello");

    }

    @Test
    void getShadowRootWithJs() {
        openWebsite("about:preferences");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement searchInput = (WebElement) jse.executeScript("return document.querySelector('#searchInput').shadowRoot.querySelector('input')");
        searchInput.sendKeys("Hello");


    }

}
