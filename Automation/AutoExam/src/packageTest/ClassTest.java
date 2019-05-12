package packageTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class ClassTest {
	static ChromeDriver driver;
	Functions functions;
	
	@Before
	public void Before(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sanchez Piza\\SeleniumWD\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/sch/");
		driver.findElementByCssSelector("#gh-eb-Geo-a-default > .gh-eb-Geo-flag").click();
		driver.findElementByCssSelector("#gh-eb-Geo-a-en > .gh-eb-Geo-txt").click();
		
	}
	
	@Test

	/*
	 * Test Case to try the state 'New with Box', this state doesn't exist. 
	 * */
	public void TC_01() throws Exception{
		driver.findElementById("gh-ac").sendKeys("Shoes");
		driver.findElementById("gh-btn").click();
		driver.findElementById("w3-w0-w2-w2-0[0]").sendKeys("PUMA");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[2]/ul/li/div/a/span")).click();
		driver.findElementByCssSelector("#w4-w1 .srp-controls__control--legacy").click();
		driver.findElementByCssSelector("#w4-w1 .srp-controls__control--legacy").click();	
		boolean exists = driver.findElements( By.linkText("New with box") ).size() != 0;
		Assert.assertTrue(exists);
	}
	
	@Test
	/*
	 * Test Case to print numbers of results. 
	 * */
	public void TC_02() throws Exception{
		driver.findElementById("gh-ac").sendKeys("Shoes");
		driver.findElementById("gh-btn").click();
		driver.findElementById("w3-w0-w2-w2-0[0]").sendKeys("PUMA");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[2]/ul/li/div/a/span")).click();
		System.out.println(driver.findElementByCssSelector(".srp-controls__count-heading").getText());
	}
	
	@Test

	/*
	 * Test Case to order taking the first 5 results. 
	 * */
	public void TC_03() throws Exception{
		String priceString1 = "";
		String priceString2 = "";
		String priceString3 = "";
		String priceString4 = "";
		String priceString5 = "";
		
		double price1 = 0.0;
		double price2 = 0.0;
		double price3 = 0.0;
		double price4 = 0.0;
		double price5 = 0.0;
		
		driver.findElementById("gh-ac").sendKeys("Shoes");
		driver.findElementById("gh-btn").click();
		driver.findElementById("w3-w0-w2-w2-0[0]").sendKeys("PUMA");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[2]/ul/li/div/a/span")).click();
		driver.findElementByCssSelector("#w4-w3 .srp-controls--selected-value").click();
		driver.findElementByCssSelector("#w4-w3 .srp-controls--selected-value").click();
		driver.findElementByCssSelector(".btn:nth-child(4) span").click();
		
		priceString1=driver.findElementByCssSelector("#srp-river-results-listing1 .s-item__price").getText();
		price1 = Double.parseDouble(priceString1.substring(5,priceString1.length()).replace(",", ""));
		System.out.println(price1);
		priceString2=driver.findElementByCssSelector("#srp-river-results-listing2 .s-item__price").getText();
		price2 = Double.parseDouble(priceString2.substring(5,priceString2.length()).replace(",", ""));
		System.out.println(price2);
		priceString3=driver.findElementByCssSelector("#srp-river-results-listing3 .s-item__price").getText();
		price3 = Double.parseDouble(priceString3.substring(5,priceString3.length()).replace(",", ""));
		System.out.println(price3);
		priceString4=driver.findElementByCssSelector("#srp-river-results-listing4 .s-item__price").getText();
		price4 = Double.parseDouble(priceString4.substring(5,priceString4.length()).replace(",", ""));
		System.out.println(price4);
		priceString5=driver.findElementByCssSelector("#srp-river-results-listing5 .s-item__price").getText();
		price5 = Double.parseDouble(priceString5.substring(5,priceString5.length()).replace(",", ""));
		System.out.println(price5);
		
		System.out.println(functions.CompareOrder(price1, price2));
		Assert.assertTrue(functions.CompareOrder(price1, price2));
		System.out.println(functions.CompareOrder(price2, price3));
		Assert.assertTrue(functions.CompareOrder(price2, price3));
		System.out.println(functions.CompareOrder(price3, price4));
		Assert.assertTrue(functions.CompareOrder(price3, price4));
		System.out.println(functions.CompareOrder(price4, price5));
		Assert.assertTrue(functions.CompareOrder(price4, price5));
		
	}
	
	@Test

	/*
	 * Test Case to take the first 5 results and to print in console. 
	 * */
	public void TC_04() throws Exception{

		driver.findElementById("gh-ac").sendKeys("Shoes");
		driver.findElementById("gh-btn").click();
		driver.findElementById("w3-w0-w2-w2-0[0]").sendKeys("PUMA");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[2]/ul/li/div/a/span")).click();
		driver.findElementByCssSelector("#w4-w3 .srp-controls--selected-value").click();
		driver.findElementByCssSelector("#w4-w3 .srp-controls--selected-value").click();
		driver.findElementByCssSelector(".btn:nth-child(4) span").click();
		
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing1 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing1 .s-item__price").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing2 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing2 .s-item__price").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing3 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing3 .s-item__price").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing4 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing4 .s-item__price").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing5 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing5 .s-item__price").getText());
	
	}
	
	@Test
	
	/*
	 * Test Case to order and print the products by name (ascendant)  this order doesn't exist. 
	 * */
	public void TC_05() throws Exception{

		driver.findElementById("gh-ac").sendKeys("Shoes");
		driver.findElementById("gh-btn").click();
		driver.findElementById("w3-w0-w2-w2-0[0]").sendKeys("PUMA");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[2]/ul/li/div/a/span")).click();
		driver.findElementByCssSelector("#w4-w3 .srp-controls--selected-value").click();
		driver.findElementByCssSelector("#w4-w3 .srp-controls--selected-value").click();
		boolean exists = driver.findElements( By.linkText("Name : ascendant") ).size() != 0;
		Assert.assertTrue(exists);
		
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing1 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing1 .s-item__price").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing2 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing2 .s-item__price").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing3 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing3 .s-item__price").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing4 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing4 .s-item__price").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing5 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing5 .s-item__price").getText());
	
	}
	
	@Test

	/*
	 * Test Case to take the first 5 results and to print in console. 
	 * */
	public void TC_06() throws Exception{

		driver.findElementById("gh-ac").sendKeys("Shoes");
		driver.findElementById("gh-btn").click();
		driver.findElementById("w3-w0-w2-w2-0[0]").sendKeys("PUMA");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[2]/ul/li/div/a/span")).click();
		driver.findElementByCssSelector("#w4-w3 .srp-controls--selected-value").click();
		driver.findElementByCssSelector("#w4-w3 .srp-controls--selected-value").click();
		driver.findElementByLinkText("Price + Shipping: highest first").click();
		
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing1 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing1 .s-item__price").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing2 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing2 .s-item__price").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing3 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing3 .s-item__price").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing4 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing4 .s-item__price").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing5 .s-item__title").getText());
		System.out.println(driver.findElementByCssSelector("#srp-river-results-listing5 .s-item__price").getText());
	
	}
	@After
	public void After(){
		driver.quit();
	}

}
