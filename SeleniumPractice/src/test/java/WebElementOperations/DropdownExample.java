package WebElementOperations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownExample {
    public static void main(String[] args) throws InterruptedException {
        // Set the system property for the Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\EdgeDriver\\mseedgedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new EdgeDriver();
        
        boolean loginSuccess = attemptLogin(driver);

        if (loginSuccess) {
        	// Wait for the home page title to be "Magnus"
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
	        wait.until(ExpectedConditions.titleIs("Magnus"));
	        
	        // Wait for the employee dropdown to be present on the home page
	        WebDriverWait waitDropdown = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement employeeDropdown = waitDropdown.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-angle-left pull-right'])[1]"))); 

	        // Click on the employee dropdown
	        employeeDropdown.click();
	        
	        // Wait for the "Create" button to be present in the dropdown
	        WebElement createButton = waitDropdown.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/Employee/Create']")));

	        // Click on the "Create" button
	        createButton.click();

	        // Wait for the "Create Employee" page to load based on partial URL
	        WebDriverWait waitPageLoad = new WebDriverWait(driver, Duration.ofSeconds(10));
	        waitPageLoad.until(ExpectedConditions.urlContains("/Employee/Create"));


        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("CountryId"));

        // Create a Select object from the dropdown element
        Select dropdown = new Select(dropdownElement);

        // Task 1: Print all options available in the dropdown
        System.out.println("Options available in the dropdown:");
        for (WebElement option : dropdown.getOptions()) {
            System.out.println(option.getText());
        }

        // Task 2: Print the first selected option from the dropdown
        WebElement firstSelectedOption = dropdown.getFirstSelectedOption();
        System.out.println("First selected option: " + firstSelectedOption.getText());

        // Task 3: Select an option by value from the dropdown
        String valueToSelect = "9";
        dropdown.selectByValue(valueToSelect);
        System.out.println("Option with value '" + valueToSelect + "' selected.");

        // Task 4: Select an option by visible text from the dropdown
        String visibleTextToSelect = "India";
        dropdown.selectByVisibleText(visibleTextToSelect);
        System.out.println("Option with visible text '" + visibleTextToSelect + "' selected.");

        // Task 5: Select an option by index from the dropdown
        int indexToSelect = 2; // Replace with the index of the option you want to select
        dropdown.selectByIndex(indexToSelect);
        System.out.println("Option at index " + indexToSelect + " selected.");

        // Close the browser
        driver.quit();
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



