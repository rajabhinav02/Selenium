package Sel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertieshj {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Punam\\eclipse-workspace\\Selenium\\src\\Sel\\data.properties");
		pro.load(fis);
		System.out.println(pro.get("browser"));
		System.out.println(pro.get("url"));
		pro.setProperty("url", "yaho");
		FileOutputStream fio = new FileOutputStream("C:\\Users\\Punam\\eclipse-workspace\\Selenium\\src\\Sel\\data.properties");
		System.out.println(pro.get("url"));
		pro.store(fio, null);
		
		
	}

}
