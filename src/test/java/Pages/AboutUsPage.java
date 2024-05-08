package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class AboutUsPage extends BasePage {
	
	public AboutUsPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//a[@id='about_sidebar_link']")
	WebElement about;
	@FindBy(xpath="//div[@class='MuiStack-root css-wsh0bu']//div//h2")
	WebElement text1;
	@FindBy(xpath="//div[@class='MuiBox-root css-sehrga']//h3")
	WebElement text2;
	@FindBy(xpath="//div[@class='MuiBox-root css-m30jjr']//p")
	WebElement paragraph;
	@FindBy(xpath="//button[text()='Open Menu']")
	WebElement menu;
	@FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
	WebElement cookies;
	@FindBy(xpath="//span[@class='MuiTypography-root MuiTypography-buttonLabelNav css-1pj3is7' and text()='Resources']")
	WebElement resource;
	@FindBy(xpath = "//*[@id=\"__next\"]/header/div/div/div[3]/div/button")
	WebElement search;
	@FindBy(xpath="//input[@id='search']")
	WebElement input;
	@FindBy(xpath="//div[@class='MuiStack-root css-1cf4ch4']//h6")
	List<WebElement> appium_courses;
	@FindBy(xpath="//a[contains(@href,'/request-demo')]")
	WebElement demo;

	 /*Created by Anjum Kowsar on [04/05/24]
	  * Method = SauceLab*/

	public void SauceLab() {
		try {
			Assert.assertTrue(menu.isEnabled());
			menu.click();
			Assert.assertTrue(about.isEnabled());
			about.click();
			driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,950)", "");
			Assert.assertTrue(text1.isDisplayed());
			String heading = text1.getText();
			Assert.assertTrue(text2.isDisplayed());
			String title = text2.getText();
			Assert.assertTrue(paragraph.isDisplayed());
			String para = paragraph.getText();
			System.out.println(heading);
			System.out.println(title);
			System.out.println(para);
			driver.navigate().back();
			
			//driver.navigate().to("https://saucelabs.com/");
			//driver.manage().deleteAllCookies();
//			WebDriverWait wait = new WebDriverWait(driver,null);
			
//			wait.until(ExpectedConditions.elementToBeClickable(cookies));
//			cookies.click();
//			Actions act = new Actions(driver);

			
			

			//Performing the mouse hover action on the target element.
//			driver.navigate().to("https://saucelabs.com/");
//			act.moveToElement(resource);
//			act.doubleClick().build().perform();
//			driver.findElement(By.xpath("(//span[text()='Discover by topic'])[2]")).click();
//			driver.findElement(By.xpath("(//span[text()='Appium'])[3]")).click();
			


			
		}
		catch (Exception e) {
			e.getMessage();
		}

	}



}
