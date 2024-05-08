package TestSuites;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.Base;
import Pages.AboutUsPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.ExtentReport;
public class TestCases extends Base {
	LoginPage lg; 
	HomePage hm;
	CheckoutPage co;
	AboutUsPage ab;
	/*Created by Anjum Kowsar on [01/05/24]*/
	@Test(priority =1)
	public void Login() throws Exception {
		lg=new LoginPage(driver);
		lg.login();
	}
	/*Created by Anjum Kowsar on [01/05/24]*/
	@Test(priority = 2)
	public void Filtration() throws Exception {
		hm=new HomePage(driver);
		hm.filtration();

	}
	/*Created by Anjum Kowsar on [01/05/24]*/
	@Test(priority = 3)
	public void FetchDetails() throws Exception {
		hm=new HomePage(driver);
		hm.fetchProduct();

	}
	/*Created by Bhavathy K on [01/05/24]*/
	@Test(priority = 4)
	public void AddItems() throws Exception {
		hm=new HomePage(driver);
		hm.addToCart();

	}
	/*Created by Bhavathy K on [01/05/24]*/
	@Test(priority = 5)
	public void RemoveItem() throws Exception {
		hm=new HomePage(driver);
		hm.removeitem();

	}
	/*Created by Anjum Kowsar on [01/05/24]*/
	@Test(priority = 6)
	public void EnterInvalidDetails() throws Exception {
		co=new CheckoutPage(driver);
		co.EnterInvalidInfo();	
	}
	/*Created by Bhavathy K on [01/05/24]*/
	@Test(priority = 7)
	public void EnterDetails() throws Exception {
		co=new CheckoutPage(driver);
		co.EnterInfo();

	}
	/*Created by Bhavathy K on [02/05/24]*/
	@Test(priority = 8)
	public void FetchShippingDetails() throws Exception {
		co=new CheckoutPage(driver);
		co.fetchdata();

	}
	/*Created by Bhavathy K on [02/05/24]*/
	@Test(priority = 9)
	public void Finish() throws Exception {
		co=new CheckoutPage(driver);
		co.finish();	
	}
	/*Created by Anjum Kowsar on [02/05/24]*/
	@Test(priority =10)
	public void AboutUs() throws Exception {
		ab = new AboutUsPage(driver);
		ab.SauceLab();
	}
	/*Created by Anjum Kowsar on [02/05/24]*/
	@Test(priority =11)
	public void Logout() throws Exception {
		lg=new LoginPage(driver);
		lg.logout();
	}
	/*Created by Bhavathy K on [02/05/24]*/
	@Test(priority =12)
	public void InvalidLogin() throws Exception {
		lg=new LoginPage(driver);
		lg.invalidlogin();
		
	}

}
