package springerlinks;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Springerlinks");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://link.springer.com/");
		
		//Search for something that exists
		String searchTerm = "genetics";
		driver.findElement(By.xpath(".//*[@id='query']")).sendKeys(searchTerm);
		driver.findElement(By.xpath(".//*[@id='search']")).click();
			
		boolean exists;
		try {
			WebElement facet = driver.findElement(By.xpath(".//*[@id='content-type-facet']/ol/li[1]/a/span[3]"));
			Assert.assertEquals(true, facet.isDisplayed());
			exists = true;		
		} catch (NoSuchElementException e) {
			exists = false;
		}
		
		if (exists == true)
		{
			System.out.print("Search term ");
			System.out.print(searchTerm);
			System.out.println(" returned results.");
		} else
		{
			System.out.print("Search term ");
			System.out.print(searchTerm);
			System.out.println(" did not return any results.");
		}
		
		
		//Search for something that does not exist
		searchTerm = "vhbjgchvk";
		driver.findElement(By.xpath(".//*[@id='query']")).sendKeys(searchTerm);
		driver.findElement(By.xpath(".//*[@id='search']")).click();
		
		try {
			WebElement facet = driver.findElement(By.xpath(".//*[@id='content-type-facet']/ol/li[1]/a/span[3]"));
			Assert.assertEquals(true, facet.isDisplayed());
			exists = true;		
		} catch (NoSuchElementException e) {
			exists = false;
		}
		
		if (exists == true)
		{
			System.out.print("Search term ");
			System.out.print(searchTerm);
			System.out.println(" returned results.");
		} else
		{
			System.out.print("Search term ");
			System.out.print(searchTerm);
			System.out.println(" did not return any results.");
		}
		

		
				
		
		
		
		

	}

}
