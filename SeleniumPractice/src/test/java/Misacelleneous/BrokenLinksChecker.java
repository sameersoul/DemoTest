package Misacelleneous;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
	import java.net.HttpURLConnection;
	import java.net.URL;
import java.time.Duration;

	public class BrokenLinksChecker {

	    public static void main(String[] args) {
	        // Set the path to your ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\EdgeDriver\\mseedgedriver.exe");
	        // Initialize the ChromeDriver
	        WebDriver driver = new EdgeDriver();

	        // Navigate to the webpage
	        driver.get("https://magnus.jalatechnologies.com/Account/Login");

	        // Enter login credentials and click on the login button
	        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
	        driver.findElement(By.id("Password")).sendKeys("jobprogram");
	        driver.findElement(By.id("btnLogin")).click();
	        
	        // Wait for the home page title to be "Magnus"
     		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
     		wait.until(ExpectedConditions.titleIs("Magnus"));
     	      
     	     // Navigate to the more dropdown
     	     WebElement moredropdown = driver.findElement(By.xpath("(//i[@class='fa fa-angle-left pull-right'])[2]"));
     	     moredropdown.click();
     	     
     	    //Navigate to links button and click it
     	     WebElement LinksButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href='/Home/Links']")));
     	     LinksButton.click();
     	     
     	     //Now click on broken links tab
     	     WebElement brokenlink= driver.findElement(By.xpath("//a[.='Broken Links']"));
     	     brokenlink.click();
	        

	        // Find all links on the page
	        List<WebElement> links = driver.findElements(By.tagName("a"));

	        // Iterate through each link and check if it's broken
	        for (WebElement link : links) {
	            String url = link.getAttribute("href");
	            if (url != null && !url.isEmpty()) {
	                if (isLinkBroken(url)) {
	                    System.out.println("Broken Link: " + url);
	                }
	            }
	        }

	        // Close the browser
	        driver.quit();
	    }

	    // Function to check if a link is broken
	    public static boolean isLinkBroken(String url) {
	        try {
	            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	            connection.setRequestMethod("HEAD");
	            connection.connect();
	            return connection.getResponseCode() >= 400;
	        } catch (Exception e) {
	            return true;
	        }
	    }
	}



