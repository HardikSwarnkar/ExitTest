package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class compareProducts{
   
    private WebDriver driver;

    public compareProducts(WebDriver driver) {
        this.driver = driver;
    }

public void compare() throws InterruptedException {

Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div[2]/div/div/div/a/div[1]/div[2]/div/label/span")).click();
driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div[3]/div/div/div/a/div[1]/div[2]/div/label/span")).click();
driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[4]/div/a/span/span")).click();
Thread.sleep(2000);
}
    
    

}


