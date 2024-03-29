package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void takeScreenshot(WebDriver driver, String screenshotName) {
        // Convert WebDriver object to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Capture the screenshot as a file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshot_" + screenshotName + ".png");

        try {
            // Copy the screenshot to the desired location using Files class
            Files.copy(srcFile.toPath(), destFile.toPath());
            System.out.println("Screenshot taken and saved at: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement firstname = driver.findElement(By.id("firstname"));
        System.out.println("Found element: " + firstname);
		// Send first name
        firstname.sendKeys("Ahsan");
		
		/*
		 * Find following input fields and populate with values
		 */
        WebElement lastname = driver.findElement(By.id("lastname"));
        System.out.println("Found element: " + lastname);
        lastname.sendKeys("Habib");
        
        WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
        System.out.println("Found element: " + phoneNumber);
        phoneNumber.sendKeys("0713442156");
        
        WebElement email = driver.findElement(By.id("email"));
        System.out.println("Found element: " + email);
        email.sendKeys("ahsan@gmail.com");
        
        WebElement password = driver.findElement(By.id("password"));
        System.out.println("Found element: " + password);
        password.sendKeys("Ahsan@#$123");
        
        WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
        System.out.println("Found element: " + confirmPassword);
        confirmPassword.sendKeys("Ahsan@#$123");
		
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
        WebElement createAccountButton = driver.findElement(By.id("account-action-btn"));
        createAccountButton.click();
		
		/*
		 * Take screenshot using selenium API.
		 */
        takeScreenshot(driver, "registration_form");
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
