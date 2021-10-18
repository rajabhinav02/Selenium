package Sel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VegCartUpdated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		getItem(driver);
	}
	
	public static void getItem(WebDriver driver) {
		
		String[] ItemsNeeded = {"Beetroot","Cauliflower","Beans", "Potato"};
		
		List<WebElement>Veg = driver.findElements(By.cssSelector("h4.product-name"));
		List<WebElement>Add = driver.findElements(By.cssSelector("div[class='product-action'] button"));
		List<WebElement>Price = driver.findElements(By.cssSelector("p.product-price"));
		
		List<String> items = Arrays.asList(ItemsNeeded);
		ArrayList<Integer> pri = new ArrayList<Integer>();
		
		int j = 0;
		
		for (int i=0; i<Veg.size(); i++) {
			String vegname = Veg.get(i).getText();
			String[] splitveg = vegname.split("-");
			String finalveg = splitveg[0].trim();
			
			if (items.contains(finalveg)) {
				Add.get(i).click();
				String pricewr = Price.get(i).getText();
				int pric = Integer.parseInt(pricewr);
				pri.add(pric);
				j++;
			}
			
			if (j == items.size())
				break;
		}
		
		Object[] pricarray = pri.toArray();
		
		
		
	}

}
