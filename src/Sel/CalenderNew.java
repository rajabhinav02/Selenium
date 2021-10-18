package Sel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderNew {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(3000);
		
		WebDriverWait ws = new WebDriverWait(driver,15);
		ws.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='ctl00$mainContent$txt_Fromdate']/ following-sibling::button"))).click();
		
	
		List<WebElement> months= driver.findElements(By.xpath("//span[@class='ui-datepicker-month']"));
		for (WebElement na:months) {
			months= driver.findElements(By.xpath("//span[@class='ui-datepicker-month']"));
			System.out.println("for");
			while  (!na.getText().contains("December"))  {
				System.out.println("while");
				ws.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']"))).click();
				//driver.findElement(By.xpath("//span[text()='Next']")).click();
				Thread.sleep(3000);
				
			}
			break;
		}
	}

}
