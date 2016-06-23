package sdsPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SDSList extends LoadableComponent<SDSList> {
	private final static String title = "SDS Liste";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	 
	//SDS manufacturerRW menu items
	  @FindBy(how=How.LINK_TEXT, using ="Lage SDS")
	  WebElement MenuCreateSDS;
	  @FindBy(how=How.LINK_TEXT, using ="Liste over SDS")
	  WebElement MenuSDSList;
	  @FindBy(how=How.LINK_TEXT, using ="Importer SDS fra XML")
	  WebElement MenuImportSDS;
	  @FindBy(how=How.LINK_TEXT, using ="Setningsbibliotek")
	  WebElement MenuPhraseLib;
	  @FindBy(how=How.LINK_TEXT, using ="Stoffdatabase")
	  WebElement MenuSubstanceDB;
	  @FindBy(how=How.LINK_TEXT, using ="Eksponeringsscenario")
	  WebElement MenuExposureScn;
	  @FindBy(how=How.LINK_TEXT, using ="Brukeradministrasjon")
	  WebElement MenuSDSUserAdmin;
	  @FindBy(how=How.LINK_TEXT, using ="Min brukerkonto")
	  WebElement MenuSDSMyAccount;
	  @FindBy(how=How.LINK_TEXT, using ="Bedriftsprofil")
	  WebElement MenuSDSCompProfile;
	  @FindBy(how=How.LINK_TEXT, using ="Avansert søk")
	  WebElement MenuSDSAdvSearch;
	  @FindBy(how=How.ID, using ="cpmain_ucSDSList_gvSDSList_imgGrayPen_0")   
	  WebElement FirstSDSEditBtn;
	  
	  //in addition for role puncher
	  @FindBy(how=How.LINK_TEXT, using ="Velg leverandør")
	  WebElement MenuSelectSupplier;

	public SDSList() {
		PageFactory.initElements(Browser.driver, this);
	}
	
	@Override
	protected void load() {
	}
	
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblManufacturer")).getText());
	  System.out.println("--------------------------------------------");
	}
	


    
    public  CreateSDS navigateToCreateSDS() {
        wait.until(ExpectedConditions.elementToBeClickable(MenuCreateSDS));
        MenuCreateSDS.click();
      	 System.out.println("Selected SDS menu Create SDS");
      	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
      	 System.out.println("Loaded page: "+Browser.driver().getTitle());
        System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
        System.out.println("--------------------------------------------");
        return new CreateSDS();
   	} 
  
    
}
