package Page.Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private static final String userNameTextBoxWebElement = ".//*[@id='login-form']/fieldset/label[1]/input";	
	private static final String passwordTextBoxWebElement = ".//*[@id='login-form']/fieldset/label[2]/input";	
	private static final String loginButtonWebElement = ".//*[@id='login-form']/fieldset/button";
	private static final String errorText = ".//*[@id='login-form']/fieldset/p[1]";
	
	
	public WebElement usernameTextbox(WebDriver driver) {
		return driver.findElement(By.xpath(userNameTextBoxWebElement));
	}
	
	public WebElement passwordTextbox(WebDriver driver){
		return driver.findElement(By.xpath(passwordTextBoxWebElement));
	}
	
	public WebElement loginButton(WebDriver driver){
		return driver.findElement(By.xpath(loginButtonWebElement));
	}
	
	public void clickLoginButton(WebDriver driver){
		loginButton(driver).click();
	}
	public WebElement errorText(WebDriver driver){
	//	WebDriverWait wait = new WebDriverWait(driver, 10);         
	//	wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath(errorText),"Invalid username or password!"));
		return driver.findElement(By.xpath(errorText));
	}
}
