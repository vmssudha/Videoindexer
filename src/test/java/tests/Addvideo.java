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
import Base.Indexerpage;
import junit.framework.Assert;


//Add A video As a User, I can upload video to the video indexer service to derive relevant video insights.

public class Addvideo extends TestBase {

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
	public void addVideo() {
		// Initialize the page objects
		Loginpage loginPage = new Loginpage(driver);

		//Navigate to Login page and enter user credentials 
		loginPage.clicksignIn();
		loginPage.clickgoogleAcc();
		loginPage.enterEmail();
		loginPage.clicksignNext();
		loginPage.enterPassword();
		loginPage.clickpwdNext();
		System.out.println("pass");

		//verify window title and ensure that the homepage is displayed. 
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Azure Video Indexer Portal - Cognitive Video Indexing");
		System.out.println(actualTitle);

		loginPage.Uploadbtn();
		System.out.println("uploadpass");
	}

	// 1. need more information is required for Add video testcase, Projects tab
	// also has upload button
	// 2.Upload button behaviour is not consistent and seems it overlays with
	// project tab Upload button.
	// 3.it doesn't work with movetoelement method, additional time is needed for
	// further investigation and exploration
	// 4.There are problems with Add video URL functionality feature and it is not
	// currently working as expected

	@AfterClass
	public void tearDown() {
		//Close webdriver
		{
			driver.quit();

		}

	}

}
