package Sel;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountsofLink {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		WebElement footerdriver = driver.findElement(By.cssSelector("#gf-BIG"));
		List<WebElement> footerlinks = footerdriver.findElements(By.tagName("a"));
		System.out.println(footerlinks.size());
		List<WebElement> footercolumn= driver.findElements(By.xpath("//div[@id='gf-BIG']//tr/td[1]/ul//a"));
		System.out.println(footercolumn.size());
		String parent = driver.getWindowHandle();
		
		
		/*for (WebElement col: footercolumn) {
			//System.out.println(col.getText());
			if (col.getText().equals("SoapUI")) {
				col.click();
				System.out.println("clicked");
				break;
			}
			else {
				System.out.println("not clicked");
			}
			
		}*/
		
		
		for (int i =0; i<footercolumn.size(); i++) {
			String clickonlink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			footercolumn.get(i).sendKeys(clickonlink);
			Thread.sleep(3000);
			
		}
		
		Set<String> wh= driver.getWindowHandles();
		
		
		//this will give parent title as well
		for (String w:wh) {
		 
			driver.switchTo().window(w);
			if(driver.getWindowHandle().equals(parent))
				continue;
			System.out.println(driver.getTitle());
		}
		
		/*Iterator<String> m = wh.iterator();
		
		while (m.hasNext()) {
			
			driver.switchTo().window( m.next());
			//if we don't want to print parent title
			if (driver.getWindowHandle().equals(parent)) {
				
				driver.switchTo().window( m.next());
			}
			System.out.println(driver.getTitle());
			
			
			}*/
	Thread.sleep(5000);
	driver.quit();
		}
	
	
	
	}


