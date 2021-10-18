package Sel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VegCart {
	
	int j=0;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String Items[]= {"Brocolli", "Cucumber", "Tomato", "Brinjal"};
		
		getList(driver, Items);
		

	}

public static void getList(WebDriver driver, String[] Items) throws InterruptedException {
		int j =0;
		
		
		   List <WebElement> names = driver.findElements(By.cssSelector("h4.product-name"));
		   
		   List <WebElement> addbuttons= driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
		   
		   for (int i=0; i<names.size(); i++) {
			   
			   String name = names.get(i).getText();
			   String[] namewithoutweight = name.split("-");
			   String finalname = namewithoutweight[0].trim();
			   
			   //Thread.sleep(5000);
			   
			   
			   List Itemslist = Arrays.asList(Items);
			   
			   if (Itemslist.contains(finalname)) {
				   Thread.sleep(5000);
				   addbuttons.get(i).click();
				   
				   j++;
			   }
			   
			   if (j==Itemslist.size()) 
				   
				   break;
			   
		   }
			
		
		   driver.findElement(By.cssSelector("[alt=Cart]")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//button[contains(text(),'PROCEED')]")).click();
		   Thread.sleep(5000);
		   
		   ArrayList <String> al = new ArrayList<String> ();
		   
		   List<WebElement> selected = driver.findElements(By.xpath("//p[@class='product-name']"));
		   Thread.sleep(2000);
		   
		   for (int m=0; m<selected.size(); m++) {
			   
			   String seleit=selected.get(m).getText();
			   al.add(seleit);
			   
		   }
		   
		   Object[]obj= al.toArray();
		   ArrayList<String> jk = new ArrayList<String>();
		   
		   for (int f=0; f<obj.length; f++) {
			   String na = (String) obj[f];
			   String[] nasplit =  na.split("-");
			   String nametable = nasplit[0].trim();
			   
			   jk.add(nametable);
			   
			  
			   
			   
			   
		   }
		   
		   Thread.sleep(3000);
		   Object[] arrayinalsel = jk.toArray();
		   
		   String[]arraystr = new String[arrayinalsel.length];
		   System.arraycopy(arrayinalsel, 0, arraystr, 0, arrayinalsel.length);
		   
		   System.out.println(Arrays.toString(arraystr));
		   
		   for (Object jkl:arrayinalsel) {
			   System.out.print(jkl);
		   }
		   //String [] arrayin = (String[])arrayinalsel;
		   
		   Thread.sleep(2000);
		   /*for (int s=0; s<Items.length; s++) {
			   System.out.print(Items[s]);
		   }*/
		   System.out.println(Arrays.toString(Items));
		   
		   Assert.assertTrue(Arrays.equals(Items, arrayinalsel));
		   //System.out.println(arrayinalsel.toString());
		   
		   int sum =0;
		   
		   List<WebElement> amountva = driver.findElements(By.xpath("//td[5]/p"));
		   
		   Thread.sleep(2000);
		   
		   for (int v=0; v<amountva.size(); v++) {
			   String amount=  amountva.get(v).getText(); 
			   int amo = Integer.parseInt(amount);
			   sum=  sum+ amo;
		   }
		   System.out.println(sum);
		   
		   driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		   driver.findElement(By.cssSelector(".promoBtn")).click();
		   WebDriverWait wa = new WebDriverWait(driver,15);
		   wa.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()= 'Apply']")));
		   
		   String totam = driver.findElement(By.cssSelector(".totAmt")).getText();
		   Thread.sleep(2000);
		   int totamo = Integer.parseInt(totam);
		   Assert.assertTrue(sum==totamo);
		   
		   String dscam = driver.findElement(By.cssSelector(".discountAmt")).getText();
		   Thread.sleep(2000);
		   float dscamo = Float.parseFloat(dscam) ;
		   
		   Assert.assertTrue(totamo>dscamo);
		   
		   
	}




}
