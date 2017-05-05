package Page.Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateEmployeePage extends EmployeeDetails {

	private static final String addButtonWebElement = "html/body/div[1]/div/div/form/fieldset/div/button[2]";
	private static final String cancelButtonWebElement = ".//*[@id='sub-nav']/li/a";
	
	
	public WebElement addButton(WebDriver driver)
	{
		return driver.findElement(By.xpath(addButtonWebElement));
		
	}
	public WebElement cancelButton(WebDriver driver)
	{
		return driver.findElement(By.xpath(cancelButtonWebElement));
		
	}
	
	public void addButtonClick(WebDriver driver)
	{
		addButton(driver).click();
	}
	public void cancelButtonClick(WebDriver driver)
	{
		cancelButton(driver).click();
	}
	
}
