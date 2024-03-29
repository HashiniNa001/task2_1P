package sit707_week2;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.commons.io.FileUtils;

public class AlternativeWebPageTest {
	
	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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

        // Fill out registration form for Officeworks
        //WebElement firstNameElement = driver.findElement(By.id("firstName"));
        //firstNameElement.sendKeys("Deelaka");

        //WebElement lastNameElement = driver.findElement(By.id("lastName"));
        //lastNameElement.sendKeys("Rathnayake");

        WebElement emailElement = driver.findElement(By.id("email-address"));
        emailElement.sendKeys("deelaka.rathnayake@gmail.com");

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("dsgsdgfdgsdfg");

        // Submit the form
        WebElement createAccountButton = driver.findElement(By.id("join-form-submit"));
        createAccountButton.click();

        // Take screenshot after submission
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("officeworks_registration_page.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sleep for 2 seconds
        sleep(2);

        // Close the browser
        driver.quit();
	}

}
