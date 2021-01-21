
  package variousConcepts;
  
  import java.util.Set; import java.util.concurrent.TimeUnit;
  
  import org.junit.Test; import org.openqa.selenium.By; import
  org.openqa.selenium.WebDriver; import
  org.openqa.selenium.chrome.ChromeDriver;
  
  public class LearnWindowHandle {
  
  WebDriver driver;
  
  @Test public void launchBrowser() {
  
  System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
  
  driver = new ChromeDriver(); driver.get("https://www.yahoo.com/");
  driver.manage().window().maximize(); driver.manage().deleteAllCookies();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  
  driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("xpath");
  driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
  
  String handle1 = driver.getWindowHandle();
  driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
  
  Set<String> handles = driver.getWindowHandles(); System.out.println(handles);
  
  for (String i : handles) { driver.switchTo().window(i); }
  
  System.out.println(driver.getTitle());
  
  // Switching the driver back to Yahoo driver.switchTo().window(handle1);
  System.out.println(driver.getTitle());
  
  }
  
  }
 