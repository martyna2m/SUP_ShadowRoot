package chrome;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ShadowRootTest extends TestBase {

    @Test
    void getShadowRootsWithSearchContext() {

        openWebsite("chrome://downloads/");
        //   driver.findElement(By.cssSelector("#searchInput")).sendKeys("Hello");

        WebElement shadowHost1 = driver.findElement(By.cssSelector("downloads-manager"));
        SearchContext shadowRoot1 = shadowHost1.getShadowRoot();

        WebElement shadowHost2 = shadowRoot1.findElement(By.cssSelector("#toolbar"));
        SearchContext shadowRoot2 = shadowHost2.getShadowRoot();

        WebElement shadowHost3 = shadowRoot2.findElement(By.cssSelector("#toolbar"));
        SearchContext shadowRoot3 = shadowHost3.getShadowRoot();

        WebElement shadowHost4 = shadowRoot3.findElement(By.cssSelector("#centeredContent>#search"));
        SearchContext shadowRoot4 = shadowHost4.getShadowRoot();

        shadowRoot4.findElement(By.cssSelector("#searchInput")).sendKeys("Hi");

    }





    @Test
    @Tag("basic")
    void getShadowRootsWithSearchContext2() {
        openWebsite("chrome://downloads/");

        WebElement searchInput = driver.findElement(By.cssSelector("downloads-manager")).getShadowRoot()
                .findElement(By.cssSelector("#toolbar")).getShadowRoot()
                .findElement(By.cssSelector("#toolbar")).getShadowRoot()
                .findElement(By.cssSelector("#centeredContent>#search")).getShadowRoot()
                .findElement(By.cssSelector("#searchInput"));

        searchInput.sendKeys("Hello");

    }




    @Test
    void getShadowRootWithJs() {
        openWebsite("chrome://downloads/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement searchInput = (WebElement) jse.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar').shadowRoot.querySelector('cr-toolbar').shadowRoot.querySelector('#centeredContent>#search').shadowRoot.querySelector('#content>#searchTerm').querySelector('#searchInput')");
        searchInput.sendKeys("Hello");

     //   String js = "arguments[0].setAttribute('value', 'Hello')";
     //   ((JavascriptExecutor) driver).executeScript(js, searchInput);

    }
}
