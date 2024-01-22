package Misacelleneous;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.io.Files;


public class Screenshot {
	public static void main(String[] args) throws IOException {
		System.setProperty("Webdriver.chrome.driver", "C:\\Selenium\\EdgeDriver\\mseedgedriver.exe");
		WebDriver driver =new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		TakesScreenshot ts =(TakesScreenshot)driver;
		WebElement Googlelogo= driver.findElement(By.xpath("//img[@alt='Google']"));
		File Src= Googlelogo.getScreenshotAs(OutputType.FILE);
		File dest =new File("C:\\Users\\DELL\\Pictures\\Saved Pictures\\Googleimg.jpg");
		Files.copy(Src, dest);
		driver.quit();
		
	}

}
