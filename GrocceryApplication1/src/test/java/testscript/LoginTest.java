package testscript;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage homepage;
	@Test(priority=1,description="verifyingsuccessfulluserloginwithvalidcredentials")
	public void verifyUserLoginWithValidCredentials() throws IOException
 	{
      String username = ExcelUtility.getStringData(0, 0, "LoginPage");
      String password = ExcelUtility.getStringData(0, 1,"LoginPage");
      LoginPage loginpage=new LoginPage(driver);
       	    loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);//method chain
      	homepage=loginpage.clickOnSignInButton();
      	boolean isdashBoarddisplay=loginpage.dashBoardDisplay();
      	Assert.assertTrue(isdashBoarddisplay,Constant.Validcredentialerrormessage);
 	}
	@Test(priority=2,description="verifyingloginfailswithvalidusernameandinvalidpassword")
	public void verifyUserloginWithValidUsernameAndInvalidPassword() throws IOException
	{
		 String username = ExcelUtility.getStringData(1, 0, "LoginPage");
	      String password = ExcelUtility.getStringData(1, 1,"LoginPage");
	      LoginPage loginpage=new LoginPage(driver);
	       	    loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
	      		loginpage.enterPasswordOnPasswordField(password);
	    loginpage.clickOnSignInButton();
	    String actual=loginpage.getTitle();
	    String expected="7rmart supermarket";
	    Assert.assertEquals(actual, expected,Constant.invalidusernameerrormessage);
	}
	@Test(priority=3,description="verifyingloginfailswithvalidpasswordandinvalidusername")
	public void verifyUserloginWithInValidUsernameAndvalidPassword() throws IOException
	{
		 String username = ExcelUtility.getStringData(1, 0, "LoginPage");
	      String password = ExcelUtility.getStringData(1, 1,"LoginPage");
	      LoginPage loginpage=new LoginPage(driver);
	       	    loginpage.enterUsernameOnUsernameField(username);
	      		loginpage.enterPasswordOnPasswordField(password);
	      	loginpage.clickOnSignInButton();
	      	 String actual=loginpage.getTitle();
	 	    String expected="7rmart supermarket";
	 	    Assert.assertEquals(actual, expected,Constant.invalidpassworderrormessage);
	}
	@Test(priority=4,description="verifying loginfails with invalidcredentials",dataProvider="loginProvider")
	public void verifyUserLoginWithInValidCredentials(String username,String password) throws IOException
 	{
      //String username = ExcelUtility.getStringData(2, 0, "LoginPage");
     // String password = ExcelUtility.getStringData(2, 1,"LoginPage");
      LoginPage loginpage=new LoginPage(driver);
       	    loginpage.enterUsernameOnUsernameField(username);
      		loginpage.enterPasswordOnPasswordField(password);
      	loginpage.clickOnSignInButton();
      	 String actual=loginpage.getTitle();
 	    String expected="7rmart supermarket";
 	    Assert.assertEquals(actual, expected,Constant.invalidcredebtialerrormessage);
      	
 	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
}

	
}
		

		


	
	
	



