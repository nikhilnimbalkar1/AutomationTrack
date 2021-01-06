package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BaseFrameWork.Base;
import config.ConstantsFile;

public class HomePage extends Base {
	
	
	@FindBy(how = How.XPATH,using = "//input[@name='q']")
	private WebElement gSearch;
	
	@FindBy(how = How.XPATH,using = "//ul//li[contains(@class,\"sbct\")]")
	private List<WebElement> autoComplete;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void sendKeys(String query) {
		
		gSearch.sendKeys(query);
		for (WebElement webElement : autoComplete) {
			System.out.println(webElement.getText());
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}
	
	/*
	 * public static void main(String[] args) {
	 * initializeProperties(System.getProperty("user.dir")+
	 * "\\src\\test\\java\\config\\config.properties"); loadBrowser(); HomePage obj
	 * = new HomePage(); obj.sendKeys("heloo");
	 * 
	 * }
	 */
	
}
