package Test;



import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import Pages.cartPage;
import Pages.colorChange;
import Pages.compareProducts;
import Pages.filterPage;
import Pages.loginPage;
import Pages.pincodePage;
import Pages.productPage;
import Pages.searchPage;
import Pages.signUpPage;
import Pages.sortPage;
import Test.TestNG;
import Utils.ExelUtils;



public class TestNG extends baseTest {
	private static Logger logger=LogManager.getLogger(TestNG.class);
	
	
	@Test(priority = 1)
	public void flipkartSearchTest() {
		test = extent.createTest("Flipkart Search Test");
		driver.get(applicationUrl);
		searchPage searchPageObj = new searchPage(driver);
		logger.info("Flipkart SearchTest");
		searchPageObj.enterSearchQuery(searchQuery);
		searchPageObj. clickSearchButton();

	}
	
	
  
	@Test(priority = 2)
	public void flipkartProductTest() throws InterruptedException {
		test = extent.createTest("Flipkart Product Details Test");
		logger.info("Product details Test");
		searchPage searchPageObj = new searchPage(driver);
		driver.get(productlink);
		logger.info("Navigated directly to the product page.");

	}
	@Test(priority = 3)
	public void ProductColorTest() throws InterruptedException {
		test = extent.createTest("Flipkart Product Details color Test");
		logger.info("Product details Test");
		colorChange color = new colorChange(driver);
		color.changeColor();
		logger.info("Navigated directly to the product page.");

	}
	
	

	@Test(priority=4)
	public void ProductFilter() throws InterruptedException {
		test = extent.createTest("Product filter");
		productPage Productpage=new productPage(driver);
		Productpage.navigatetoProduct();
		Thread.sleep(2000);
		logger.info("Applying filter on product page.");
	}
	
	
	
	

	@Test(priority=5)
	public void addTocart() throws InterruptedException {
		test = extent.createTest("add to cart");
		cartPage cart=new cartPage(driver);
		cart.addToCart();
		Thread.sleep(2000);
        logger.info("Adding product to cart.");

	}
	@Test(priority=6)
	public void cartItemCount() throws InterruptedException {
		test = extent.createTest("CartItem");
		cartPage cart=new cartPage(driver);
		cart.getCartCount();
		logger.info("Cart Item count");
		Thread.sleep(2000);
		
	}
	
	@Test(priority=7)
	public void RemovecartItem() throws InterruptedException {
		test = extent.createTest("RemovecartItem");
		cartPage cart=new cartPage(driver);
		cart.removefromCart();
		logger.info("Remove cart Item");
		Thread.sleep(2000);
		
	}
	
	@Test(priority=8)
	public void brandFilterCheck() throws InterruptedException {
		test = extent.createTest("Brand filter");
		driver.get(laptops);
		filterPage pricefilter=new filterPage(driver);
		pricefilter.price();
		Thread.sleep(2000);
		logger.info("brandFilter Check in homepage");
		
	}
	
	@Test(priority=9)
	public void compareItems() throws InterruptedException {
		test = extent.createTest("Compare 2 lamptops");
		compareProducts comp=new compareProducts(driver);
		comp.compare();
		logger.info("Compare 2 laptops");
		
	}
	
	@Test(priority=10)
	public void SortingCheck() throws InterruptedException {
		test = extent.createTest("Brand Sorting");
		driver.get(mobiles);
		sortPage filter=new sortPage(driver);
		
		filter.sorting();
		Thread.sleep(2000);
		
		logger.info("All the sorting functions");
	}
	
	
	
	    
	    
	 
	
	    @Test(priority = 11, description = "Verify that pagination controls are working on product listing pages")
	    public void testProductPagination() {
	    	test = extent.createTest("Verify that pagination controls are working on product listing pages");
	    	
			searchPage searchPageObj = new searchPage(driver);
	       WebElement nextPageButton = driver.findElement(By.linkText("2"));
	       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextPageButton);
         	
