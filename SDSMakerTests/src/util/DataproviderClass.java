package util;

import org.testng.annotations.DataProvider;


public class DataproviderClass {
	
	
	@DataProvider(name="SDSManufacturer")
	public  static Object[][]  getSDSManufacturer(){
		return new Object[][] { 
				{"Bay91126","uzxgU3LR"}  
			};
     }
}
	

