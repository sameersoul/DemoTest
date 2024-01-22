package WebElementOperations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebelementMethod {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\EdgeDriver\\mseedgedriver.exe");

        // Initialize the ChromeDriver
        WebDriver driver = new EdgeDriver();
        driver.get("https://magnus.jalatechnologies.com/Account/Login");

        // Enter login credentials and click on the login button
        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        driver.findElement(By.id("btnLogin")).click();

        
        // Get and print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Get and print the page title
        System.out.println("Page Title: " + driver.getTitle());

        // Get and print the page source
        System.out.println("Page Source: " + driver.getPageSource());
        Thread.sleep(5000);
        driver.navigate().to("https://magnus.jalatechnologies.com/Account/Login");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Login"));

        // Find an element by its ID
        WebElement element = driver.findElement(By.id("UserName"));

        // Get and print the attribute value of the element
        WebElement ele=driver.findElement(By.xpath("//button[@id='btnLogin']"));
        System.out.println("Attribute Value: " + ele.getAttribute("type"));

        // Perform a click on the element
        ele.click();

        // Enter text into an input field
        WebElement inputElement = driver.findElement(By.name("UserName"));
        inputElement.sendKeys("Example Text");

        // Get the size of the element
        System.out.println("Element Size: " + element.getSize());

        // Get the location of the element
        System.out.println("Element Location: " + element.getLocation());

        // Perform other actions as needed using the provided methods

        // Close the current browser window
        driver.close();

        // Quit the WebDriver session
        driver.quit();
    }
}

