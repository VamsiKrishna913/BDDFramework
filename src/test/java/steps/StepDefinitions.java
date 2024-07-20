package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {

	WebDriver driver;
	
	@After
	public void teardown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	@Given("user starts {string} the browser")
	public void user_starts_the_browser(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firfox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
	  
	}

	@Given("user launch the app using the url {string}")
	public void user_launch_the_app_using_the_url(String url) {
	    driver.get(url);
	    driver.manage().window().maximize();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@When("user enters the text {string} in the text using xpath {string}")
	public void user_enters_the_text_in_the_text_using_xpath(String text, String xpath) {
	   driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@When("user clicks the login button using xpath {string}")
	public void user_clicks_the_login_button_using_xpath(String xpath) {
	   driver.findElement(By.xpath(xpath)).click();
	}

	@Then("user verify the title of the page to be {string}")
	public void user_verify_the_title_of_the_page_to_be(String expTitle) {
	    Assert.assertEquals(expTitle,driver.getTitle());
	}

	@Then("user verify the presence of text using xpath {string}")
	public void user_verify_the_presence_of_text_using_xpath(String xpath, DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<Map<String,String>> listOfMaps=dataTable.asMaps();
		
		String actualText=driver.findElement(By.xpath(xpath)).getText();
        System.out.println(actualText);
        
        System.out.println(listOfMaps.get(0).get("error message"));
        
        Assert.assertEquals(listOfMaps.get(0).get("error message"), actualText);
	}
}
