package Sel;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ChildWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		/*WebElement wb = driver.findElement(By.cssSelector("#autocomplete"));
		WebElement bt = driver.findElement(By.cssSelector(".blinkingText"));
		Actions a = new Actions(driver);
		a.contextClick(bt).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();*/
		
		driver.findElement(By.linkText("Click Here")).click();
		Set <String> w = driver.getWindowHandles();
		String parent= driver.getWindowHandle();
		
		//Iterator i = w.iterator();
		
		
		for (String ws:w) {
			if (ws != parent) {
				driver.switchTo().window(ws);
			}
		}
		
		System.out.println(driver.findElement(By.xpath("//h3")).getText());
		driver.close();
		driver.switchTo().window(parent);
		
		String hg=driver.findElement(By.xpath("//h3")).getText();
		System.out.println(hg);
		Thread.sleep(2000);
		driver.get("https://www.google.com");
		Actions d = new Actions(driver);
		d.moveToElement(driver.findElement(By.cssSelector("[class*='gLFyf']"))).click().keyDown(Keys.SHIFT).sendKeys("HELLO").keyUp(Keys.SHIFT).build().perform();
		//driver.findElement(By.cssSelector("[class*='gLFyf']")).sendKeys(Keys.SHIFT).
		
		
	}

}
