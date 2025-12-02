package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();

	public HomePage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminicon;

	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logoutoption;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	WebElement adminMoreInfoLink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	WebElement manageNewsMoreInfoLink;
	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	WebElement signintext;

	public HomePage clickOnAdminIcon() {
		wait.waitUntilElementToBeClickable(driver, adminicon);
		adminicon.click();
		return this;
	}

	public LoginPage clickOnLogoutButton() {
		logoutoption.click();
		return new LoginPage(driver);
	}

	public AdminPage clickOnAdminMoreInfoLink() {
		adminMoreInfoLink.click();
		return new AdminPage(driver);

	}

	public ManageNewsPage clickOnManageNewsMoreInfoLink() {
		manageNewsMoreInfoLink.click();
		return new ManageNewsPage(driver);
	}

	public boolean clickOnIsSigninTextDisplayed() {
		return signintext.isDisplayed();
	}

}
