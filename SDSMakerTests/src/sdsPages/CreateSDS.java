package sdsPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateSDS extends LoadableComponent<CreateSDS>{
	private final static String title = "Opprett SDS";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	@FindBy(how=How.ID, using ="cpmain_btnSave")   
	WebElement SDSCreateBtn;
	@FindBy(how=How.ID, using ="cpmain_ucSDSList_gvSDSList")   
	WebElement SDSListGrid;


	
	public CreateSDS() {
		PageFactory.initElements(Browser.driver, this);
	}
	
	@Override
	protected void load() {
	}
	
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
	  System.out.println("--------------------------------------------");
	}
	
    public void SelectSDSType(int typeno) {
    	List<WebElement> st = Browser.driver.findElements(By.xpath("//*[@type='radio']"));
    	System.out.println("Radio buttons size:"+st.size());
    	if (!st.get(typeno).isSelected()) {
    	     st.get(typeno).click();
    	   } else {System.out.println("SDS type is already selected"); }
    	Browser.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	System.out.println("--------------------------------------------");
    }	
	

    
}
