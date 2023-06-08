package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import java.util.List;

public class Searchpage {

	public WebDriver driver;

	public Searchpage(WebDriver driver) {
		this.driver = driver;
	}

	public By searchinput = By.xpath("//*[@id=\"viFilterSearchInput\"]");
	public By searchtext = By.xpath("//span[contains(@class, 'highlight') and contains(text(), 'how')]");

	public void searchaction() {
		driver.findElement(searchinput).clear();
		driver.findElement(searchinput).click();
		driver.findElement(searchinput).sendKeys("how");
		driver.findElement(searchinput).sendKeys(Keys.ENTER);

		List<WebElement> elements = driver
				.findElements(By.xpath("//span[contains(@class, 'highlight') and contains(text(), 'how')]"));

		System.out.println("Element count: " + elements.size());
	}

	public void togglelist() {

		Actions actions = new Actions(driver);
		WebElement layout = driver
				.findElement(By.xpath("//*[@id=\"gallery-view-menu\"]/p-dropdown/div/div[2]/span/i[1]"));
		actions.moveToElement(layout).click().build().perform();

		WebElement list = driver.findElement(By.xpath("//*[@id=\"list-view\"]/i"));
		actions.moveToElement(list).click().build().perform();
	}
}
