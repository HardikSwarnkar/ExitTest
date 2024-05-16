package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class colorChange {
	  WebDriver driver = null;

public colorChange(WebDriver driver) {
    this.driver = driver;
}


public void changeColor() throws InterruptedException {
  
    WebElement color1= driver.findElement(By.xpath("//li[@id=\"swatch-0-color\"]"));
    color1.click();
    Thread.sleep(1000);
    WebElement color2= driver.findElement(By.xpath("//li[@id=\"swatch-1-color\"]"));
    color2.click();
    Thread.sleep(1000);
    WebElement color3= driver.findElement(By.xpath("//li[@id=\"swatch-2-color\"]"));
    color3.click();
    Thread.sleep(2000);
        
     
   
}
}

