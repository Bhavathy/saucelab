package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutPage extends BasePage {
	public CheckoutPage(WebDriver driver){
		super(driver);
	}

	@FindBy(xpath ="/html/body/div/div[2]/div[3]/div/form/div[1]/input[1]")
	WebElement firstname;
	@FindBy(id ="last-name")
	WebElement lastname;
	@FindBy(id ="postal-code")
	WebElement postalcode;
	@FindBy(xpath ="//input[@class='btn_primary cart_button']")
	WebElement continue_button;
	@FindBy(xpath ="//h3[@data-test='error']")
	WebElement error;
	@FindBy(xpath ="(//div[@class='summary_value_label'])[1]")
	WebElement paymentInfo;
	@FindBy(xpath ="(//div[@class='summary_value_label'])[2]")
	WebElement shippingInfo;
	@FindBy(xpath ="//a[@class='btn_action cart_button']")
	WebElement finsih_button;
	
	 /*Created by Anjum Kowsar on [03/05/24]
	  *Method = EnterInvalidInfo*/

	public void EnterInvalidInfo() {
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/testdata/data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet("login");
			String name = sheet.getRow(2).getCell(2).getStringCellValue();
			String pass = sheet.getRow(2).getCell(3).getStringCellValue();
			//String pin = "" + (long)sheet.getRow(2).getCell(4).getNumericCellValue();
			
			//Validating whether first name text box is enabled
			Assert.assertTrue(firstname.isEnabled());

			//enter first name
			firstname.sendKeys(name);

			//Validating whether last name text box is enabled
			Assert.assertTrue(lastname.isEnabled());

			// enter last name
			lastname.sendKeys(pass);

			//Validating whether pin code text box is enabled
			Assert.assertTrue(postalcode.isEnabled());

			// enter pin code
			//postalcode.sendKeys(pin);

			//Validating whether continue button is enabled

			Assert.assertTrue(continue_button.isEnabled());

			// Click continue
			continue_button.click();
			Assert.assertTrue(continue_button.isEnabled());
			System.out.println(error.getText());
			
			firstname.clear();
			lastname.clear();
		}
		catch (Exception e) {
			e.getMessage();
		}

	}

	 /*Created by Bhavathy K on [03/05/24]
	  * Method = EnterInfo*/
	
	public void EnterInfo() throws IOException {

		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/testdata/data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("login");
		String name = sheet.getRow(1).getCell(2).getStringCellValue();
		String pass = sheet.getRow(1).getCell(3).getStringCellValue();
		String pin = "" + (long)sheet.getRow(1).getCell(4).getNumericCellValue();

		//Validating whether first name text box is enabled
		Assert.assertTrue(firstname.isEnabled());

		//enter first name
		firstname.sendKeys(name);

		//Validating whether last name text box is enabled
		Assert.assertTrue(lastname.isEnabled());

		// enter last name
		lastname.sendKeys(pass);

		//Validating whether pin code text box is enabled
		Assert.assertTrue(postalcode.isEnabled());

		// enter pin code
		postalcode.sendKeys(pin);

		//Validating whether continue button is enabled

		Assert.assertTrue(continue_button.isEnabled());

		// Click continue
		continue_button.click();

	}
	 /*Created by Anjum Kowsar on [03/05/24]
	  * Method = fechdata*/
	
	public void fetchdata() {
		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 100);");

		// Fetching payment info.
		System.out.println("Payment Information : "+ paymentInfo.getText());

		// Fetching Shipping info.
		System.out.println("Shipping Information : "+ shippingInfo.getText());
	}
	
	 /*Created by Bhavathy K on [03/05/24]
	  * Method = finish*/
	
	public void finish() throws IOException {

		//Validating whether finish button is enabled
		Assert.assertTrue(finsih_button.isEnabled());

		// Click finish
		finsih_button.click();

		//screenshot
		File screenshotOrderPlaced = ((ChromeDriver) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotOrderPlaced, new File("screenshot_orderPlaced.png"));
	}



}

