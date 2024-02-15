package generic;

import java.time.Duration;

import org.apache.commons.logging.impl.SLF4JLogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class navigateToApplication {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.croma.com/");
		String titleOfThePage = driver.getTitle();
		System.out.println("The Title Of The Page Is :"+titleOfThePage);
		WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@data-testid,\"Logo\")]/img"))));
		boolean companyLogoDisplaye = driver.findElement(By.xpath("//a[contains(@data-testid,\"Logo\")]/img")).isDisplayed();
		System.out.println("The Company Logo Is Displayed :"+companyLogoDisplaye);
		String userIcon = "//a[contains(@class,'user-link')]";
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(userIcon))));
		explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(userIcon))));
		driver.findElement(By.xpath(userIcon)).click();
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@placeholder,'Enter your Email ID or phone number')]"))));
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@placeholder,'Enter your Email ID or phone number')]")));
		WebElement EmailTextField = driver.findElement(By.xpath("//input[contains(@placeholder,'Enter your Email ID or phone number')]"));
		String email ="cromatestproject@gmail.com";
		EmailTextField.sendKeys(email);
		String fieldValue = EmailTextField.getAttribute("value");
		boolean TextfieldContains = fieldValue.contains(email);
		System.out.println(TextfieldContains);
		driver.quit();
		
	}

}
