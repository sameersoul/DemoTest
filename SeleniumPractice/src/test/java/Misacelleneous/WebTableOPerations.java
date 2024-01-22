package Misacelleneous;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebTableOPerations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int columnCount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		
		for(int i=0; i<columnCount;i++) {
			for(int j=0;j<rowCount;j++) {
				String Value= driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+(i+1)+"]/td["+j+"]")).getText();
				System.out.println(Value);
				
			}
		}
	}

}
