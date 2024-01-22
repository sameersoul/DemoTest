package Misacelleneous;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

	public class YouTubeVideoInteractionMethods {

	    private static WebDriver driver;
	    private static WebDriverWait wait;

	    public static void main(String[] args) {
	        driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        try {
	            // Navigate to a YouTube video page (replace with the actual video URL)
	            driver.get("https://www.youtube.com/");
	            WebElement searchBar=  wait.until(ExpectedConditions.presenceOfElementLocated( By.xpath("//input[@placeholder='Search']")));
	            searchBar.sendKeys("motu patlu new epsisodes");
	            searchBar.sendKeys(Keys.RETURN);
	            WebElement img=driver.findElement(By.xpath("//yt-formatted-string[.='Motu Patlu | मोटू पतलू | Full Episode | Monkey Kingdom'][1]"));
	            wait.until(ExpectedConditions.elementToBeClickable(img));
	            // Perform actions
	            waitForVideoToLoad();
	            String videoTitle = getVideoTitle();
	            System.out.println("Video Title: " + videoTitle);
	            playVideo();
	            waitForVideoToPlay();
	            pauseVideoAfterPlayback(5000); // Pause after 5 seconds
	            String currentTime = getCurrentVideoTime();
	            System.out.println("Current Time: " + currentTime);
	            increaseVideoVolume();
	            waitForVolumeChange();
	            captureVideoScreenshot("video_player_screenshot.png");
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	    }

	    public static void waitForVideoToLoad() {
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("html5-video-player")));
	    }

	    public static String getVideoTitle() {
	        return driver.findElement(By.xpath("//h1/span[contains(@id, 'title')]")).getText();
	    }

	    public static void playVideo() {
	        WebElement playButton = driver.findElement(By.className("ytp-play-button"));
	        playButton.click();
	    }

	    public static void waitForVideoToPlay() {
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ytp-spinner")));
	    }

	    public static void pauseVideoAfterPlayback(long milliseconds) throws InterruptedException {
	        Thread.sleep(milliseconds);
	        WebElement pauseButton = driver.findElement(By.className("ytp-play-button"));
	        pauseButton.click();
	    }

	    public static String getCurrentVideoTime() {
	        return driver.findElement(By.className("ytp-time-current")).getText();
	    }

	    public static void increaseVideoVolume() {
	        WebElement volumeControl = driver.findElement(By.className("ytp-volume-panel"));
	        Actions actions = new Actions(driver);
	        actions.moveToElement(volumeControl).click().sendKeys("1").perform();  // Increase volume (adjust as needed)
	    }

	    public static void waitForVolumeChange() throws InterruptedException {
	        Thread.sleep(2000);  // Sleep for 2 seconds (adjust as needed)
	    }

	    public static void captureVideoScreenshot(String fileName) {
	        // Capture a screenshot of the video player
	        // Note: You may need to use a screenshot library or adjust the code based on your requirements
	        // For simplicity, this example uses the WebDriver's built-in screenshot capability
	        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	    		File dest =new File("C:\\Users\\DELL\\Pictures\\Saved Pictures\\videoimg.jpg");

	            Files.copy(screenshotFile, dest);
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}



