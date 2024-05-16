package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class sortPage {

    WebDriver driver = null;
    JavascriptExecutor js = null;

    public sortPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    private void clickElementByJs(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void selectSortByPriceLowToHigh() {
        WebElement priceLowToHigh = driver.findElement(By.xpath("//div[@class='sHCOk2']/div[text()='Price -- Low to High']"));
        clickElementByJs(priceLowToHigh);
    }

    public void selectSortByPriceHighToLow() {
        WebElement priceHighToLow = driver.findElement(By.xpath("//div[@class='sHCOk2']/div[text()='Price -- High to Low']"));
        clickElementByJs(priceHighToLow);
    }

    public void selectSortByNewestFirst() {
        WebElement newestFirst = driver.findElement(By.xpath("//div[@class='sHCOk2']/div[text()='Newest First']"));
        clickElementByJs(newestFirst);
    }

    public void selectSortByPopularity() {
        WebElement popularity = driver.findElement(By.xpath("//div[@class='sHCOk2']/div[text()='Popularity']"));
        clickElementByJs(popularity);
    }

    public void sorting() {
    	selectSortByPopularity();
        selectSortByPriceLowToHigh();
        selectSortByPriceHighToLow();
        selectSortByNewestFirst();
        
    }
}
