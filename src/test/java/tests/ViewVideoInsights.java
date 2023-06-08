package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

// View Video Insights As a User, after uploading and creating an index for a video, 
//I am able to click on the video to view video playback along with insights extracted.

public class ViewVideoInsights extends TestBase {

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
	public void aloginTest() {
		// Initialize the page object
		Loginpage loginPage = new Loginpage(driver);
		Indexerpage indexerPage = new Indexerpage(driver);

		//Navigate to Login page and enter user credentials 
		loginPage.clicksignIn();
		loginPage.clickgoogleAcc();
		loginPage.enterEmail();
		loginPage.clicksignNext();
		loginPage.enterPassword();
		loginPage.clickpwdNext();
		System.out.println("pass");

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Azure Video Indexer Portal - Cognitive Video Indexing");
		System.out.println(actualTitle);

		loginPage.Uploadbtn();
		System.out.println("uploadpass");
		loginPage.Listview();

		//Click on indexed video
		loginPage.clickonvideo();

		//Verify Insights section with the following details
		indexerPage.peopledetails();
		indexerPage.topicsdeatils();
		indexerPage.keywordsdeatils();
		indexerPage.labeldetails();
		indexerPage.namedetails();
		indexerPage.timeline();
	

	}

	@AfterClass
	public void tearDown() {
		//Close webdriver
		driver.quit();
	}
}
