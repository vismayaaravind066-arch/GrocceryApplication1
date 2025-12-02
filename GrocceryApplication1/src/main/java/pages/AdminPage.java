package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constant;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {
	public WebDriver driver;
	PageUtility page = new PageUtility();
	WaitUtility wait = new WaitUtility();

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(id = "username")
	WebElement usernamefield;
	@FindBy(id = "password")
	WebElement passwordfield;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertypefielddropdown;
	@FindBy(name = "Create")
	WebElement savebutton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchbutton;
	@FindBy(xpath = "//button[@value='sr']")
	WebElement searchbutton2;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successalert;
	@FindBy(xpath = "//a[@class='page-link']")
	WebElement usernameresult;

	public AdminPage addNewUser() {
		newbutton.click();
		return this;
	}

	public AdminPage enterUsernameOnUsernameField(String username1) {
		usernamefield.sendKeys(username1);
		return this;
	}

	public AdminPage enterPasswordOnPasswordField(String password1) {
		passwordfield.sendKeys(password1);
		return this;
	}

	public AdminPage selectingUserType() {
		// wait.waitUntilElementIsVisible(driver, usertypedropdown);
		page.selectDropdownWithVisibletext(usertypefielddropdown, Constant.dropdownvalue);
		// Select select = new Select(usertypedropdown);
		// select.selectByValue("admin");
		return this;
	}

	public AdminPage ClickOnSaveButton() {
		savebutton.click();
		return this;
	}

	public AdminPage clickOnSearchButton() {
		searchbutton.click();
		return this;
	}

	public AdminPage enterUsernameOnSearchAdminUsers(String username) {
		usernamefield.sendKeys(username);
		return this;
	}

	public AdminPage selectUserTypeOnSearchAdminUser() {
		Select select = new Select(usertypefielddropdown);
		select.selectByValue("admin");
		return this;
	}

	public AdminPage clickOnSearchButtonOnAdminSeachUser() {
		searchbutton2.click();
		return this;
	}

	public AdminPage clickOnResetButtonOnAdminUser() {
		resetbutton.click();
		return this;
	}

	public boolean isUserCreationSuccessAlertDisplayed() {
		return successalert.isDisplayed();
	}

	public boolean isSearchedUserDisplayed() {
		return usernameresult.isDisplayed();
	}

	public boolean isResetButtonDisplayed() {
		return resetbutton.isDisplayed();

	}
}
