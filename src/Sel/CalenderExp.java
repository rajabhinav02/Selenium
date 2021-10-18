package Sel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderExp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(3000);
		
		WebDriverWait ws = new WebDriverWait(driver,15);
		ws.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='ctl00$mainContent$txt_Fromdate']/ following-sibling::button"))).click();
		
		if (!driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[position()=1]")).getText().contains("August")) {
		while (!driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[position()=2]")).getText().contains("December")) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(2000);
		}	
			
		
		
		List<WebElement> dates= driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[position()=2]//a"));
		Thread.sleep(2000);
		for (WebElement da:dates) {
			if (da.getText().equals("2")) {
				da.click();
				break;
			}
		}//issue--rootcause--temp fix- perm fix --occure
		}
		else {
			List<WebElement> dates= driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[position()=1]//a"));
			Thread.sleep(2000);
			for (WebElement da:dates) {
				if (da.getText().equals("12")) {
					da.click();
					break;
				}
			}
		}
		
	Thread.sleep(5000);
	driver.quit();
		//we are running operating system commands. to release the process and to return it back to os during exception we use this
	}
	
}
