package com.parabank.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.parabank.TestBase.TestBase;
import com.parabank.Utils.ExcelUtils;



public class LandingPage extends TestBase {

	public LandingPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "customer.firstName")
	WebElement firstName;
	@FindBy(id = "customer.lastName")
	WebElement lastName;
	@FindBy(id = "customer.address.street")
	WebElement address;
	@FindBy(id = "customer.address.city")
	WebElement city;
	@FindBy(id = "customer.address.state")
	WebElement state;
	@FindBy(id = "customer.address.zipCode")
	WebElement zipcode;
	@FindBy(id = "customer.phoneNumber")
	WebElement phone;
	@FindBy(id = "customer.ssn")
	WebElement ssn;
	@FindBy(id = "customer.username")
	WebElement userName;
	@FindBy(id = "customer.password")
	WebElement passcode;
	@FindBy(id = "repeatedPassword")
	WebElement confirmPasscode;
	@FindBy(css = "input[value='Register']")
	WebElement submitBtn;

	@FindBy(css = ".title")
	WebElement banerText;

	@FindBy(css = "input[name='username']")
	WebElement inputUserName;
	@FindBy(css = "input[name='password']")
	WebElement inputPasscode;
	@FindBy(css = "input[value='Log In']")
	WebElement loginButton;

	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	WebElement logout;

	public void signUp() {
		firstName.sendKeys("jijo");
		lastName.sendKeys("ms");
		address.sendKeys("81 hans rd");
		city.sendKeys("bramption");
		state.sendKeys("kerala");
		zipcode.sendKeys("64664");
		phone.sendKeys("56879322");
		ssn.sendKeys("556699");
		userName.sendKeys("jijo123456");
		passcode.sendKeys("psw123");
		confirmPasscode.sendKeys("psw123");
		submitBtn.submit();

	}

	public String verifyLogin() {
		banerText = wd.findElement(By.cssSelector(".title"));
		String lableCaption = banerText.getText();
		// Assert.assertTrue(lableCaption.contains("sabu1"));
		// Assert.assertEquals(lableCaption, "Welcome sabu4");
		return lableCaption;
	}

	public void logOut() {
		logout.click();
	}

	public void login(String email,String pascode) {
		
		inputUserName.sendKeys(email);
		inputPasscode.sendKeys(pascode);
		loginButton.submit();
		
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
}
