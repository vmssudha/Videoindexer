package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Indexerpage {

	WebDriver driver;
	private By peoplecomp = By.xpath("//*[@id=\"facesComponent\"]");
	private By topics = By.xpath(("//*[@title='4 topics']"));
	private By keywords = By.xpath(("//*[@title='30 keywords']"));
	private By labels = By.xpath(("//*[@title='20 labels']"));
	// driver.findElement(By.xpath("//tag[contains(@title, 'labels')]")
	private By namedentitles = By.xpath(("//*[@title='9 named entities']"));
	private By timeline = By.xpath("//*[@id=\"tab1\"]");
	private By timescript = By.xpath("//*[@id=\"timelineScript1\"]");

	public Indexerpage(WebDriver driver) {
		this.driver = driver;
	}

	public void peopledetails() {
		String pepoleTxt = driver.findElement(peoplecomp).getText();
		System.out.println(pepoleTxt);
		if (driver.findElement(peoplecomp).isDisplayed()) {
			System.out.println("People section is displayed");

		} else {
			System.out.println("People section is not displayed");
		}
	}

	public void topicsdeatils() {
		String topicTxt = driver.findElement(topics).getText();
		System.out.println(topicTxt);
		if (driver.findElement(topics).isDisplayed()) {
			System.out.println("topics section is displayed");
			Assert.assertEquals(topicTxt, "4 topics");
		} else {
			System.out.println("topics section is not displayed");
		}
	}

	public void keywordsdeatils() {

		String keywordTxt = driver.findElement(keywords).getText();
		System.out.println(keywordTxt);

		if (driver.findElement(keywords).isDisplayed()) {
			System.out.println("topics section is displayed");
			Assert.assertEquals(keywordTxt, "30 keywords");
		} else {
			System.out.println("topics section is not displayed");
		}

	}

	public void labeldetails() {
		String labelTxt = driver.findElement(labels).getText();
		System.out.println(labelTxt);
		if (driver.findElement(labels).isDisplayed()) {
			System.out.println("topics section is displayed");
			Assert.assertEquals(labelTxt, "20 labels");
		} else {
			System.out.println("topics section is not displayed");
		}
	}

	public void namedetails() {
		String nameTxt = driver.findElement(namedentitles).getText();
		System.out.println(nameTxt);
		if (driver.findElement(namedentitles).isDisplayed()) {
			System.out.println("topics section is displayed");
			Assert.assertEquals(nameTxt, "9 named entities");
		} else {
			System.out.println("topics section is not displayed");
		}
	}

	public void timeline() {
		driver.findElement(timeline).click();
		String timescripttxt = driver.findElement(timescript).getText();
		System.out.println(timescripttxt);

	}
}
