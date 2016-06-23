package sdsTests;

import sdsPages.Browser;
import sdsPages.CreateSDS;
import sdsPages.SDSList;
import sdsPages.SDSLogin;
import util.GenerateData;
public class SDSBaseTest {
	//String username = "Bay91126";
	//String password = "uzxgU3LR";
	
	public GenerateData gendata = new GenerateData();
	
	SDSLogin 		 slogon;
	SDSList 		 sdslist;
	
	CreateSDS		 crsds;

	
	String 	         impcomp="3M NORGE AS";    //name of the impersonated manufacturer
	
	
	protected SDSList SDSSignIn (String usr, String pass) {
		SDSLogin slogon = new SDSLogin(Browser.driver);
		slogon.get();
  	    slogon.SDSManufacturerLogin(usr, pass);
  		return new SDSList();
	}
		
 public static void RunBrowser() {
	 Browser.initChrome();
	 //Browser.initFF();
 	 //Browser.initIE();
 }
	
}
