package generic;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.logging.impl.SLF4JLogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class navigateToApplication {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		String cromaUrl = "https://www.croma.com/";
		driver.get(cromaUrl);
		String titleOfThePage = driver.getTitle();
		System.out.println("The Title Of The Page Is :"+titleOfThePage);
		WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(30));
		String cromaLogo = "//a[contains(@data-testid,'Logo')]/img";
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(cromaLogo))));
		boolean companyLogoDisplaye = driver.findElement(By.xpath(cromaLogo)).isDisplayed();
		System.out.println("The Company Logo Is Displayed :"+companyLogoDisplaye);
		String menu = "//span[contains(text(),'Menu')]";
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(menu))));
		explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(menu))));
		driver.findElement(By.xpath(menu)).click();
		String mainCategory = "//p[contains(text(),'Shop by Category')]";
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(mainCategory))));
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(mainCategory)));
		boolean ShopByCateoryText = driver.findElement(By.xpath(mainCategory)).isDisplayed();
		String ShopByCateoryTextafter = driver.findElement(By.xpath(mainCategory)).getText();
		System.out.println(ShopByCateoryTextafter);
		String subCategory = "//h4[contains(text(),'Televisions & Accessories')]";
		String plpTitle = "//h1[contains(text(),'Televisions & Accessories')]";
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(subCategory)))).click();
		boolean TelevisionsIsdisplayed = explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(plpTitle)))).isDisplayed();
		System.out.println(TelevisionsIsdisplayed);
		String firstProductTitileXpath = "//div[contains(@class,'product-info')]/div/div/h3[@class='product-title plp-prod-title']";
		String firstProductDiscountedPriceXpath = "//div[contains(@class,'product-info')]/following-sibling::div/div/div/span";
		String firstProductOldPriceXpath = "//div[contains(@class,'product-info')]/following-sibling::div/div/following-sibling::div/span/span";
		String firstProductDiscountValueXpath = "//div[contains(@class,'product-info')]/following-sibling::div/div/following-sibling::div/span[2]";	
		String firstProductDiscountPercentageXpath = "//div[contains(@class,'product-info')]/following-sibling::div/div/following-sibling::div/span[3]";	
		String deliveryTypeXpath = "//div[contains(@class,'product-info')]/following-sibling::div/div/div[@class='delivery-icon']/span[2]/span";		
		String firstProductLinkXpath = "//div[contains(@data-testid,'product-id')]";
		
		String firstProductTitile =driver.findElement(By.xpath(firstProductTitileXpath)).getText();
		String firstProductDiscountedPrice = driver.findElement(By.xpath(firstProductDiscountedPriceXpath)).getText();
		String firstProductOldPrice = driver.findElement(By.xpath(firstProductOldPriceXpath)).getText();
		String firstProductDiscountValue = driver.findElement(By.xpath(firstProductDiscountValueXpath)).getText();	
		String firstProductDiscountPercentage = driver.findElement(By.xpath(firstProductDiscountPercentageXpath)).getText();		
		String deliveryType = driver.findElement(By.xpath(deliveryTypeXpath)).getText();		
		driver.findElement(By.xpath(firstProductLinkXpath)).click();
		System.out.println(firstProductTitile);
		System.out.println(firstProductDiscountedPrice);
		System.out.println(firstProductOldPrice);
		System.out.println(firstProductDiscountValue);
		System.out.println(firstProductDiscountPercentage);
		System.out.println(deliveryType);
		String onlyAmount = fetchNumberFromString.numbers(firstProductDiscountedPrice);
		System.out.println(onlyAmount);
		String OriginalWindow = driver.getWindowHandle();
		System.out.println(OriginalWindow);
		Set<String> AllWindowID = driver.getWindowHandles();
		for (String windlowHandle:AllWindowID) {
			if(!windlowHandle.equals(OriginalWindow)) {
				driver.switchTo().window(windlowHandle);
			}
		}		
		String ChildWindowId = driver.getWindowHandle();
		System.out.println(ChildWindowId);
		String pdpPageURL = driver.getCurrentUrl();
		System.out.println(pdpPageURL);
		String pdpPagetitle = driver.getTitle();
		System.out.println(pdpPagetitle);
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class=\"pdpBreadcrumbdiv\"]/div/div/ul/li/a)[1]"))));
		String bredcrumbCategory = "(//div[@class='pdpBreadcrumbdiv']/div/div/ul/li/a)[1]";
		String bredcrumbSubMainCategory = "(//div[@class='pdpBreadcrumbdiv']/div/div/ul/li/a)[2]";
		String bredcrumbSubCategory = "(//div[@class='pdpBreadcrumbdiv']/div/div/ul/li/a)[3]";
		String breadcrumbCategoryName = driver.findElement(By.xpath(bredcrumbCategory)).getText();
		String breadcrumbSubMainCategoryName = driver.findElement(By.xpath(bredcrumbSubMainCategory)).getText();
		String breadcrumbSubCategoryName = driver.findElement(By.xpath(bredcrumbSubCategory)).getText();
		boolean bredcrumbNameContains = breadcrumbSubCategoryName.contains(firstProductTitile);
		boolean bredcrumbsubMainNameContains = breadcrumbSubMainCategoryName.contains(firstProductTitile);
		boolean bredcrumbSubNameContains = breadcrumbCategoryName.contains(firstProductTitile);
		System.out.println(bredcrumbNameContains);
		System.out.println(bredcrumbsubMainNameContains);
		System.out.println(bredcrumbSubNameContains);
		String pdptitle = driver.findElement(By.xpath("//h1[@class='pd-title pd-title-normal']")).getText();
		boolean productNamecontains = pdptitle.contains(firstProductTitile);
		System.out.println("ProductNameContains :"+productNamecontains);
		String ProductPriceInPDP = driver.findElement(By.xpath("//div[@class='new-price']/span[@data-testid='new-price' and @class='amount']")).getText();
		String OnlyProductAmountInPDP = fetchNumberFromString.numbers(ProductPriceInPDP);
		boolean Amountconatins = OnlyProductAmountInPDP.contains(onlyAmount);
		System.out.println(Amountconatins);
		WebElement keyFeatureElement =driver.findElement(By.xpath("//h2[text()='Key Features']")) ;
		//keyFeatureElement.sendKeys(Keys.PAGE_DOWN);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", keyFeatureElement);
		explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='btn btn-secondary pdp-add-to-cart']"))));
		driver.findElement(By.xpath("//button[@class='btn btn-secondary pdp-add-to-cart']")).click();
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='mini-cart-status-container']"))));
		driver.findElement(By.xpath("//button[@class='btn btn-default proceed-tocart']")).click();
		explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='your-cart']")))).isDisplayed();
		//my name is nagendra
		//Iam in Bangloare 
		driver.quit();
		
	}

}
