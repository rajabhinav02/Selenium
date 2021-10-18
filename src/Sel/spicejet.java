package Sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class spicejet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		WebElement departure = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1")); 
		Select sel = new Select(departure); 
		sel.selectByIndex(5);
		System.out.println(departure.getAttribute("value"));
		
	}

}
