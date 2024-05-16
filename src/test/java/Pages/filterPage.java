
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class filterPage{
  
    
    WebDriver driver=null;
    
	public filterPage(WebDriver driver) {
		
		this.driver=driver;
	}
    
    
    public void price() {
    	WebElement price_dropdown = driver.findElement(By.xpath(("//div[@class='tKgS7w']//select[contains(@class, 'Gn+jFg')]")));
    
    	Select priceRange=new Select(price_dropdown);
    	
    	try {
            // Try to select "40000"
            priceRange.selectByValue("20000");
        } catch (NoSuchElementException e) {
            // If "40000" is not available, try to select "30000"
            try {
                priceRange.selectByValue("35000");
            } catch (NoSuchElementException ex) {
                // If "30000" is also not available, handle the case (e.g., log an error, throw an exception)
                System.err.println("Neither '40000' nor '30000' options are available in the dropdown.");
            }
        }

    	
    }
    
}
