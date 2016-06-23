package sdsTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sdsPages.Browser;
import util.DataproviderClass;

public class SDSTest1 extends SDSBaseTest {

	@BeforeMethod
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("SDS Maker - open SDS menus!");
    	System.out.println("--------------------------------------------");
    	//Browser.initFF();
    	
    	Browser.initChrome();
		//Browser.initIE();
	}
	
    @AfterMethod
    public void ShutDown() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");  
    	System.out.println("--------------------------------------------");
    	Browser.quit();
    }


    //select all menus with role Manufacturer RW
    @Test(dataProvider="SDSManufacturer",dataProviderClass=DataproviderClass.class)
    public void SDSTESTManufacturerMenus(String uname, String pass) {
    	System.out.println("SDS Maker-Select all menus for role ManufacturerRW");
    	System.out.println("--------------------------------------------");
    	sdslist=super.SDSSignIn(uname,pass);
    	crsds=sdslist.navigateToCreateSDS();
    }

  

}
