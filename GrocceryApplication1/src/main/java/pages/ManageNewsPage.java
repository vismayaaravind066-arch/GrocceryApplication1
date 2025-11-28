package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger' and @onclick='click_button(1)']")
	WebElement newButton;
	@FindBy(id="news") WebElement newsfield;
	@FindBy(xpath="//button[@type='submit']") WebElement savebutton;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchbutton;
	@FindBy(name="un") WebElement newstitlefield;
	@FindBy(xpath="//button[@value='sr']") WebElement searchbutton1;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")WebElement resetbutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successnewsalert;
	


public ManageNewsPage addNewNews()
{
	newButton.click();
	return this;
}
public ManageNewsPage enterNewsOnNewsField(String news)
{
	newsfield.sendKeys(news);
	return this;
}
public ManageNewsPage clickOnSaveButton()
{
	savebutton.click();
	return this;
}
public ManageNewsPage clickOnSearchButtonOnManageNews()
{
	searchbutton.click();
	return this;
}
public ManageNewsPage enterNewsOnTitleField(String news)
{
	newstitlefield.sendKeys(news);
	return this;
}
public ManageNewsPage clickOnSearchButtonOnSearchingNews()
{
	searchbutton1.click();
	return this;
}
public ManageNewsPage clickOnResetButton()
{
	resetbutton.click();
	return this;
}
public boolean isNewsCreatedSuccessfullyDisplayed()
{
	return successnewsalert.isDisplayed();   
}
public boolean isSearchedNewsDisplayed()
{
	return searchbutton1.isDisplayed();
}

}



