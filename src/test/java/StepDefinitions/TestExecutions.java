package StepDefinitions;





import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecutions {
	public static WebDriver driver;
	@Before
	public void test() {
		System.setProperty("webdriver.chrome.driver", "C:\\Project\\Project\\lib\\chromedriver.exe");
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Given("^User is on homepage$")
	public void user_is_on_homepage() throws Throwable {
		driver.get("http://adactinhotelapp.com/");
	}

	@When("^Enter the id and Pass$")
	public void enter_the_id_and_Pass() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@ name='username'])[1]")).sendKeys("Ssabari99");
    	driver.findElement(By.xpath("//input[@id='password'] ")).sendKeys("asdf1234");
	}

	@When("^I want to login$")
	public void i_want_to_login() throws Throwable {
		driver.findElement(By.xpath("//input[@id='login']")).click();
	}

	@When("^I want to Book the Hotel$")
	public void i_want_to_Book_the_Hotel() throws Throwable {
		
		WebElement loc = driver.findElement(By.xpath("//select[@name='location']"));
    	Select s = new Select(loc);
    	s.selectByValue("Sydney");
    	
    	WebElement hotel = driver.findElement(By.xpath("//select[@name='hotels']"));
    	Select s1 = new Select( hotel);
    	s1.selectByValue("Hotel Creek");
    	
    	WebElement type = driver.findElement(By.xpath("//select[@name='room_type']"));
    	Select s2 = new Select(type);
    	s2.selectByValue("Standard");
    	
    	WebElement noRoom = driver.findElement(By.id("room_nos"));
    	Select s3= new Select(noRoom);
    	s3.selectByVisibleText("1 - One");
    	
		WebElement Adult = driver.findElement(By.id("adult_room"));	
		Select s4 = new Select(Adult);
		s4.selectByVisibleText("1 - One");
		
		
		WebElement child = driver.findElement(By.xpath("//select[@id='child_room']"));	
		Select s5 = new Select(child);
		s5.selectByVisibleText("1 - One");	
		
		driver.findElement(By.xpath("//input[@id='Submit']")).click();	
	}

	@When("^I select the options$")
	public void i_select_the_options() throws Throwable {
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
		}

	@When("^Entering user info$")
	public void entering_user_info() throws Throwable {
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Ether");
    	driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Tent");
    	driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("perumbur,chennai-97");
    	
		}

	@When("^I want to make Payment$")
	public void i_want_to_make_Payment() throws Throwable {
		driver.findElement(By.xpath("//input[@name='cc_num']")).sendKeys("4500248738291823");
		
		driver.findElement(By.xpath("//input[@name='cc_cvv']")).sendKeys("876");
		
		WebElement cardType = driver.findElement(By.xpath("//select[@id='cc_type']"));
		Select s6 = new Select(cardType);
		s6.selectByVisibleText("American Express");

		WebElement expMonth = driver.findElement(By.id("cc_exp_month"));
		Select s7 = new Select(expMonth);
		s7.selectByVisibleText("January");

		WebElement expDate = driver.findElement(By.id("cc_exp_year"));
		Select s8 = new Select(expDate);
		s8.selectByVisibleText("2014");
		}
	
	@When("^I want to book the hotel$")
	public void i_want_to_book_the_hotel() throws Throwable {
	driver.findElement(By.id("book_now")).click();
	}

	@Then("^I verify the Hotel is booked or not$")
	public void i_verify_the_Hotel_is_booked_or_not() throws Throwable {
		TakesScreenshot s= (TakesScreenshot)driver;
		s.getScreenshotAs(OutputType.FILE);
		
		Thread.sleep(5000);
		System.out.println("Hotel Booked");
		driver.findElement(By.xpath("//input[@id='logout']")).click();
		
		
		
}
	@After
	public void test1() {
		driver.quit(); 
	}


}