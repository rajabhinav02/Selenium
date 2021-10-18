package Sel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//div[contains(@class, "ui-datepicker-group")][position()=1]
		//div[contains(@class, "ui-datepicker-group")][position()=1]//a
		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/dropdownsPractise/";
		driver.get(url);
		
		WebElement calender = driver.findElement(By.xpath("//input[@name='ctl00$mainContent$txt_Fromdate']/following-sibling::button"));
		calender.click();
		Thread.sleep(2000);
		
		List<WebElement> dates = driver.findElements(By.xpath("//div[contains(@class, \"ui-datepicker-group\")][position()=1]//a"));
		
		for (WebElement date:dates) {
			
			if (date.getText().equals("29")) {
				date.click();
				break;
			}
		}
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
