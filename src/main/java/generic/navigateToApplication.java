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
		String menu = "//span[contains(text(),'Menu')]";
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(menu))));
		explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(menu))));
		driver.findElement(By.xpath(menu)).click();
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[contains(text(),'Shop by Category')]"))));
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Shop by Category')]")));
		boolean ShopByCateoryText = driver.findElement(By.xpath("//p[contains(text(),'Shop by Category')]")).isDisplayed();
		String ShopByCateoryTextafter = driver.findElement(By.xpath("//p[contains(text(),'Shop by Category')]")).getText();
		System.out.println(ShopByCateoryTextafter);
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[contains(text(),'Televisions & Accessories')]")))).click();
		boolean TelevisionsIsdisplayed = explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Televisions & Accessories')]")))).isDisplayed();
		System.out.println(TelevisionsIsdisplayed);
		driver.quit();
		
		//h1[contains(text(),'Televisions & Accessories')]
		
	}

}
