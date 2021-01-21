
package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LearnTestNG {

	WebDriver driver;

	@BeforeMethod
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		/*
		 * System.setProperty("webdriver.gecko.driver", "driver\\chromedriver.exe");
		 * driver = new FirefoxDriver();
		 */
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void logingTest() {
		// Assert.assertEquals("Login page not found !!", "Login -iBilling",
		// driver.getTitle());

		// storing web element
		// element library
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));

		USERNAME_FIELD_ELEMENT.clear();
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_FIELD_ELEMENT.clear();
		PASSWORD_FIELD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON_ELEMENT.click();

		WebElement DASHBOARD_BUTTON_ELEMENT = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
		/*
		 * String actualDashboardElement = DASHBOARD_BUTTON_ELEMENT.getText();
		 * Assert.assertEquals("Dashboard page not found !!", "Dashboard",
		 * actualDashboardElement);
		 */

	}

	@AfterMethod
	public void tearDown() {

		driver.close();
		driver.quit();
	}
}
