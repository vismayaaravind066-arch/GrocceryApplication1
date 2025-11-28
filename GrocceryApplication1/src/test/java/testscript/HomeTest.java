package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage homepage;
	
		@Test(description="verify user can logout successfully,",retryAnalyzer = retry.Retry.class)
		 public void verifyUserCanLogoutSuccessfully() throws IOException
		   {
			   String username= ExcelUtility.getStringData(0, 0, "LoginPage");
			   String password = ExcelUtility.getStringData(0, 1,"LoginPage");
			   LoginPage loginpage = new LoginPage(driver);
			   loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
			   
		       homepage=loginpage.clickOnSignInButton();
			   
			   homepage.clickOnAdminIcon();
			   loginpage=homepage.clickOnLogoutButton();
			   boolean issigntextdisplayed=homepage.clickOnIsSigninTextDisplayed();
			   Assert.assertTrue(issigntextdisplayed,Constant.logouterrormessage);

	}

}
