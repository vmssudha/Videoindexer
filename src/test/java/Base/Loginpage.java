package Base;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import junit.framework.Assert;

public class Loginpage {
	public WebDriver driver;

	public Loginpage(WebDriver driver) {
		this.driver = driver;

	}

	public By azuresign = By.xpath("/html/body/header/div[3]/nav/div/ul[2]/li[1]/a");
	public By emailBox = By.id("identifierId");
	public By signNextButton = By.xpath("//*[@id=\"identifierNext\"]/div/button/span");
	public By passwordTextbox = By.name("Passwd");
	public By PwdNext = By.xpath("//*[@id=\"passwordNext\"]/div/button");
	public By gallerytab = By.xpath("//*[@id=\"galleryUploadtabs\"]");
	public By loginGoogle = By.id("viLoginGoogle");
	public By Upload = By.xpath("//*[@id=\"tabsUploadBtn\"]");
	private FluentWait<WebDriver> wait;

//elements methods
	public void clicksignIn() {
		// TODO Auto-generated method stub
		driver.findElement(azuresign).click();
	}

	public void clickgoogleAcc() {
		driver.findElement(loginGoogle).click();
	}

	public void clicksignNext() {
		// By signNextButton = By.xpath("//*[@id=\"identifierNext\"]/div/button/span");
		driver.findElement(signNextButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void enterEmail() {
		// TODO Auto-generated method stub
		driver.findElement(emailBox).click();
		driver.findElement(emailBox).sendKeys("testgtech714@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void enterPassword() {
		By passwordTextbox = By.name("Passwd");
		// driver.findElement(passwordTextbox).click();
		driver.findElement(passwordTextbox).sendKeys("Test@1234");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void clickpwdNext() {
		driver.findElement(PwdNext).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"galleryUploadtabs\"]")));
	}

	public void Uploadbtn() {

		// driver.manage().window().fullscreen();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Upload));

		try {
			driver.findElement(Upload).isEnabled();
			driver.findElement(Upload).click();
			System.out.println("uploadclick");

		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + Upload);
			e.printStackTrace();
		}

//		Actions actions = new Actions(driver);
//		WebElement upload1 = driver.findElement(By.xpath("//*[@id=\"tabsUploadBtn\"]"));
//		actions.moveToElement(upload1).click().perform();
//      upload1.sendKeys(Keys.ENTER);

		// create jse instance
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("arguments[0].click();", upload1);
//		upload1.click();

//		WebElement upload2 = (WebElement) jse.executeScript("document.querySelector(\"#tabsUploadBtn\")");
//		jse.executeScript("document.querySelector(\"#tabsUploadBtn\")");
//		upload2.click();

	}

	public void Listview() {
		Actions actions = new Actions(driver);
		WebElement layout = driver
				.findElement(By.xpath("//*[@id=\"gallery-view-menu\"]/p-dropdown/div/div[2]/span/i[1]"));
		actions.moveToElement(layout).click().build().perform();

		WebElement list = driver.findElement(By.xpath("//*[@id=\"list-view\"]/i"));
		actions.moveToElement(list).click().build().perform();

		WebElement demovideo = driver
				.findElement(By.xpath("//*[@id=\"gallery-list-item-cb53f5d02c\"]/div/a/span[1]/span"));
		actions.moveToElement(demovideo).click().build().perform();

	}

	public void clickonvideo() {

		WebElement insights = driver.findElement(By.xpath("//*[@id=\"tab0\"]"));
		String insightactualtxt = insights.getText();
		Assert.assertEquals(insightactualtxt, "Insights");
		System.out.println(insightactualtxt);

	}
}
