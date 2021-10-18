package Sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class First {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		/*System.out.println(driver.getCurrentUrl());
		WebElement moneydd= driver.findElement(By.xpath("//select[contains(@id, 'DropDownListCurrency')]"));
		Select dropdown = new Select(moneydd);
		dropdown.selectByIndex(2);
		System.out.println(dropdown.getFirstSelectedOption().getAttribute("value"));
		System.out.println(dropdown.getFirstSelectedOption().getText());*/
		for (int i=1; i<4; i++) {
		driver.findElement(By.cssSelector(".paxinfo")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#hrefIncChd")).click();
		driver.findElement(By.id("btnclosepaxoption")).click();
		}
		System.out.println(driver.findElement(By.cssSelector(".paxinfo")).getAttribute("value"));
		System.out.println(driver.findElement(By.cssSelector(".paxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector(".paxinfo")).getText(), "1 Adult, 3 Child");
		driver.quit();
	}

}
