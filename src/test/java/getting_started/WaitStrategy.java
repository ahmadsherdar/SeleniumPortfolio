package getting_started;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitStrategy {

    @Test
    public void eightComponents(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");


        //  Waiting Strategy - Implicit Wait - by default it is set to 0
        // it waits for an element to load for the given duration and then gives error if not found **/
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
            driver.findElement(By.id("adder")).click();

        // WebElement added = driver.findElement(By.id("box0"));

        //  Waiting Strategy - Explicit Wait - a condition is set to be true if it doesn't get true within the
        // defined waited time then it throughs an error**/
        WebElement revealed = driver.findElement(By.id("revealed"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

            driver.findElement(By.id("reveal")).click();
            wait.until(d -> revealed.isDisplayed());

            revealed.sendKeys("Displayed");
        // Explanation of above ExplicitWait Code
        // This code snippet appears to be written in Java and is related to web automation using Selenium WebDriver. Let's break down the code step by step:
        //
        //  WebElement revealed = driver.findElement(By.id("revealed"));
        //
        //  Here, you're declaring a variable revealed of type WebElement. This variable represents an HTML element on a web page.
        // driver.findElement(By.id("revealed")) is used to find an HTML element on the web page with the attribute id equal to "revealed." This method returns a WebElement object that represents the found element.
        //  So, revealed now refers to the HTML element with the ID "revealed" on the web page.
        //  Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        //
        //  This line is creating a WebDriverWait object named wait. WebDriverWait is a class in Selenium used for waiting for specific conditions to be met before proceeding with the test.
        //  driver is the WebDriver instance that presumably was created earlier in your test script.
        //  Duration.ofSeconds(2) specifies a timeout of 2 seconds. It means that the WebDriverWait will wait for up to 2 seconds for a condition to be true.
        //  driver.findElement(By.id("reveal")).click();
        //
        //  This line finds an HTML element with the ID "reveal" and then simulates a click action on it using the click() method.
        //  It's assumed that clicking this element triggers an action on the web page that eventually leads to the element with ID "revealed" becoming visible or displayed.
        //  wait.until(d -> revealed.isDisplayed());
        //
        //  This is where the WebDriverWait comes into play. It's waiting until a specific condition is met before proceeding.
        //  revealed.isDisplayed() is a condition. It checks whether the revealed element is displayed on the web page. If it is, the condition is true; otherwise, it's false.
        //  The wait.until() method waits for the condition to become true or until the specified timeout (2 seconds in this case) is reached.
        //  revealed.sendKeys("Displayed");
        //
        //  Once the condition is met (i.e., the revealed element is displayed), this line simulates typing the text "Displayed" into that element using the sendKeys() method.
        //  In summary, this code is essentially automating a web interaction scenario where it finds and clicks an element, waits for another element to become displayed,
        //  and then enters text into that displayed element. It's a common pattern in web automation to ensure that interactions occur when elements are ready and visible on the page. **/
        }
}
