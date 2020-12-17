package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchPage {
	
    private static WebElement element;
    
    @Test
    public static WebElement tryItNowLabel(WebDriver driver){
    	element = driver.findElement(By.xpath("//h1[contains(text(),'Try it now!')]"));
		return element;
	}
    
    public static WebElement searchInput(WebDriver driver) {
    	element = driver.findElement(By.xpath("//input[@id='interactive']"));
		return element;
	}
    
    public static WebElement requestBtn(WebDriver driver) {
    	element = driver.findElement(By.xpath("//button[contains(text(),'request')]"));
		return element;
	}
    
    public static WebElement output(WebDriver driver) {
    	element = driver.findElement(By.cssSelector("#interactive_output"));
		return element;
	}
}
