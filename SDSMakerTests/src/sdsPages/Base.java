package sdsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
protected WebDriverWait wait;
	
	protected WebDriver driver;
	
	public Base(WebDriver driver){
		this.driver=driver;
	}
	
	public void visit (String url){
		driver.get(url);
	}
	
	public WebElement find (By locator){
		return driver.findElement(locator);
	}
	
	public void click(By locator){
		find(locator).click();
	}

	public void clear(By locator){
		find(locator).clear();
	}
	
	public void type(String inputText, By locator){
		for (char ch : inputText.toCharArray()) {
			find(locator).sendKeys(Character.toString(ch));
		}
	}
	
	public String getTextOfElement(By locator){
		return find(locator).getText();
	}
	
	public Boolean isDisplayed(By locator){
		try {
			return find(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public Boolean isDisplayed(By locator, int MaxTime){
		try {
			waitFor(ExpectedConditions.visibilityOfElementLocated(locator),MaxTime);
		} catch (org.openqa.selenium.TimeoutException e) {
			return false;
		}
		return true;
	}
	
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout){
		timeout=timeout !=null?timeout:5;
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(condition);
	}
	
}
