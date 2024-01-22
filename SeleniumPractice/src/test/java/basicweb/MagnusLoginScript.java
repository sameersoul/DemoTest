package basicweb;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MagnusLoginScript {

    private static WebDriver driver;

    public static void main(String[] args) {
        // Set the system property for the Edge driver
        System.setProperty("webdriver.edge.driver", "C:\\Selenium\\EdgeDriver\\msedgedriver.exe");

        // Create a WebDriver instance
        driver = new EdgeDriver();

        // Execute the testValidLogin script
        try {
            testValidLogin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }

    public static void testValidLogin() throws InterruptedException {
        // Enter valid credentials
        driver.get("https://magnus.jalatechnologies.com/Account/Login");
        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");

        boolean isLoginPage = true;

        // Loop to click the login button and refresh the page until the expected element on the home page is present
        while (isLoginPage) {
            // Click on the login button
            driver.findElement(By.id("btnLogin")).click();

            // Use WebDriverWait to wait for the expected condition (element to be present on home page)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
            WebElement welcomeMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='fa fa-dashboard']")));

            // Check if the welcomeMessage element is present on the home page
            if (welcomeMessage.isDisplayed()) {
                System.out.println("Test Case: Valid Login - Passed");
                isLoginPage = false; // Break the loop if on the home page
            } else {
                // Refresh the login page if not on the home page
                driver.navigate().refresh();
            }
        }
    }
}
