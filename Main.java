package sit707_week2;

public class Main 
{
    public static void main( String[] args )
    {
        //SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
        //AlternativeWebPageTest.officeworks_registration_page("https://www.linkedin.com/signup");
        
    	// Replace "<YOUR_API_KEY>" with your actual AntiCaptcha API key
        String apiKey = "66fc2c05b472736b72ac9e87b91f245d";

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64/chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open AntiCaptcha website to solve the CAPTCHA
        driver.get("https://anti-captcha.com/client/recaptcha/solve");

        // Enter your AntiCaptcha API key and submit
        WebElement apiKeyInput = driver.findElement(By.id("apiKey"));
        apiKeyInput.sendKeys(apiKey);
        apiKeyInput.submit();

        // Wait for the CAPTCHA to be solved (manually intervene if required)
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Get the CAPTCHA solution from AntiCaptcha website (manually)
        String captchaSolution = "<CAPTCHA_SOLUTION>"; // Enter the actual CAPTCHA solution

        // Close the AntiCaptcha website
        driver.quit();

        // Proceed to the registration page and fill the form
        officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account", captchaSolution);
    }
}
