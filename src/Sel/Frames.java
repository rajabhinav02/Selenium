package Sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		WebElement drag = driver.findElement(By.cssSelector("#draggable"));
		WebElement drop = driver.findElement(By.cssSelector("#droppable"));
		
		Actions a = new Actions(driver);
		a.dragAndDrop(drag, drop).build().perform();
		
		
	}

}
