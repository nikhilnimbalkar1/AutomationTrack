package MainTest;

import org.testng.annotations.Test;

import BaseFrameWork.Base;
import Logs.Log;
import Pages.HomePage;
import utilities.ExcelUtils;

import org.testng.annotations.BeforeSuite;

public class HomePageTest extends Base {
	
  HomePage home = new HomePage();
  @Test(enabled = true)
  public void f() {
	  home.sendKeys("hello");
	  Log.info("Started Google.com");
	  ExcelUtils obj = new ExcelUtils();
	  closeBrowser();
	
  }
  @BeforeSuite
  public void beforeSuite() {
	  initializeProperties(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
	  loadBrowser();
  }

}
