package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver){
		super(driver);
	}
	@FindBy(xpath ="//select[@class='product_sort_container']")
	WebElement testDropDown;
	@FindBy(xpath ="//div[@class='inventory_item']//div[2]//a//div")
	List<WebElement> productname;
	@FindBy(xpath ="//div[@class='inventory_item']//div[3]//div")
	List<WebElement> productprice;
	@FindBy(xpath ="(//button[@class='btn_primary btn_inventory'])[1]")
	WebElement product_1;
	@FindBy(xpath ="(//button[@class='btn_primary btn_inventory'])[2]")
	WebElement product_2;
	@FindBy(xpath ="//*[@id=\"shopping_cart_container\"]/a/span")
	WebElement cart;
	@FindBy(xpath ="(//button[@class='btn_secondary cart_button'])[1]")
	WebElement remove;
	@FindBy(xpath ="//a[@class='btn_action checkout_button']")
	WebElement Checkout;

	/* Created By - Anjum Kowsar on [03/05/24]
	 * Methods = filteration & fetchProduct*/

	public void filtration() {

		//wait until dropdown is clickable
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(testDropDown));

		//validating dropdown
		Assert.assertTrue(testDropDown.isEnabled());

		//Select dropdown
		Select dropdown = new Select(testDropDown);  
		dropdown.selectByValue("lohi");

		WebElement low=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
		String ExpectedTitle="Sauce Labs Onesie";
		if(low.getText().contains(ExpectedTitle)) {
			System.out.println("-------------------------------------------------");
			System.out.println("Validation Passed: Low to High filter is set");
		}
		else {
			System.out.println("-------------------------------------------------");
			System.out.println("Validation failed: filter cannot be set");
		}
	}

	public void fetchProduct() {

		// Fetch Product name with price
		int productsize=productname.size();
		int productPrice=productprice.size();
		for(int i=0;i<productsize;i++) {
			System.out.println(productname.get(i).getText());
			for(int j=0;j<productPrice;j++) {
				if(i==j)
					System.out.println(productprice.get(j).getText());
			}
		}
		//validating whether all products are fetched
		int expValue2=6;
		Assert.assertEquals(productsize, expValue2);
	}

	/*Created by Bhavathy K on [03/05/24]
	 * Methods = addToCart & removeItem*/	

	public void addToCart() throws IOException {

		//validate whether product1 is enabled
		Assert.assertTrue(product_1.isEnabled());

		//add product1
		product_1.click();

		//validate whether product2 is enabled
		Assert.assertTrue(product_2.isEnabled());

		//add product2
		product_2.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//validate whether add to cart is enabled
		Assert.assertTrue(cart.isEnabled());

		//Click add to cart
		cart.click();

		//validating whether 2 products added
		WebElement quan=driver.findElement(By.xpath("(//div[@class='cart_quantity'])[1]"));
		WebElement quan2=driver.findElement(By.xpath("(//div[@class='cart_quantity'])[2]"));
		String quantity1=quan.getText();
		String quantity2=quan2.getText();
		int q1=Integer.parseInt(quantity1);
		int q2=Integer.parseInt(quantity2);
		int q=q1+q2;
		Assert.assertEquals(q,2);
	}

	public void removeitem() {
		//Validating remove button
		Assert.assertTrue(remove.isEnabled());

		//click remove button
		remove.click();

		//Validating checkout button 
		Assert.assertTrue(Checkout.isEnabled());

		//click checkout
		Checkout.click();

		//validating number of items in cart
		String num = driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']")).getText();
		int cart = Integer.parseInt(num);
		Assert.assertEquals(cart, 1);


	}


}
