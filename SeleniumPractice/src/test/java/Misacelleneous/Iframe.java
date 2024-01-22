package Misacelleneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Iframe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\EdgeDriver\\mseedgedriver.exe");

        // Initialize the ChromeDriver
        WebDriver driver = new EdgeDriver();

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

             // Switch to frame using driver.switchTo().frame() 
              driver.findElement(By.xpath("//*[.=' iFrames']")).click();
              wait.until(ExpectedConditions.titleContains("Iframe"));
              
              driver.switchTo().frame("iframe2");

             // Perform actions within the frame
            WebElement FrameElement= driver.findElement(By.xpath("//a[@class='sidebar-toggle']"));
            FrameElement.click();
            System.out.println(FrameElement.getText()+ "found inside the iframe");
              
             // Switch back to the main content
             driver.switchTo().defaultContent();

             // Close the current browser window
             driver.close();

	}

}
