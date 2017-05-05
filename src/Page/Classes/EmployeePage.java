package Page.Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeePage {
	
	private static final String greetingsTextWebElement = "[@id='greetings']";
	private static final String logoutButtonWebElement = "html/body/div[1]/header/div/p[1]";
	private static final String createButtonWebElement = "bAdd";
	private static final String editButtonWebElement = "bEdit";
	private static final String deleteButtonWebElement = "bDelete";
	private static final String employeeListWebElement = ".//ul[@id='employee-list']/li";	
	
    public List<WebElement> employeeList(WebDriver driver)
	{
    	List<WebElement> allElements = driver.findElements(By.xpath(employeeListWebElement)); 
    	return allElements;
				
	}
	public WebElement greetingsText(WebDriver driver)
	{
		return driver.findElement(By.xpath(greetingsTextWebElement));
		
	}
	public WebElement logoutButton(WebDriver driver)
	{
		return driver.findElement(By.xpath(logoutButtonWebElement));
		
	}
	public WebElement createButton(WebDriver driver)
	{
		return driver.findElement(By.id(createButtonWebElement));
		
	}
	public WebElement editButton(WebDriver driver)
	{
		return driver.findElement(By.id(editButtonWebElement));
		
	}
	public WebElement deleteButton(WebDriver driver)
	{
		return driver.findElement(By.id(deleteButtonWebElement));
		
	}
	public void logoutButtonClick(WebDriver driver)
	{
		logoutButton(driver).click();
		
	}
	
	public void createButtonClick(WebDriver driver)
	{
		createButton(driver).click();		
	}
	public void editButtonClick(WebDriver driver)
	{
		editButton(driver).click();		
	}
	public void deleteButtonClick(WebDriver driver)
	{
		deleteButton(driver).click();		
	}

}
