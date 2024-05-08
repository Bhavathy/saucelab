package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver){
		super(driver);
	}
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(className = "btn_action")
	WebElement login_button;
	@FindBy(xpath="//button[text()='Open Menu']")
	WebElement menu;
	@FindBy(xpath="//a[@class='bm-item menu-item' and text()='Logout']")
	WebElement logout;
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement error_msg;
	
	 /*Created by Bhavathy K on [01/05/24]
	  * Method = login*/

	public void login() throws IOException{

		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/testdata/data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("login");

		String name = sheet.getRow(1).getCell(0).getStringCellValue();
		String pass = sheet.getRow(1).getCell(1).getStringCellValue();

		//validation if username is enabled
		Assert.assertTrue(username.isEnabled());

		//pass username
		username.sendKeys(name);

		//validation
		String expValue="standard_user";
		String actValue=username.getAttribute("value");
		Assert.assertEquals(expValue, actValue);

		//pass password
		password.sendKeys(pass);
		//validation if password is enabled
		Assert.assertTrue(password.isEnabled());

		//validation
		String expValue1="secret_sauce";
		String actValue1=password.getAttribute("value");
		Assert.assertEquals(expValue1, actValue1);

		//wait until login button is enabled
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(login_button));

		//validating if login is enabled
		Assert.assertTrue(login_button.isDisplayed());	

		//Click Login
		login_button.click();

		//assert for home page
		String ExpectedTitle = "Swag Labs";
		String ActualTitle=driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	/*Created by Anjum Kowsar on [01/05/24]
	  * Methods = invalidlogin & logout*/
	
	public void invalidlogin() throws IOException {

		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/testdata/data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("login");
		String name = sheet.getRow(2).getCell(0).getStringCellValue();
		String pass = sheet.getRow(2).getCell(1).getStringCellValue();

		//validation if username text box is enabled
		Assert.assertTrue(username.isEnabled());

		// Enter invalid username
		username.sendKeys(name);

		//validation if password text box is enabled
		Assert.assertTrue(password.isEnabled());

		// Enter invalid password
		password.sendKeys(pass);

		//wait until login button is enabled
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(login_button));

		//validating if login is enabled
		Assert.assertTrue(login_button.isDisplayed());

		//click login
		login_button.click();

		//fetch error message
		String  error_message = error_msg.getText();
		System.out.println(error_message);

	}

	public void logout() {

		//validating if logout is enabled
		Assert.assertTrue(logout.isEnabled());

		//click Logout
		logout.click();
	}

}
