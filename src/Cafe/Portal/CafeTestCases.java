package Cafe.Portal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Page.Classes.CreateEmployeePage;
import Page.Classes.EmployeePage;
import Page.Classes.LoginPage;

public class CafeTestCases {

	private WebDriver driver;
	private LoginPage loginPage;
	private EmployeePage employeePage;
	private CreateEmployeePage createEmployee;

	@Before
	public void setUp() throws Exception {

		// base URL of application
		String baseUrl = "https://cafetownsend-angular-rails.herokuapp.com/login";

		driver = new FirefoxDriver();
		driver.get(baseUrl);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// login page object
		loginPage = new LoginPage();
		employeePage = new EmployeePage();
		createEmployee = new CreateEmployeePage();
	}

	@Test
	public void ValidLogin() throws Exception {
		loginPage.usernameTextbox(driver).sendKeys("Luke");
		loginPage.passwordTextbox(driver).sendKeys("Skywalker");
		loginPage.clickLoginButton(driver);
		String logoutText = employeePage.logoutButton(driver).getText();
		Assert.assertEquals("Logout", logoutText);
	}

	@Test
	public void InvalidLoginWithWrongPassword() throws Exception {
		loginPage.usernameTextbox(driver).sendKeys("Luke");
		loginPage.passwordTextbox(driver).sendKeys("Skywalker1");
		loginPage.clickLoginButton(driver);
		// loginPage.errorText(driver).click();
		Thread.sleep(10000);
		String errorText = loginPage.errorText(driver).getText();
		Assert.assertEquals("Invalid username or password!", errorText);
	}

	@Test
	public void InvalidLoginWithWrongUsername() throws Exception {
		loginPage.usernameTextbox(driver).sendKeys("Luke1");
		loginPage.passwordTextbox(driver).sendKeys("Skywalker");
		loginPage.clickLoginButton(driver);
		Thread.sleep(10000);
		String errorText = loginPage.errorText(driver).getText();
		Assert.assertEquals("Invalid username or password!", errorText);
	}

	@Test
	public void Logout() throws Exception {
		loginPage.usernameTextbox(driver).sendKeys("Luke");
		loginPage.passwordTextbox(driver).sendKeys("Skywalker");
		loginPage.clickLoginButton(driver);
		employeePage.logoutButtonClick(driver);
		String loginText = loginPage.loginButton(driver).getText();
		Assert.assertEquals("Login", loginText);
	}

	@Test
	public void CreateEmployee() throws Exception {
		ValidLogin();
		employeePage.createButtonClick(driver);
		createEmployee.firstNameTextBox(driver).sendKeys("Rome");
		createEmployee.lastNameTextBox(driver).sendKeys("Juli");
		createEmployee.startDateTextBox(driver).sendKeys("2014-11-13");
		createEmployee.emailTextBox(driver).sendKeys("tim@tim.com");
		createEmployee.addButtonClick(driver);
		List<WebElement> employeeList = employeePage.employeeList(driver);
		boolean flag = false;
		for (WebElement webElement : employeeList) {
			if (webElement.getText().contains("Rome Juli")) {				
				flag=true;
				break;
			}
		}
		Assert.assertTrue(flag);
	}

	@Test
	public void EditCancelEmployeeButtonEnabled() throws Exception {
		ValidLogin();
		List<WebElement> employeeList = employeePage.employeeList(driver);
		employeeList.get(3).click();
		Assert.assertTrue(employeePage.editButton(driver).isEnabled());
		Assert.assertTrue(employeePage.deleteButton(driver).isEnabled());

	}

	@Test
	public void checkdeleteAlert() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().startsWith("Are you sure"));
	}

	@Test
	public void VerifyDeleteEmployee() throws Exception {

		ValidLogin();
		List<WebElement> employeeList;
		employeeList = employeePage.employeeList(driver);
		employeeList.get(3).click();
		Assert.assertTrue(employeePage.editButton(driver).isEnabled());
		Assert.assertTrue(employeePage.deleteButton(driver).isEnabled());

		int no = employeeList.size();

		System.out.println(no);
		employeePage.deleteButtonClick(driver);

		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();

		driver.navigate().refresh();
		Thread.sleep(10000);
		ValidLogin();

		employeeList = employeePage.employeeList(driver);
		int no1 = employeeList.size();
		Assert.assertEquals(1, no1-no);
	}

	@After
	public void tearDown() throws Exception {

		driver.close();
	}
}
