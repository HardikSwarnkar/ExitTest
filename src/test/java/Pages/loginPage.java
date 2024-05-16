package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class loginPage {
    private WebDriver driver;
 
   
   
    private By inputElementLocator = By.xpath("//div[@class=\"I-qZ4M vLRlQb\"]/input[@class=\"r4vIwl BV+Dqf\"]");

    public loginPage(WebDriver driver) {
        this.driver = driver;
     
    }

    
    public void performLogin(String phoneNumber) {
      
            driver.get("https://www.flipkart.com/account/login?ret=/");
            

            WebElement inputElement = driver.findElement(inputElementLocator);
            inputElement.clear();
            inputElement.sendKeys(phoneNumber);
            inputElement.sendKeys(Keys.ENTER);
           
       
    }
}