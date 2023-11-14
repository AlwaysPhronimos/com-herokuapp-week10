import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-3 - ProjectName : com-herokuapp
 * BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Refresh the page.
 * 11. Close the browser.
 */
public class herokuapp {
    static String browser = "Chrome";
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
       if (browser.equalsIgnoreCase("Chrome")) {
           driver = new ChromeDriver();
       } else if (browser.equalsIgnoreCase("Firefox")) {
           driver = new FirefoxDriver();
       } else if (browser.equalsIgnoreCase("Edge")) {
           driver = new EdgeDriver();
       } else {
           System.out.println("Wrong Browser Name");
       }

       // Open URL.
        driver.get(baseUrl);
       Thread.sleep(4000);

       // Maximize the browser
        driver.manage().window().maximize();

        // we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //get the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        // Get current url
        System.out.println("The current Url " + driver.getCurrentUrl());

        // print page source
        System.out.println(driver.getPageSource());

        // Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys("tomsmith" );
        Thread.sleep(4000);

        //Enter the password to password field.
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        Thread.sleep(4000);

        //Click on Login Button.
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();
        Thread.sleep(4000);

        // Print the current url.
        String currentUrl = "https://the-internet.herokuapp.com/secure";
        System.out.println(driver.getCurrentUrl());

        // Refresh the page.
        driver.navigate().refresh();
        Thread.sleep(4000);

        //Close the browser.
        driver.quit();
    }
}
