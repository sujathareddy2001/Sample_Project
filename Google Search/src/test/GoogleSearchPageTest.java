package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GoogleSearchPageTest {

	/**
	 * Verify given search word
	 */
	@Test
	public void searchPage() {
		
		final String SearchWord = "ducks";
		final By searchBox = By.id("APjFqb");
		
		//Launch the Chrome browser
		System.setProperty("webdriver.chrome.driver", "/Users/svootl/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		// Go to the URL
		driver.get("https://www.google.com");
		
	   //Search the key word ducks and submit
		WebElement searchBoxElement = driver.findElement(searchBox);
		searchBoxElement.sendKeys(SearchWord);
		searchBoxElement.submit();
		
		// To Verify search results box still shows the keyword
        WebElement searchResults = driver.findElement(By.id("APjFqb"));
        Assert.assertEquals(SearchWord, searchResults.getText(), "Search Results box shows the search word");
        
        //To Verify the search page contains the search word
        
        Assert.assertTrue(driver.getPageSource().contains(SearchWord),"Search Page contains the serach word");
        
        //To Verify the page title contains the search word
        Assert.assertEquals(SearchWord + " - Google Search", driver.getTitle(),"Page Title Contains the search word");
        
        //To Verify the url contains the search word
        Assert.assertTrue(driver.getCurrentUrl().contains(SearchWord),"Search URL contains the search word");
       
        // Close the browser
        driver.quit();
    }
		
		
	}
	


