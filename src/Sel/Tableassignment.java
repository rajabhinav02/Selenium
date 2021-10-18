package Sel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Tableassignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement table= driver.findElement(By.xpath("//table[@id='product' and @name='courses']"));
		js.executeScript("arguments[0].scrollIntoView(true)", table);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		
		List<WebElement> tarow = table.findElements(By.xpath("//tr"));
		System.out.println(tarow.size());
		
		List<WebElement> tacol = driver.findElements(By.xpath("//table[@id='product' and @name='courses']//tr/th"));
		System.out.println(tacol.size());
		
		List<WebElement> tworow = driver.findElements(By.xpath("//table[@id='product' and @name='courses']//tr[3]/td"));
		
		/*System.out.println("Instructor "+ tworow.get(0).getText());
		System.out.println("Course "+tworow.get(1).getText());
		System.out.println("Price "+tworow.get(2).getText());*/
		
		/*for (int i=0; i<tworow.size();i++) {
			String value= tworow.get(i).getText();
			System.out.println(value);
		}*/
		
		for (WebElement tw:tworow) {
			System.out.println(tw.getText());
		}
		
		
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("In");
		Thread.sleep(3000);
		List<WebElement> name = driver.findElements(By.cssSelector("[class='ui-menu-item'] div"));
		
		
		for(WebElement na:name) {
			System.out.println("loop");
			if (na.getText().equalsIgnoreCase("India")) {
				na.click();
				System.out.println("clicked");
				break;
			}
			else {
				System.out.println("not");
			}
		}
		
		
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.cssSelector("#autocomplete")).getAttribute("value"), "India");
		driver.quit();
		
	}

}
