package steps;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import common.GoogleBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleHomePage;

public class Ocean9GoogleSearch extends GoogleBase{
	
	
	
	GoogleHomePage ghp;

		@Given("I am on the google homepage")
		public void i_an_on_the_google_homepage() {
			
			launchBrowser();
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://www.google.com");
			driver.manage().window().maximize();
					    
		}

		@When("I enter search {string}")
		public void i_enter_search(String term) {
			
			
			ghp = new GoogleHomePage(driver);
			ghp.enterSearchTerm(term);
			
			//WebElement searchBox = driver.findElement(By.name("q"));
			//searchBox.sendKeys(term);
		    
		}

		@When("I click on google search button")
		public void i_click_on_google_search_button() {
			
			//WebElement searchButton = driver.findElement(By.name("btnK"));
			//searchButton.click();
			
			ghp.clickSearchButton();
		    
		}

		@Then("I receive related search result")
		public void i_receive_related_search_result() {
		    
			WebElement results = driver.findElement(By.id("result-stats"));
			String searchCount=results.getText();
			
			System.out.println("=======================================");
			System.out.println(searchCount);
			System.out.println("===================================");
			driver.close();
		}


	

}
