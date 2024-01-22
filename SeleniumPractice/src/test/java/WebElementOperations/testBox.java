package WebElementOperations;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;

	public class testBox {
	    public static void main(String[] args) {
	        // Set the system property for the Chrome driver
	        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\EdgeDriver\\mseedgedriver.exe");

	        // Create a WebDriver instance
	        WebDriver driver = new EdgeDriver();

	        // Navigate to a sample webpage and maximize the webpage
	        driver.manage().window().maximize();
	        driver.get("https://magnus.jalatechnologies.com/Account/Login");

	        // Locate the text box element by its ID (replace "textboxId" with the actual ID)
	        WebElement textBox = driver.findElement(By.xpath("//input[@id='UserName']"));

	        // Type a value into the text box
	        textBox.sendKeys("sa2337308@gmail.com");
	        
		     // After typing in the text box (as shown in the previous example)
		     // Retrieve the value entered in the text box
		     String textBoxValue = textBox.getAttribute("value");
		     System.out.println("Text Box Value: " + textBoxValue);
		     
		  // Assuming the text box has a "placeholder" attribute
		     String placeholderValue = textBox.getAttribute("placeholder");
		     System.out.println("Placeholder Value: " + placeholderValue);

		  // After typing in the text box (as shown in the first example)
		 // Clear the text from the text box
		    textBox.clear();
		
		 //Checking if  textbox is enabled
		    boolean isTextBoxEnabled = textBox.isEnabled();
		    System.out.println("Is text box enabled"+" "+isTextBoxEnabled);
		  
		 //Checking if texbox is disabled
		    boolean isTextBoxDisabled = !isTextBoxEnabled;
		    System.out.println("is Text Box Disabled"+" "+isTextBoxDisabled);


	        // Close the browser
	        driver.quit();
	    }
	}



