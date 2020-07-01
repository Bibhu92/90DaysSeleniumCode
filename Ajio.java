package Day2;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	     driver.manage().window().maximize();
		driver.get("https://www.ajio.com/shop/sale");
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@name='searchVal']").click();
		driver.findElementByXPath("//input[@name='searchVal']").sendKeys("Bags");
		Thread.sleep(2000);
		driver.findElementByXPath("//ul[@class='rilrtl-list ']/li[3]/a").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='five-grid']").click();
		Thread.sleep(3000);
		Select dropdown= new Select(driver.findElementByXPath("//div[@class='filter-dropdown']/select"));
		dropdown.selectByVisibleText("What's New");
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='facet-typebody']/ul/li[3]/div/div").click();
		driver.findElementByXPath("//input[@name ='minPrice']").sendKeys("2000");
		driver.findElementByXPath("//input[@name='maxPrice']").sendKeys("5000");
		
		driver.findElementByXPath("//input[@name='maxPrice']/following-sibling::button").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//img[@alt='TOMMY HILFIGER Blue Slings & Satchels Sling Bag with Chain Strap']").click();
		
		Set<String> BothHandles= driver.getWindowHandles();
		List<String> handle= new ArrayList<String>(BothHandles);
		driver.switchTo().window(handle.get(1));
		
		String s1= driver.findElementByXPath("//div[@class='prod-price-section ']/div").getText().replaceAll("[^0-9]", "");
		Integer Original_Price= Integer.parseInt(s1);
		System.out.println("The price of bag is "+Original_Price);
		
		String s2= driver.findElementByXPath("//div[@class='promo-discounted-price']//span[1]").getText().replaceAll("[^0-9]", "");
		Integer Discounted_Price= Integer.parseInt(s2);
		System.out.println("Discounted Price is "+Discounted_Price);
		String Coupon_Code= "GRAB";
		driver.findElementByXPath("//span[contains(@class,'edd-pincode-msg-details edd-pincode-msg-details-pointer')]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@class='edd-pincode-modal-text']").sendKeys("560043");
		driver.findElementByXPath("//button[@class='edd-pincode-modal-submit-btn']").click();
		Thread.sleep(2000);
		String Delivery_Date = driver.findElementByClassName("edd-message-success-details-highlighted").getText();
		System.out.println("Estimated delivery date :"+Delivery_Date);
		driver.findElementByXPath("//div[@class='other-info-toggle']").click();
		List<WebElement> Product_Details= driver.findElementsByXPath("//ul[@class='prod-list']/li");
		Integer x = Product_Details.size();
		for(int i=1;i<x; i++)
		{
			String value= driver.findElementByXPath("//ul[@class='prod-list']/li["+i+"]").getText();
			System.out.println(value);
		}
		
		driver.findElementByXPath("//div[@class='btn-gold']").click();
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		WebElement ele= driver.findElementByXPath("//div[@class='btn-cart']");
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		
		Thread.sleep(2000);
		
		String s3 = driver.findElementByXPath("//span[@class='price-value bold-font']").getText().replaceAll("[^0-9]", "");
		Integer Order_Total= (Integer.parseInt(s3)/100);
		System.out.println("Order Total is "+Order_Total);
		driver.findElementById("couponCodeInput").sendKeys(Coupon_Code);
		driver.findElementByXPath("//button[@class='rilrtl-button button apply-button ']").click();
		String s4 = driver.findElementByXPath("//div[@class='net-price best-price-strip']").getText().replaceAll("[^0-9]", "");
		System.out.println(s4.substring(0, s4.length() - 2));
		Integer Final_Price= Integer.parseInt(s4);
		System.out.println(Final_Price);
		if(Discounted_Price==Final_Price)
		{
			System.out.println("Discount price matches with the product price ");
		}
		Thread.sleep(2000);
		driver.findElementByClassName("delete-btn").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[text()='DELETE']").click();
		
		

		
	}

}
