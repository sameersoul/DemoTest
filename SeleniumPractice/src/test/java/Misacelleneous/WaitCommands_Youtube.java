package Misacelleneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitCommands_Youtube {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // Set the path to your EdgeDriver executable
        System.setProperty("webdriver.edge.driver", "C:\\Selenium\\EdgeDriver\\msedgedriver.exe");
        // Initialize the EdgeDriver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to the webpage
        driver.get("https://www.youtube.com");
        WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        // Wait.until(ExpectedConditions.("csackas"));
        searchBar.sendKeys("motu patlu new episodes");
        searchBar.sendKeys(Keys.RETURN);
        PlayVideo();
        String VideoTitle= getVideoTitle();
        System.out.println("Video Title: " + VideoTitle);
        pauseVideoAfterPlayback(5000);
    }

    public static void PlayVideo() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//*[@title=\"Motu Patlu | मोटू पतलू | Full Episode | Monkey Kingdom\"])[1]")).click();
        Thread.sleep(5000);
        //driver.quit();
    }
    public static String getVideoTitle() {
    	return driver.findElement(By.xpath("(//*[@title=\"Motu Patlu | मोटू पतलू | Full Episode | Monkey Kingdom\"])[1]")).getAttribute("title")
;    }
    public static void pauseVideoAfterPlayback(long milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
     
        // Create Actions object
        Actions actions = new Actions(driver);

        // Simulate pressing the "k" key to pause the video
        actions.sendKeys(Keys.chord("k")).perform();
    }

}
