package projectCucumber.stepdefination;


import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class composesteps extends Baseclass {
	WebDriver driver;
     Properties configProp;
	
	@Before
	public void setup() throws IOException{
		
		configProp=new Properties();
		FileInputStream configPropfile=new FileInputStream("./properties/config.properties");
		configProp.load(configPropfile);
		
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        
		}

	
	
	@Given("I am on the Gmail inbox page")
	public void i_am_on_the_gmail_inbox_page() {
		
		
		driver.get("https://mail.google.com/");
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(configProp.getProperty("id"));
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys(configProp.getProperty("password"));
		driver.findElement(By.xpath("//span[normalize-space()='Next']]")).click();
	  assertTrue(driver.findElement(By.xpath("//*[@class='gb_Mc']")).isDisplayed());
	}

	@When("I click on the {string} button")
	public void i_click_on_the_button(String string) {
	    driver.findElement(By.xpath("//*[@class='T-I T-I-KE L3']")).click();
	   
	}

	@Then("a new email composition window should be opened")
	public void a_new_email_composition_window_should_be_opened() {
	    assertTrue(driver.findElement(By.xpath("//span[normalize-space()='New Message']")).isDisplayed());
	}

	@Given("I am composing a new email")
	public void i_am_composing_a_new_email() {
		assertTrue(driver.findElement(By.xpath("//span[normalize-space()='New Message']")).isDisplayed());
	}

	@When("I enter a valid email address in the recipient field")
	public void i_enter_a_valid_email_address_in_the_recipient_field(String string) {
		WebElement recipientField = driver.findElement(By.name("to"));
        recipientField.sendKeys(configProp.getProperty("email"));
	}

	@Then("the email address should be accepted and displayed properly")
	public void the_email_address_should_be_accepted_and_displayed_properly() {
		 assertTrue(driver.findElement(By.xpath("//span[text()='" + configProp.getProperty("email") + "']")).isDisplayed());

	}
	
	@When("I enter a subject in the subject field")
	public void i_enter_a_subject_in_the_subject_field(String string) {
		  driver.findElement(By.name("subjectbox")).sendKeys(configProp.getProperty("subject"));
	        
	}

	@Then("the subject should be entered and displayed properly")
	public void the_subject_should_be_entered_and_displayed_properly() {
		assertTrue(driver.findElement(By.xpath("//input[@name='subjectbox' and @value='" + configProp.getProperty("subject") + "']"))
                .getAttribute("value").equals(configProp.getProperty("subject")));
	}

	@When("I enter a message in the message body field")
	public void i_enter_a_message_in_the_message_body_field(String string) {
		 driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys(configProp.getProperty("message"));
	        
	}

	@Then("the message should be entered and displayed properly")
	public void the_message_should_be_entered_and_displayed_properly() {
		assertTrue(driver.findElement(By.xpath("//div[contains(text(),'" + configProp.getProperty("message") + "')]")).isDisplayed());
	}

	@When("I attach a file to the email")
	public void i_attach_a_file_to_the_email() {
		  WebElement attachFileButton = driver.findElement(By.xpath("//div[@command='Files']"));
	        attachFileButton.click();
	        
	        WebElement fileInput = driver.findElement(By.id("fileInput"));
	        fileInput.sendKeys("/projectCucumber/TestData/8k-pc-wallpaper.jpg" + configProp.getProperty("fileName"));
	}

	@Then("the file should be successfully attached")
	public void the_file_should_be_successfully_attached() {
		 assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" + configProp.getProperty("fileName") + "')]")).isDisplayed());
	}

	@When("I enter recipient, subject, and message body")
	public void i_enter_recipient_subject_and_message_body() {
		i_enter_a_valid_email_address_in_the_recipient_field("recipient@example.com");
		i_enter_a_subject_in_the_subject_field("Test Subject");
		i_enter_a_message_in_the_message_body_field("Test Message Body");
	}

	@Then("the email should be sent successfully and appear in the sent items folder")
	public void the_email_should_be_sent_successfully_and_appear_in_the_sent_items_folder() {
		WebElement sendButton = driver.findElement(By.xpath("//div[text()='Send']"));
        sendButton.click();
        
        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Message sent.')]")).isDisplayed());
       
        driver.quit();
	}

	

}
