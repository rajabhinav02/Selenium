package Sel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class spicejete2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		//div[contains(@class,'ui-datepicker-group')][position()=1]
		
		
		WebElement round = driver.findElement(By.cssSelector("[id*='rbtnl_Trip_1']"));
		WebElement friends = driver.findElement(By.cssSelector("[id*='friends']"));
		WebElement depdd = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		WebElement arrdd = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
		
		List<WebElement> depDate = driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[position()=1]//a"));
		//List<WebElement> depDate = driver.findElements(By.xpath("//div[contains(@class,'ui-datepicker-group')][position()=1]//a"));
		WebElement arrcal = driver.findElement(By.xpath("//input[@name='ctl00$mainContent$txt_Todate']/following-sibling::button"));
		List<WebElement> arrpDate= driver.findElements(By.xpath("//div[contains(@class,'ui-datepicker-group')][position()=1]//a"));
		WebElement pass = driver.findElement(By.cssSelector("#divpaxinfo"));
	
		WebElement currency = driver.findElement(By.cssSelector("[id*='ListCurrency']"));
		WebElement find = driver.findElement(By.xpath("//input[@type='submit' and (contains(@name,'FindFlights'))]"));
		
		
		round.click();
		friends.click();
		depdd.click();
		Thread.sleep(2000);
		WebElement depcity = driver.findElement(By.xpath("//a[@value='BLR']"));
		
		depcity.click();
		Thread.sleep(2000);
		arrdd.click();
		Thread.sleep(2000);
		WebElement arrcity = driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='DEL']"));
		arrcity.click();
		Thread.sleep(2000);
		
		for (WebElement depd:depDate) {
			if( depd.getText().equals("29")) {
				depd.click();
				break;
			}
		}
		
		Thread.sleep(2000);
		arrcal.click();
		Thread.sleep(2000);
		for (WebElement ard: arrpDate) {
			if (ard.getText().equals("10")){
				ard.click();
				break;
			}
		}
		
		pass.click();
		Thread.sleep(2000);
		
		WebElement adult = driver.findElement(By.cssSelector("[name*='ddl_Adult']"));
		WebElement child = driver.findElement(By.cssSelector("[name*='ddl_Child']"));
		WebElement infant = driver.findElement(By.cssSelector("[name*='ddl_Infant']"));
		
		Select adu = new Select(adult);
		adu.selectByValue("2");
		
		Select chi = new Select(child);
		chi.selectByVisibleText("3");
		
		Select inf = new Select(infant);
		inf.selectByIndex(4);
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		
		Select curr = new Select(currency);
		curr.selectByVisibleText("USD");
		
		
		
		
		
		find.click();
		
		
		
		
		
	}

}
