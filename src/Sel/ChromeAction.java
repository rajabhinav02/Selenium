package Sel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DesiredCapabilities ds = DesiredCapabilities.chrome();
		//ds.acceptInsecureCerts();
		ds.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		ChromeOptions co = new ChromeOptions();
		co.merge(ds);
		
		System.setProperty("webdriver.chrome.driver", null);
		WebDriver driver = new ChromeDriver(co);
		
	}

}
