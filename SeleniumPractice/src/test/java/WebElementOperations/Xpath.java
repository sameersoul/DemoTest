package WebElementOperations;

    import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;

	public class Xpath {
	    public static void main(String[] args) throws InterruptedException {
	        // Set the path to the ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\EdgeDriver\\mseedgedriver.exe");

	       

	        // Create a WebDriver instance
	        WebDriver driver = new EdgeDriver();
	        
	    	boolean LoginSuccess =attemptLogin(driver);
	    	
	    	if(LoginSuccess) {

	      
	        // Find the element containing the label text and color using XPath
	        WebElement labelElement = driver.findElement(By.xpath("//h1[.='Welcome to JALA Academy']"));

	        // Get the text of the label
	        String labelText = labelElement.getText();

	        // Get the color of the label
	        String labelColor = labelElement.getCssValue("color");

	        // Print the results
	        System.out.println("Label Text: " + labelText);
	        System.out.println("Label Color: " + labelColor);
	        
	        //navigate to login page
	        driver.navigate().back();
	        
	        // XPath for id
	        WebElement elementById = driver.findElement(By.xpath("//*[@id='UserName']"));
	        System.out.println("Element by ID: " + elementById.getText());

	        // XPath for name
	        WebElement elementByName = driver.findElement(By.xpath("//*[@name='Password']"));
	        System.out.println("Element by Name: " + elementByName.getText());

	        // XPath for className
	        WebElement elementByClassName = driver.findElement(By.xpath("//*[@class='form-group']"));
	        System.out.println("Element by Class Name: " + elementByClassName.getText());

	        // XPath to find an element that contains specific text
	        WebElement elementWithText = driver.findElement(By.xpath("//*[contains(text(),'Credentials')]"));
	        System.out.println("Element with Text: " + elementWithText.getText());

	        // XPath to find an element using text
	        WebElement elementWithExactText = driver.findElement(By.xpath("//a[.='Admin Login']"));
	        System.out.println("Element with Exact Text: " + elementWithExactText.getText());

	        // XPath to find an element that starts-with
	        WebElement elementStartsWith = driver.findElement(By.xpath("//*[starts-with(@class, 'login')][2]"));
	        System.out.println("Element Starts With: " + elementStartsWith.getText());

	        // XPath to select following-sibling and preceding
	        WebElement followingSibling = driver.findElement(By.xpath("//h2[.=' Login Credentials']/following-sibling:: h5[1]"));
	        System.out.println("Following Sibling: " + followingSibling.getText());

	        WebElement precedingElement = driver.findElement(By.xpath("//h2[.=' Login Credentials']/preceding-sibling:: a"));
	        System.out.println("Preceding Element: " + precedingElement.getText());

	        // XPath to select ancestor, child, parent, and descendant
	        WebElement ancestorElement = driver.findElement(By.xpath("//div[@class='social-auth-links text-center']/ancestor-or-self::div"));
	        System.out.println("Ancestor Element: " + ancestorElement.getText());

	        WebElement childElement = driver.findElement(By.xpath("//div[@class='login-logo']/child::h2"));
	        System.out.println("Child Element: " + childElement.getText());

	        WebElement parentElement = driver.findElement(By.xpath("//h2[.=' Login Credentials']/parent:: div"));
	        System.out.println("Parent Element: " + parentElement.getText());

	        WebElement descendantElement = driver.findElement(By.xpath("//div[@class='login-box']/descendant::p[1]"));
	        System.out.println("Descendant Element: " + descendantElement.getText());

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


