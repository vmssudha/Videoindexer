package Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;


public class baseclass {

	@BeforeTest
	public void openurl(){
		
		 WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		   String baseurl = "https://www.demo.guru99.com/v4/";
			driver.get(baseurl);
			driver.manage().window().maximize();
			System.out.println("pass");
	}
	
}


