package Sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stringmeth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/#/documents-request");
		
		String full = driver.findElement(By.cssSelector("[class*='red']")).getText();
		String[] fullsplit = full.split("at");
		String fullsplitspace = fullsplit[1].trim();
		String[] anothersplit = fullsplitspace.split("with");
		System.out.println(anothersplit[0].trim());
		
		
	}

}
