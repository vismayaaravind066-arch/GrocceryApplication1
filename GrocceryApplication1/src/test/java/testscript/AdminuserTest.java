package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminuserTest extends Base{
	HomePage homepage;
	AdminPage adminpage;
	@Test(priority=1,description="verifying user is able to add new user")
	public void verifyUserAbleToAddNewAdminUser() throws IOException
	{
		
		 String username = ExcelUtility.getStringData(0, 0, "LoginPage");
	      String password = ExcelUtility.getStringData(0, 1,"LoginPage");
			
			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
			
			homepage=loginpage.clickOnSignInButton();
			//HomePage homepage = new HomePage(driver);
			adminpage=homepage.clickOnAdminMoreInfoLink();
			
			//String username1=ExcelUtility.getStringData(0, 0, "AdminPage");
			//String password1=ExcelUtility.getStringData(0, 1, "AdminPage");
			
			
			
			
		//AdminPage adminpage = new AdminPage(driver);
		
		adminpage.addNewUser();
		FakerUtility faker = new FakerUtility();
		String username1=faker.createRandomUsername();
		String password1=faker.createRandomPassword();
		adminpage.enterUsernameOnUsernameField(username1).enterPasswordOnPasswordField(password1).selectingUserType().ClickOnSaveButton();
		boolean isAlertDisplayed=adminpage.isUserCreationSuccessAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,"user unable to add new admin user successfully ");
	}
		@Test(priority=2,description="verifying user is able to search newly added user")

	public void verifyUserAbleToSearchNewlyAddedAdminUser() throws IOException
	{
		String username= ExcelUtility.getStringData(0, 0, "LoginPage");
		String password= ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnSignInButton();
		//HomePage homepage = new HomePage(driver);
		homepage.clickOnAdminMoreInfoLink();
		
		AdminPage adminpage = new AdminPage(driver);
		adminpage.clickOnSearchButton();
		String username1= ExcelUtility.getStringData(0,0, "AdminPage");

		adminpage.enterUsernameOnSearchAdminUsers(username1).selectUserTypeOnSearchAdminUser().clickOnSearchButtonOnAdminSeachUser();
		
		
		boolean isNewUserSearched=adminpage.isSearchedUserDisplayed();
		Assert.assertTrue(isNewUserSearched,"user unable to search new admin user");
				
						

	}
		@Test(priority=3,description="verifying user is able to reset admin user")
		public void verifyUserAbleToResetAdminUser() throws IOException
		{
			String username= ExcelUtility.getStringData(0, 0, "LoginPage");
			String password= ExcelUtility.getStringData(0, 1,"LoginPage");
			
			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
			
			homepage=loginpage.clickOnSignInButton();
			HomePage homepage = new HomePage(driver);
			homepage.clickOnAdminMoreInfoLink();
			AdminPage adminpage = new AdminPage(driver);
			adminpage.clickOnResetButtonOnAdminUser();
			boolean isResetButtonDisplayed=adminpage.isResetButtonDisplayed();
			Assert.assertTrue(isResetButtonDisplayed,"user unable to reset user info");
			

			
		}
	
		
		
	
	

}





