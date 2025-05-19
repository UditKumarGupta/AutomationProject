/*package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import util.ReportUtils;
import util.utility;

public class Flurn_HomepageLogin {
	WebDriver driver;
	String reportFilename;
	ReportUtils reportUtils;

	@BeforeTest
	public void BeforeTest() {
		reportFilename = "Reports/testReport.html";
		reportUtils = new ReportUtils(reportFilename);

		driver = utility.getBrowser("chrome"); // Opening Chrome browser.
		driver.manage().window().maximize(); // Maximizing window.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void Login() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		reportUtils.createATestCase("Verify user Login");
		driver.get("https://www.phptravels.net"); // Opening the flurn URL in the browser.

		Assert.assertEquals("PHPTRAVELS", driver.getTitle()); // Verify title of the webpage.

		reportUtils.addTestLog(Status.INFO, "Performing userLogin");
		driver.findElement(By.xpath("//span[contains(text(),'Customer')]")).click();
		driver.findElement(By.linkText("Login")).click();
		reportUtils.addTestLog(Status.INFO, "Performing userLogin");
		driver.findElement(By.name("email")).sendKeys("user@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demouser");
		driver.findElement(By.id("submitBTN")).click();
		Assert.assertEquals("Dashboard", driver.getTitle());
		reportUtils.addTestLog(Status.INFO, "Login Successfull");
	}

	@Test
	public void search() throws InterruptedException {
		reportUtils.createATestCase("Search a hotel");
		driver.findElement(By.xpath("//a[@href=\"https://www.phptravels.net/\"]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Hotels')]")).click();
		driver.findElement(By.id("select2-hotels_city-container")).click();
		
		reportUtils.addTestLog(Status.INFO, "Performing Hotel search");

		WebElement searchBox = driver.findElement(By.xpath("//span[1]/input"));
		Actions act = new Actions(driver);
		act.sendKeys(searchBox, "D").pause(1000);
		act.sendKeys(searchBox, "U").pause(1000);
		act.sendKeys(searchBox, "B").pause(1000);
		act.sendKeys(searchBox, "A").pause(1000);

		act.moveToElement(searchBox).build().perform();
		driver.findElement(By.xpath("//li[contains(text(),'Dubai')]")).click();
	
		/* Calendar event*/
	/*	driver.findElement(By.id("checkout")).click();
	 	WebDriverWait wait = new WebDriverWait(driver,5);
	 	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[5]/div[1]/table/thead/tr[1]/th[2]"))));
	 	 
	 	String MonthYear=driver.findElement(By.xpath("/html/body/div[5]/div[1]/table/thead/tr[1]/th[2]")).getText();
	 	System.out.println("Date is "+MonthYear);*/
		
		
		/*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@type=\"submit\"][1]")).click();
		reportUtils.addTestLog(Status.INFO, "Hotel search Successfull");*/

	}

	/*@AfterTest
	public void closeBrowser() {

		driver.quit(); // Close the browser.
		reportUtils.flushReport();

	}*/
}*/

package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import util.ReportUtils;
import util.utility;

public class Flurn_HomepageLogin {
    WebDriver driver;
    String reportFilename;
    ReportUtils reportUtils;

    @BeforeTest
    public void BeforeTest() {
        reportFilename = "Reports/testReport.html";
        reportUtils = new ReportUtils(reportFilename);

        try {
            driver = utility.getBrowser("chrome"); // Opening Chrome browser.
            driver.manage().window().maximize(); // Maximizing window.
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();  // Log the exception if there is an issue with browser setup.
        }
    }

    @Test
    public void Login() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        reportUtils.createATestCase("Verify user Login");
        driver.get("https://www.phptravels.net"); // Opening the flurn URL in the browser.

        // Assert to verify page title
        Assert.assertEquals("PHPTRAVELS", driver.getTitle());

        reportUtils.addTestLog(Status.INFO, "Performing userLogin");

        // Navigate to Login page and fill credentials
        driver.findElement(By.xpath("//span[contains(text(),'Customer')]")).click();
        driver.findElement(By.linkText("Login")).click();
        
        driver.findElement(By.name("email")).sendKeys("user@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("demouser");
        driver.findElement(By.id("submitBTN")).click();

        // Assert to verify successful login by title
        Assert.assertEquals("Dashboard", driver.getTitle());
        
        reportUtils.addTestLog(Status.INFO, "Login Successful");
    }

    @Test
    public void search() {
        reportUtils.createATestCase("Search a hotel");
        driver.findElement(By.xpath("//a[@href=\"https://www.phptravels.net/\"]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Hotels')]")).click();
        driver.findElement(By.id("select2-hotels_city-container")).click();
        
        reportUtils.addTestLog(Status.INFO, "Performing Hotel search");

        WebElement searchBox = driver.findElement(By.xpath("//span[1]/input"));
        Actions act = new Actions(driver);
        
        // Performing search using Actions with pauses to simulate typing
        act.sendKeys(searchBox, "D").pause(1000)
           .sendKeys(searchBox, "U").pause(1000)
           .sendKeys(searchBox, "B").pause(1000)
           .sendKeys(searchBox, "A").pause(1000)
           .moveToElement(searchBox).build().perform();
        
        driver.findElement(By.xpath("//li[contains(text(),'Dubai')]")).click();
        
        // Handling the calendar event (wait for it to appear)
        driver.findElement(By.id("checkout")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[5]/div[1]/table/thead/tr[1]/th[2]"))));

        // Extract and print the selected date/month/year
        String MonthYear = driver.findElement(By.xpath("/html/body/div[5]/div[1]/table/thead/tr[1]/th[2]")).getText();
        System.out.println("Date is " + MonthYear);

        reportUtils.addTestLog(Status.INFO, "Hotel search Successful");
    }

    @AfterTest
    public void closeBrowser() {
        // Ensure the driver quits after tests
        if (driver != null) {
            driver.quit(); // Close the browser.
        }
        
        reportUtils.flushReport();  // Flush the report after tests
    }
}

