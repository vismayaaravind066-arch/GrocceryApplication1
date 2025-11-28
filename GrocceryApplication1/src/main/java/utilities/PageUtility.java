package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}
	public void selectDropdownWithVisibletext(WebElement element,String text) {
		Select object=new Select(element);
		object.selectByVisibleText(text);
	}
	public void selectChechbox(WebElement element) {
		element.click();
	
	}
	public void selectDropdown(WebElement element) {
		Select object=new Select(element);
	}
	public void selectRightClick(WebElement driver,WebElement element)
	{
		element.click();
	}
	

}
