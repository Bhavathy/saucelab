package Base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties pr;
	public static FileReader fr;
	@BeforeClass

	/* Created By - Anjum Kowsar on [01/05/24]
	 * method = invokebrowser*/

	public void invokebrowser() throws IOException {
		if(driver==null) {
			pr = new Properties();
			fr=new FileReader(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
			pr.load(fr);
		}
		if(pr.getProperty("browser").matches("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(pr.getProperty("url"));
		}
		else if(pr.getProperty("browser").matches("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(pr.getProperty("url"));
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	/*Created by Bhavathy K on [04/05/24]
	 * Method = captureScreen*/

	public static String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		FileUtils.copyFile(sourceFile, targetFile);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	@AfterClass
	public void closebrower() {
		driver.quit();
	}


}

