package Page.Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeDetails {
	private static final String firstNameTextBoxWebElement = "html/body/div[1]/div/div/form/fieldset/label[1]/input";
	private static final String lastNameTextBoxWebElement = "html/body/div[1]/div/div/form/fieldset/label[2]/input";
	private static final String startDateTextBoxWebElement = "html/body/div[1]/div/div/form/fieldset/label[3]/input";
	private static final String emailTextBoxWebElement = "html/body/div[1]/div/div/form/fieldset/label[4]/input";
	
	
	public WebElement firstNameTextBox(WebDriver driver)
	{
		return driver.findElement(By.xpath(firstNameTextBoxWebElement));
		
	}
	public WebElement lastNameTextBox(WebDriver driver)
	{
		return driver.findElement(By.xpath(lastNameTextBoxWebElement));
		
	}
	public WebElement startDateTextBox(WebDriver driver)
	{
		return driver.findElement(By.xpath(startDateTextBoxWebElement));
		
	}
	public WebElement emailTextBox(WebDriver driver)
	{
		return driver.findElement(By.xpath(emailTextBoxWebElement));
		
	}
}
