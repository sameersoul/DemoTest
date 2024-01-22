package WebElementOperations;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class RadioButton {
	    public static void main(String[] args) throws InterruptedException {
	        // Set the system property for the Chrome driver
	        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\EdgeDriver\\mseedgedriver.exe");

	        // Create a WebDriver instance
	        WebDriver driver = new EdgeDriver();
	        
	        // Attempt login with automatic retries on failure
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

	      
	        // Select radio button by id text
	        WebElement radiobuttonById = driver.findElement(By.id("rdbMale"));
	        radiobuttonById.click();
	        System.out.println("radio buton id:"+radiobuttonById.getAttribute("value"));

	        // Alternatively, you can select by value (replace "radioValue" with the actual value)
	        WebElement radioByValue = driver.findElement(By.xpath("//input[@value='M']"));
	        radioByValue.click();
	        
	     // Assuming radio buttons are grouped under the same name attribute (replace "groupName" with the actual name)
	        List<WebElement> radioButtonscount = driver.findElements(By.xpath("//div[@class='col-md-4 form-group mt_25']"));
	        int numberOfRadioButtons = radioButtonscount.size();
	        System.out.println("Number of Radio Buttons in the group: " + numberOfRadioButtons);

	     // Assuming radio buttons are grouped under the same name attribute (replace "groupName" with the actual name)
	        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='rdbGender']"));

	        // Iterate through each radio button and get the value
	        for (WebElement radioButton : radioButtons) {
	            String radioValue = radioButton.getAttribute("value");
	            System.out.println("Radio Button Value: " + radioValue);
	        }
	        
	        // Getting the selected radio button label text:
	        // Iterate through each radio button and check if it is selected
	        for (WebElement radioButton : radioButtons) {
	            if (radioButton.isSelected()) {
	                String labelText = driver.findElement(By.xpath("//label[text()='" + radioButton.getText() + "']")).getText();
	                System.out.println("Selected Radio Button Label Text: " + labelText);
	                break; // Assuming only one radio button can be selected
	            }
	        }
	        
	        //Checking if a Radio Button is selected:
	       // Assuming radio buttons are grouped under the same name attribute (replace "groupName" with the actual name)
	        WebElement radioButton = driver.findElement(By.name("rdbGender"));

	        // Check if the radio button is selected
	        boolean isRadioButtonSelected = radioButton.isSelected();
	        System.out.println("Is Radio Button Selected? " + isRadioButtonSelected);
	        
	        //Checking if a Radio Button is enabled or disabled:
	     // Assuming radio buttons are grouped under the same name attribute (replace "groupName" with the actual name)
	         radioButton = driver.findElement(By.name("rdbGender"));

	        // Check if the radio button is enabled
	        boolean isRadioButtonEnabled = radioButton.isEnabled();
	        System.out.println("Is Radio Button Enabled? " + isRadioButtonEnabled);



	        // Close the browser
	        driver.quit();
	        }}
	
	
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


