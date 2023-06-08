package tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Base.Loginpage;
import Base.Searchpage;
import junit.framework.Assert;

//Search Videos with Insights 
//As a User, I can search for videos containing any text, person, 
//insights or object specified within the indexed videos visible to me.

public class SearchViedo extends TestBase {
	public WebDriver driver;

	@BeforeClass
	public void chromesetup() {
		//Webdriver setup
		System.setProperty("webdriver.chrome.driver", "C:\\GTechProjectWorkspace\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://vi.microsoft.com/en-us");
		driver.manage().window().maximize();

	}

	@Test
	public void login() {
		// Initialize the page object
		Loginpage loginPage = new Loginpage(driver);
		Searchpage searchPage = new Searchpage(driver);

		loginPage.clicksignIn();
		loginPage.clickgoogleAcc();
		loginPage.enterEmail();
		loginPage.clicksignNext();
		loginPage.enterPassword();
		loginPage.clickpwdNext();
		System.out.println("pass");
		//Search video
		searchPage.searchaction();
		// Users can toggle between a tiled view and list view
		searchPage.togglelist();
		System.out.println("search pass");

	}

	@AfterClass
	public void tearDown() {
		//Close webdriver
		driver.quit();
	}
}