package WebElementOperations;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

	public class Links {
	    public static void main(String[] args) throws InterruptedException {
	    	
	    	 // Set the system property for the Chrome driver
	        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\EdgeDriver\\mseedgedriver.exe");

	        // Create a WebDriver instance
	        WebDriver driver = new EdgeDriver();
	        
	    	boolean LoginSuccess =attemptLogin(driver);
	    	if(LoginSuccess) {
	    		
	    // Wait for the home page title to be "Magnus"
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
		wait.until(ExpectedConditions.titleIs("Magnus"));
	      
	     // Navigate to the more dropdown
	     WebElement moredropdown = driver.findElement(By.xpath("(//i[@class='fa fa-angle-left pull-right'])[2]"));
	     moredropdown.click();
	     
	     //Navigate to link button and click it
	     WebElement linkButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-hand-o-right'])[9]")));
	     linkButton.click();
	     //Now Wait until link page gets loaded
	     WebDriverWait linkwait= new WebDriverWait(driver, Duration.ofSeconds(10));
	     linkwait.until(ExpectedConditions.titleContains("Links"));
	     
	     //Now Navigate to Working link tab and click it
	     driver.findElement(By.xpath("//a[.='Working Links']")).click();

	        // Task 1: Clicking a link using LinkText
	         WebElement LinkText= driver.findElement(By.xpath("//a[.='Link 2'][1]"));
	         LinkText.click();
	         System.out.println("Clicked on link with  link text: " + LinkText.getText());
	         Thread.sleep(5000);
	        // Navigate back to the original page
	        driver.navigate().to("https://magnus.jalatechnologies.com/Home/Links");

	        linkwait.until(ExpectedConditions.titleContains("Links"));
	       // Task 2: Clicking a link using PartiaLinkText
	        
	       WebElement PartialLinkText=driver.findElement(By.xpath("//a[.='Link 3'][1]"));
	       PartialLinkText.click();
	       System.out.println("Clicked on link with partial Link text:"+" "+PartialLinkText);
	       Thread.sleep(5000);

	        // Navigate back to the original page
	        driver.navigate().back();

	        // Task 3: Find out all the links in a web page
	        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	        System.out.println("All links on the page:");
	        for (WebElement link : allLinks) {
	            System.out.println(link.getText() + " - " + link.getAttribute("href"));
	        }

	        driver.navigate().to("https://magnus.jalatechnologies.com/Home/Links");

	        linkwait.until(ExpectedConditions.titleContains("Links"));
	        // Task 4: Now navigate to image links tab and click on image Clicking on an image link
	         driver.findElement(By.xpath("//a[.='Image Links']")).click();
	         driver.findElement(By.xpath("//img[@alt='Linkedin Link']")).click();
	        // Thread.sleep(5000);
	         
	         
	        
	        /*String imageLinkTextToClick = "";
	        driver.findElement(By.xpath("//img[@alt='Linkedin Link']")).click();
	        WebElement imageLink = driver.findElement(By.xpath("//a[img[contains(@alt,'" + imageLinkTextToClick + "')]]"));
	        imageLink.click();
	        System.out.println("Clicked on image link with text: " + imageLinkTextToClick);
	        */

	        // Close the browser
	        //driver.quit();
	    }
	}


	 private static boolean attemptLogin(WebDriver driver) throws InterruptedException {
	        int maxAttempts = 3;
	        int attempts = 0;

	        while (attempts < maxAttempts) {
	            // Navigate to the login page
	            driver.get("https://magnus.jalatechnologies.com/Account/Login");

	            // Enter login credentials and click on the login button
	            driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
	            driver.findElement(By.id("Password")).sendKeys("jobprogram");
	            driver.findElement(By.id("btnLogin")).click();
	            Thread.sleep(5000);
	            driver.navigate().to(driver.getCurrentUrl());

	            // Check if the title of the current page is "Magnus"
	            if (driver.getTitle().equals("Magnus")) {
	                System.out.println("Login Successful");
	                return true;
	            } else {
	                System.out.println("Login Failed. Retrying...");
	                attempts++;
	            }
	        }

	        System.out.println("Maximum login attempts reached. Login failed.");
	        return false;
	    }
	}

