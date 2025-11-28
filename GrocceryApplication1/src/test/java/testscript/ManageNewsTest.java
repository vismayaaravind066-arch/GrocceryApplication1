package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage homepage;
	ManageNewsPage managenewspage;
	@Test
	public void verifyUserAbleToAddNewNews() throws IOException
	{
		String username= ExcelUtility.getStringData(0, 0, "LoginPage");
		String password= ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		
		homepage=loginpage.clickOnSignInButton();
		//HomePage homepage = new HomePage(driver);
		managenewspage=homepage.clickOnManageNewsMoreInfoLink();
		
		String news= ExcelUtility.getStringData(0, 0, "ManageNews");

		//ManageNewsPage managenews = new ManageNewsPage(driver);
		managenewspage.addNewNews().enterNewsOnNewsField(news).clickOnSaveButton();
		
		boolean isAddedNewsDisplayed = managenewspage.isNewsCreatedSuccessfullyDisplayed();
		Assert.assertTrue(isAddedNewsDisplayed,Constant.addingnewserrormessage);
		
	}
		@Test
		public void verifyUserAbleToSearchAddedNews() throws IOException
		{
			String username= ExcelUtility.getStringData(0, 0, "LoginPage");
			String password= ExcelUtility.getStringData(0, 1,"LoginPage");
			
			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
			
			homepage=loginpage.clickOnSignInButton();
			//HomePage homepage = new HomePage(driver);
			managenewspage=homepage.clickOnManageNewsMoreInfoLink();
			String news= ExcelUtility.getStringData(0, 0, "ManageNews");

			//ManageNewsPage managenews = new ManageNewsPage(driver);
		
			managenewspage.clickOnSearchButtonOnManageNews().enterNewsOnTitleField(news).clickOnSearchButtonOnSearchingNews();
			
			boolean issearchbuttondisplayed=managenewspage.isSearchedNewsDisplayed();
			Assert.assertTrue(issearchbuttondisplayed,Constant.searchingnewserrormessage);
		}
		
}



