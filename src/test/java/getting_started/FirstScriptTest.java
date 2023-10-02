package getting_started;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstScriptTest {

    @Test
    public void eightComponents(){
        // 1- Start the session*
        WebDriver driver = new ChromeDriver();
        // 2 - Take action on the browser*
        // https://www.selenium.dev/documentation/webdriver/interactions/navigation/ **/
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        // 3 - Request browser information**/
        String title = driver.getTitle();
        assertEquals("Web form", title);

        // 4 - Waiting Strategy - Implicit Wait - by default it is set to 0
        // it waits for an element to load for the given duration and then gives error if not found **/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Find an Element **/
        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        // Take action on element **/
        textBox.sendKeys("Selenium");
        submitButton.click();

        // Request Element Information **/
        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();

        //  Assertion **/
        assertEquals("Received!", value);

        //  close session**/
        driver.quit();
    }

}
