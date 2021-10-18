package Sel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class dynamicdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		WebElement countrya = driver.findElement(By.id("autosuggest"));
		
		countrya.sendKeys("In");
		
		List<WebElement> countries = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		//css child--- give space after parent
		
		for (WebElement country:countries) {
			
			if (country.getText().equalsIgnoreCase("India")){
				
				country.click();
				Assert.assertFalse(countrya.isSelected());
				
				break;
				
				
					
			}
			
		}

	}

}
