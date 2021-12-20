package co.parabank.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.parabank.Pages.LandingPage;
import com.parabank.TestBase.TestBase;
import com.parabank.Utils.ExcelUtils;

public class LandingPageTest extends TestBase {
	LandingPage lp;
	
@BeforeMethod
	public void intialise() {
		setUp();
		lp = new LandingPage();
	}
@Test(priority = 2)
public void verfiyLogin()
{
   lp.signUp();
   String banTxt= lp.verifyLogin();
   Assert.assertTrue(banTxt.contains("jijo"));
   lp.logOut();
 
}
@Test(priority = 3,dataProvider = "Login")
public void loginVerify(String email,String pcode) {
	lp.login(email, pcode);
}

@DataProvider(name = "Login")
public String[][] dataProviderForContactUs() throws Exception {
	String path = "C:\\Users\\Jiji\\Desktop\\Assignments\\username.xlsx";
	
	int rowsCount = ExcelUtils.getRowCount(path, "Sheet1");
	int cellCount = ExcelUtils.getColumCount(path, "Sheet1", rowsCount);

	String[][] excelData = new String[rowsCount][cellCount];

	for (int i = 1; i <= rowsCount; i++) {
		for (int j = 0; j < cellCount; j++) {
			excelData[i - 1][j] = ExcelUtils.getData(path, "Sheet1", i, j);

		}

	}
	 System.out.println(excelData);
	return excelData;
}



@AfterMethod
public void quitBrowser() {
	tearDown();
}
}
