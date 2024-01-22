package Misacelleneous;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class Actionsclass {

	    public static void main(String[] args) throws InterruptedException {
	        WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
	        try {
	            // login to the website using mousehover(moveToElement) action using actions class
	        	     driver.get("https://magnus.jalatechnologies.com/Account/Login");

		            // Enter login credentials and click on the login button
		            driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
		            driver.findElement(By.id("Password")).sendKeys("jobprogram");
		            WebElement loginButton = driver.findElement(By.id("btnLogin")) ;
		            Actions action =new Actions(driver);
		            action.moveToElement(loginButton).click().perform();
		            
		         
		         
		       // Example 1:Enter Capital letters into the text box using KEY DOWN(shift) +alphabets
		        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		        wait.until(ExpectedConditions.titleIs("Magnus"));
	            driver.findElement(By.xpath("//i[@class='fa fa-users']")).click();
	            driver.findElement(By.xpath("//*[@href='/Employee/Create']")).click();
	            WebElement textbox =driver.findElement(By.id("FirstName"));
	            //keyDown and keyUp is used to press the input text 
	            action.keyDown(Keys.SHIFT).sendKeys(textbox,"adil").keyUp(Keys.SHIFT).perform();
	            Thread.sleep(5000);
	           

	            // Example 2: Right click anywhere and click on inspect 
	            WebElement target=driver.findElement(By.id("Address"));
	            action.contextClick(target).perform();
	            action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
	            action.sendKeys("\n").perform();
                Thread.sleep(5000);   
	            
	            /* Example 3: ClickAndHold event, Drag and Drop
	            WebElement sourceElement = driver.findElement(By.id("source"));
	            WebElement targetElement = driver.findElement(By.id("target"));
	            Actions actions3 = new Actions(driver);
	            actions3.clickAndHold(sourceElement).moveToElement(targetElement).release().perform();
                */
	            // Example 4: MoveToElement, Mouse Hover Event
	            WebElement hoverElement = driver.findElement(By.xpath("//span[.='Logout']"));
	            Actions actions4 = new Actions(driver);
	            actions4.moveToElement(hoverElement).perform();
	            Thread.sleep(5000);

	            // Example 5: Double Click event
	            WebElement doubleClickElement = driver.findElement(By.xpath("//i[@class='fa fa-th-list']"));
	            Actions actions5 = new Actions(driver);
	            actions5.doubleClick(doubleClickElement).perform();
	        } finally {
	            driver.quit();
	        }
	    }
	}



