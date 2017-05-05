package Page.Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditEmployeePage extends EmployeeDetails{
	
	private static final String updateButtonWebElement = "html/body/div[1]/div/div/form/fieldset/div/button[1]";
	private static final String deleteButtonWebElement = "html/body/div[1]/div/div/form/fieldset/div/p";
	private static final String backButtonWebElement = ".//*[@id='sub-nav']/li/a";
	
	public WebElement updateButton(WebDriver driver)
	{
		return driver.findElement(By.xpath(updateButtonWebElement));
		
	}
	public WebElement deleteButton(WebDriver driver)
	{
		return driver.findElement(By.xpath(deleteButtonWebElement));
		
	}
	public WebElement backButton(WebDriver driver)
	{
		return driver.findElement(By.xpath(backButtonWebElement));
		
	}
	
	public void updateButtonClick(WebDriver driver)
	{
		updateButton(driver).click();
	}
	public void deleteButtonClick(WebDriver driver)
	{
		updateButton(driver).click();
	}
	public void backButtonClick(WebDriver driver)
	{
		updateButton(driver).click();
	}
	
	
	
}
