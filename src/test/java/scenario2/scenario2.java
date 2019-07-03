package scenario2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class scenario2 {
	public class Credentials
	{
		public String username;
		public String password;
	}
	WebDriver driver;
	@Given("^enter the username and password$")
	public void enter_the_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.setProperty("webdriver.chrome.driver","C:\\NexGenTesting\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/loginhere.htm");
		driver.manage().window().maximize();
	}

	@When("^xx$")
	public void xx(List<Credentials> userdata) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    //throw new PendingException();
		for(Credentials credentials:userdata)
		{
			driver.findElement(By.name("userName")).clear();
			driver.findElement(By.name("password")).clear();
			
			driver.findElement(By.name("userName")).sendKeys(credentials.username);
			driver.findElement(By.name("password")).sendKeys(credentials.password);
			driver.findElement(By.name("Login")).click();
			
			driver.navigate().back();
			
			
		}
	}

	@Then("^yy$")
	public void yy() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver.close();
	}

}