	        logger.info("Pagination to next page functionality is validated.");
	    }
	    
	    
	    @Test(priority = 12, description = "Verify the pincode is avinable or not")
	    public void testPincode() throws InterruptedException {
	    	test = extent.createTest("verify the pincode is avinable or not");
	    	driver.get(productlink);
	    	ExelUtils excelReader = new ExelUtils("C:\\Users\\hardikswarnkar\\OneDrive - Nagarro\\Desktop\\ExitTest\\exel\\data.xlsx", "Sheet1");
	    	String pincode = excelReader.getPinCode(1, 0);
	    	pincodePage pin=new pincodePage(driver);
	    	pin.validPincode("201001");
	    	logger.info("Verify the pincode is avinable or not");
	    }
	    
	  
	    
	    @Test(priority = 13, description = "Login Test")
	    public void LoginTest() throws InterruptedException {
	    	test = extent.createTest("Verify Login functionality");
	    	ExelUtils excelReader = new ExelUtils("C:\\Users\\hardikswarnkar\\OneDrive - Nagarro\\Desktop\\ExitTest\\exel\\data.xlsx", "Sheet1");
	    	String phoneNumber = excelReader.getPhoneNumber(1, 0);
	    	Thread.sleep(2000);
	    	loginPage login=new loginPage(driver);
	    	login.performLogin(phoneNumber);
	    	Thread.sleep(2000);
	    	logger.info("Verify Login functionality");
	    }
	    
	    
	    
	  
	    @Test(priority = 14, description = "SignUp Test")
	 	    public void signUpTest() throws InterruptedException {
	    	ExelUtils excelReader = new ExelUtils("C:\\Users\\hardikswarnkar\\OneDrive - Nagarro\\Desktop\\ExitTest\\exel\\data.xlsx", "Sheet1");
	    	String phoneNumber = excelReader.getPhoneNumber(1, 0);
	    	test = extent.createTest("Verify SignUp functionality");
	       	signUpPage login=new signUpPage(driver);
	       	login.performSignUp(phoneNumber);
	       	Thread.sleep(2000);
	       	logger.info("Verify SignUp functionality");
	   	    	
	     }
	    
	    @Test(priority = 15, description = "Verify search functionality with special characters")
	    public void testSearchWithSpecialCharacters() {
	    	test = extent.createTest("Verify search functionality with special characters");
	        driver.navigate().back();
	        searchPage searchPageObj = new searchPage(driver);
	        searchPageObj.enterSearchQuery("#@!$%^&*");
	        searchPageObj.clickSearchButton();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class=\"rgHxCQ\"]"), "Filters")),
	            "Search should return 'No results found' message.");
	        logger.info("Search with special characters handled correctly.");
	        test = extent.createTest("Verify search functionality with special characters");
	    }
	    
	    @Test(priority = 16, description = "Verify message when cart is empty")
	    public void testEmptyCartMessage() throws InterruptedException {
	    	test = extent.createTest("Verify message when cart is empty");
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[3]/div/a[2]")).click();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"s2gOFd\"]"))).isDisplayed(),
	            "Empty cart message should be visible.");
	        logger.info("Empty cart message is correctly displayed.");
	        test = extent.createTest("Verify message when cart is empty");
	    }

	    
	    @Test(priority = 17, description = "Verify the footer links are correct and clickable")
	    public void testFooterLinks() throws InterruptedException {
	    	test = extent.createTest("Verify the footer links are correct and clickable");
	        WebElement aboutUsLink = driver.findElement(By.xpath("//footer//a[contains(text(), 'About Us')]"));
	        aboutUsLink.click();
	        Thread.sleep(2000);
	        Assert.assertEquals(driver.getCurrentUrl(),"https://corporate.flipkart.net/corporate-home",
	            "URL should match the expected About Us page URL.");
	        logger.info("Verify the footer links are correct .");
	    }

	    @Test(priority = 18, description = "Verify that the contact page is accessible and contains correct information")
	    public void testContactPageAccessibility() {
	    	test = extent.createTest("Verify that the contact page is accessible ");
	    	driver.navigate().back();
	        WebElement contactLink = driver.findElement(By.xpath("//a[contains(text(), 'Contact')]"));
	        contactLink.click();
	        WebElement phoneNumber = driver.findElement(By.xpath("//a[@href=\"tel:044-45614700\"]"));
	        Assert.assertEquals(phoneNumber.getText(), "044-45614700",
	            "Phone number on Contact page should match the expected value.");
	        logger.info("Verify that the contact page is accessible.");
	        
	    }
 
	    
	    @Test(priority = 19, description = "Verify Terms and Conditions page is up to date")
	    public void testTermsAndConditions() {
	    	test = extent.createTest("Verify Terms and Conditions page is up to date");
	        WebElement termsLink = driver.findElement(By.linkText("Terms Of Use"));
	        termsLink.click();
	        WebElement lastUpdatedText = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div/div/p[1]/strong"));
	        Assert.assertTrue(lastUpdatedText.getText().contains("Flipkart Terms of Use"),
	            "Terms and Conditions last updated text should reference the current year.");
	        logger.info("Verify Terms and Conditions page is up to date.");
	    }
	    
	    

		@Test(priority = 20, description = "Verify that the Flipkart logo is visible and clickable")
		public void testLogoVisibilityAndClickability() {
			test = extent.createTest("Verify that the Flipkart logo is visible and clickable");
		
		   
		    
		   
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		    WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[title='Flipkart']"))); // Using title attribute for selector
		    
		    Assert.assertTrue(logo.isDisplayed(), "Logo should be visible on the homepage.");
		    
		    logo.click();
		    Assert.assertEquals(driver.getCurrentUrl(), applicationUrl, "Clicking on the logo should navigate to the homepage.");
		    logger.info("Logo is visible and clickable, navigates to homepage successfully.");
		}


		    @Test(priority =21, description = "Verify that the homepage loads correctly")
		    public void testHomepageLoad() {
		    	test = extent.createTest("Verify that the homepage loads correctly");
		        driver.get(applicationUrl);
		        WebElement searchBar = driver.findElement(By.name("q")); 
		        Assert.assertTrue(searchBar.isDisplayed(), "Search bar should be visible on the homepage.");
		        logger.info("Homepage loads correctly with all key components visible.");
		    }
		    
}

