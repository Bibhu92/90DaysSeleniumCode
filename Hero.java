package Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hero {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get("https://www.honda2wheelersindia.com/");
		Wait wait= new WebDriverWait(driver, 10);
		WebElement ele= driver.findElementByXPath("//button[@class='close']");
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		Thread.sleep(2000);
		driver.findElementById("link_Scooter").click();
		driver.findElementByXPath("(//div[ @id='menu_Scooter']/div/div)[1]/div[1]/div[1]//a/img").click();
		Thread.sleep(2000);
        driver.findElementByLinkText("Specifications").click();
        Thread.sleep(2000);
        Actions action= new Actions(driver);
        action.moveToElement(driver.findElementByXPath("//ul[@class='specifications']/li[2]")).build().perform();
        String val= driver.findElementByXPath("//div[@class='engine part-2 axx']/ul/li[3]/span[2]").getText().replaceAll("[^\\d.]", "");
        
        Float Dio_displacement= Float.parseFloat(val);
        System.out.println(Dio_displacement);
        Thread.sleep(2000);
        driver.findElementById("link_Scooter").click();
        driver.findElementByXPath("(//div[@class='owl-wrapper-outer'])[2]/div/div[3]/div/a/img").click();
        driver.findElementByLinkText("Specifications").click();
        Thread.sleep(2000);
        action.moveToElement(driver.findElementByXPath("//ul[@class='specifications']/li[4]")).build().perform();
        String val2= driver.findElementByXPath("//div[@class='engine part-4 axx']/ul/li[3]/span[2]").getText().replaceAll("[^\\d.]", "");
        Float Activa_displacement= Float.parseFloat(val2);
        System.out.println(Activa_displacement);
        
        if(Dio_displacement>Activa_displacement)
        {
        	System.out.println("Dio has better displacement");
        }
        else
        {
        	System.out.println("Activa has better displacement");
        }
        
        
        Thread.sleep(2000);
        driver.findElementByLinkText("FAQ").click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElementByLinkText("Activa 125 BS-VI")));
        driver.findElementByLinkText("Activa 125 BS-VI").click();
        WebElement ele4= driver.findElementByXPath("//ul[@class='nav nav-pills tabb-design  ']/li[6]");
        wait.until(ExpectedConditions.visibilityOf(ele4));
        ele4.click();
        WebElement ele5= driver.findElementByXPath("//button[text()='Submit' and @id='submit6']");
        wait.until(ExpectedConditions.visibilityOf(ele5));
        ele5.click();
        driver.findElementByLinkText("Click here to know the price of Activa 125 BS-VI.").click();
        Set<String> BothHandles= driver.getWindowHandles();
        List<String> handle= new ArrayList<String>(BothHandles);
        driver.switchTo().window(handle.get(1));
        
        Select sel= new Select(driver.findElementById("StateID"));
        sel.selectByVisibleText("Tamil Nadu");
        Select sel1= new Select(driver.findElementById("CityID"));
        sel.selectByVisibleText("Chennai");
        
        for(int i=1; i<=3; i++)
        {
        String val5 =driver.findElementByXPath("//tbody[@style='background-color:white']/tr["+i+"]/td[2]").getText();
        System.out.println(val5);
        
        
        }
	}

}
