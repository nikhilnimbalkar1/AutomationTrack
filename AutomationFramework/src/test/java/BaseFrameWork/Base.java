package BaseFrameWork;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.ConstantsFile;

public class Base {
	
	public static WebDriver driver;
	
	static File file;
	static Properties prop;
	static FileInputStream fip;
	
	public static void initializeProperties(String FilePath) {
		
		file = new File(FilePath);
		prop = new Properties();
		try {
			fip = new FileInputStream(file);
			prop.load(fip);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException in initializeProperties()"+e.getMessage());
		} catch (IOException e) {
			System.out.println("File not loaded properly in initializeProperties()"+e.getMessage());
		}
	}
	
	public static String readProperty(String key) {
		return prop.getProperty(key);
	}
	
	public static void loadBrowser() {
		System.setProperty("webdriver.chrome.driver",readProperty(ConstantsFile.ChromeDriverPath));
		driver = new ChromeDriver();
		driver.get(readProperty(ConstantsFile.Application));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
	}
	
	public void closeBrowser() {
		driver.close();
	}
	

}
