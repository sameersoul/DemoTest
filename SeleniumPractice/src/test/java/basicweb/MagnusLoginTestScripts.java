package basicweb;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.Alert;

public class MagnusLoginTestScripts {

    private static WebDriver driver;

    public static void main(String[] args) {
        // Set the system property for the Edge driver
        System.setProperty("webdriver.edge.driver", "C:\\Selenium\\EdgeDriver\\msedgedriver.exe");

        // Create a WebDriver instance
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Execute test scripts
        testValidLogin();
        testInvalidLogin();
        testBlankCredentials();
        testBlankUsername();
        testBlankPassword();

        // Close the browser
        driver.quit();
    }

   

 

 public static void testValidLogin() {
     // Enter valid credentials
     driver.get("https://magnus.jalatechnologies.com/Account/Login");
     driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
     driver.findElement(By.id("Password")).sendKeys("jalaprogram");

     boolean isLoginPage = true;

     // Loop to click the login button and refresh the page until successful login or timeout
     while (isLoginPage) {
         // Click on the login button
         driver.findElement(By.id("btnLogin")).click();

         // Check if an alert is present (indicating login failure)
         if (isAlertPresent()) {
             // Dismiss the alert
             Alert alert = driver.switchTo().alert();
             alert.dismiss();
             
             // Refresh the page
             driver.navigate().refresh();
         } else {
             // Successful login, break the loop
             isLoginPage = false;
         }
     }

     // Verify successful login by checking the presence of a specific element on the home page
     WebElement welcomeMessage = driver.findElement(By.xpath("//i[@class='fa fa-dashboard']"));
     if (welcomeMessage.isDisplayed()) {
         System.out.println("Test Case: Valid Login - Passed");
     } else {
         System.out.println("Test Case: Valid Login - Failed");
     }
 }

 // Helper method to check if an alert is present
 private static boolean isAlertPresent() {
     try {
         driver.switchTo().alert();
         return true;
     } catch (Exception e) {
         return false;
     }
 }

        

    public static void testInvalidLogin() {
        // Enter invalid credentials
        driver.get("https://magnus.jalatechnologies.com/Account/Login");
        driver.findElement(By.id("UserName")).sendKeys("invalidusername");
        driver.findElement(By.id("Password")).sendKeys("invalidpassword");

        // Click on the login button
        driver.findElement(By.id("btnLogin")).click();

        // Verify login failure by checking the error message
        WebElement errorMessage = driver.findElement(By.xpath("//div[.='Error!']"));
        if (errorMessage.isDisplayed() && errorMessage.getText().equals("Error!")) {
            System.out.println("Test Case: Invalid Login - Passed");
        } else {
            System.out.println("Test Case: Invalid Login - Failed");
        }
    }

    public static void testBlankCredentials() {
        // Leave both username and password fields blank
        driver.get("https://magnus.jalatechnologies.com/Account/Login");
        driver.findElement(By.id("btnLogin")).click();

        // Verify login failure by checking the validation messages
        WebElement usernameValidation = driver.findElement(By.xpath("(//span[.='Please enter email or mobile no.'])[2]"));
        WebElement passwordValidation = driver.findElement(By.xpath("(//span[.='Please enter password.'])[2]"));

        if (usernameValidation.isDisplayed() && passwordValidation.isDisplayed() &&
                usernameValidation.getText().equals("Please enter email or mobile no.") &&
                passwordValidation.getText().equals("Please enter password")) {
            System.out.println("Test Case: Blank Credentials - Passed");
        } else {
            System.out.println("Test Case: Blank Credentials - Failed");
        }
    }

    public static void testBlankUsername() {
        // Leave username field blank
        driver.get("https://magnus.jalatechnologies.com/Account/Login");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");

        // Click on the login button
        driver.findElement(By.id("btnLogin")).click();

        // Verify login failure by checking the validation message
        WebElement usernameValidation = driver.findElement(By.xpath("//span[.='Please enter email or mobile no.'])[2]"));
        if (usernameValidation.isDisplayed() && usernameValidation.getText().equals("Please enter email or mobile no.")) {
            System.out.println("Test Case: Blank Username - Passed");
        } else {
            System.out.println("Test Case: Blank Username - Failed");
        }
    }

    public static void testBlankPassword() {
        // Leave password field blank
        driver.get("https://magnus.jalatechnologies.com/Account/Login");
        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");

        // Click on the login button
        driver.findElement(By.id("btnLogin")).click();

        // Verify login failure by checking the validation message
        WebElement passwordValidation = driver.findElement(By.xpath("//span[.='Please enter password.'])[2]"));
        if (passwordValidation.isDisplayed() && passwordValidation.getText().equals("Please enter password.")) {
            System.out.println("Test Case: Blank Password - Passed");
        } else {
            System.out.println("Test Case: Blank Password - Failed");
        }
    }
}
