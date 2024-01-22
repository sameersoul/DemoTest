package basicweb;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTestclass {

    public static void main(String[] args) {
        // Set the system property for the Edge driver
        System.setProperty("webdriver.chrome.driver", "./SeleniumPractice/src/msedgedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new EdgeDriver();

        // Navigate to the website
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        // Find the search box element
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));

        // Type a search query
        searchBox.sendKeys("Selenium WebDriver");

        // Submit the form
        searchBox.submit();

        // Use WebDriverWait to wait for the search results title to contain the search query
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        Boolean searchResultsTitle = wait.until(ExpectedConditions.titleContains("Selenium WebDriver"));

        // Print the search results title
        System.out.println("Search Results Title: " + searchResultsTitle);

        // Close the browser
        driver.quit();
    }
}
