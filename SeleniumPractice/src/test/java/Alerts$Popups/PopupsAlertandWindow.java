package Alerts$Popups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class PopupsAlertandWindow {
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
        
     // Wait for the home page title to be "Magnus"
     		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
     		wait.until(ExpectedConditions.titleIs("Magnus"));
     	      
     	     // Navigate to the more dropdown
     	     WebElement moredropdown = driver.findElement(By.xpath("(//i[@class='fa fa-angle-left pull-right'])[2]"));
     	     moredropdown.click();
     	     
     	     //Navigate to popup link button and click it
     	     WebElement PopupsButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href='/Home/Popup']")));
     	     PopupsButton.click();
     	     //Now Wait until link page gets loaded
     	     
     	     wait.until(ExpectedConditions.titleContains("Popup"));
            // Capture the alert message using getText()
            WebElement alertButton = driver.findElement(By.xpath("//input[@id='alertBox']"));
            alertButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.dismiss();

        // Prompt Alert with Text Box to enter the text
        WebElement PromptAlertButton= driver.findElement(By.xpath("//button[@id='promptBtn']"));
        PromptAlertButton.click();
        Alert Promptalert = driver.switchTo().alert();
        Promptalert.sendKeys("Hello, Selenium!");
        System.out.println("Alert Text: " + Promptalert.getText());
        Promptalert.accept();

        // Confirmation Alert with Ok and Cancel buttons
        WebElement confirmButton = driver.findElement(By.id("confirmBox"));
        confirmButton.click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("ConfirmationAlert Text: " + confirmAlert.getText());

        // Clicking OK button of the alert using accept()
        // confirmAlert.accept();

        // Clicking Cancel button of the alert using dismiss()
        //confirmButton.click(); // Click again to open the confirmation alert
        confirmAlert.dismiss();

        // Handle single window using driver.getWindowHandle()
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Main Window Handle: " + mainWindowHandle);

        // Handle multiple windows using driver.getWindowHandles()
        WebElement newWindowButton = driver.findElement(By.id("btn-one"));
        newWindowButton.click();
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Window Handles: " + windowHandles);

        // Switch to the new window using driver.switchTo().window()
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Switched to New Window with Title: " + driver.getTitle());
                break;
            }
        }

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);

        // Switch to frame using driver.switchTo().frame() 
         driver.findElement(By.xpath("(//i[@class='fa fa-hand-o-right'])[11]")).click();
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

        // Quit the WebDriver session
        driver.quit();
    }
}
