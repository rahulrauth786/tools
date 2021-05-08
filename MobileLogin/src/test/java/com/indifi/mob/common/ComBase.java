package com.indifi.mob.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.indifi.mob.init.Lib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import ru.yandex.qatools.allure.annotations.Step;

public class ComBase {

	//public static WebDriver driver = Lib.driver;
	public static  AndroidDriver<AndroidElement> driver = Lib.openApp();
	
	public static void  waitForElement(String loc) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 300);

		String [] A=loc.split("#",2);
		String locType=A[0];
		String locAddress=A[1];
		if (locType.equalsIgnoreCase("id"))
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locAddress)));
		}

		if (locType.equalsIgnoreCase("xpath"))
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locAddress)));
		}
		Thread.sleep(1000);
	}
	
	
	
	@Step("Find element by Idenfication {0}")
	public static WebElement getElementByIdentification(String loc)
	{

//		String [] A=loc.split("#",2);
//		String locType=A[0];
		WebElement mobileElement=null;
		mobileElement = driver.findElementById(loc);
		System.out.println(loc);
		
//		String locAddress=A[1];
//
//		System.out.println(A[0]+":"+A[1]);

//		if (locType.equalsIgnoreCase("id"))	 
//		{
//			mobileElement=driver.findElement(By.id(locAddress)); 
//		}
//		else if (locType.equalsIgnoreCase("class"))
//
//		{
//			mobileElement=driver.findElement(By.className(locAddress));
//		}
//
//		else if (locType.equalsIgnoreCase("name"))
//		{
//			mobileElement=driver.findElement(By.name(locAddress));
//		}
//		else if (locType.equalsIgnoreCase("xpath"))
//
//		{
//			mobileElement=driver.findElement(By.xpath(locAddress));
//		}
//
//		else if (locType.equalsIgnoreCase("css"))
//
//		{
//			mobileElement=driver.findElement(By.cssSelector(locAddress));
//		}

		return mobileElement;	
	}


	
	@Step("Input the {1} in the {0}")
	public static void input (String loc, String input) throws InterruptedException
	{
		//waitForElement(loc);
		WebElement element=getElementByIdentification(loc);
		//new TouchAction(driver).moveTo(element).release().perform();
		
		if (!element.getText().trim().equalsIgnoreCase(""))
		{
			element.clear();
			Thread.sleep(100);
		}
		element.sendKeys(input);
       // driver.navigate().back();
	}
	
	@Step("click on {0}")
	public static void  click (String loc) throws InterruptedException
	{
		//waitForElement(loc);
		WebElement element=getElementByIdentification(loc);
		
		
        	element.click();
        
		
	}	
	
	/*@Step("select from dropdown")
	public static void select (String loc, String value) throws InterruptedException
	{
		
		Select dropdown = new Select(driver.findElement(By.id(loc)));
		dropdown.selectByVisibleText(value);
	}*/
	
	
	@Step("select from dropdown")
	public static void select (String loc, String value) throws InterruptedException
	{
		WebElement element=getElementByIdentification(loc);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(value);
	}
	
	
	@Step("select from dropdown")
	public static void selectDocumentName (String loc, String value) throws InterruptedException
	{
		
		Select dropdown = new Select(driver.findElement(By.xpath(loc)));
		dropdown.selectByVisibleText(value);
	}
	
	@Step("Upload file")
	public static void uploadFile(String loc, String Path) throws InterruptedException{
		WebElement element=getElementByIdentification(loc);
		element.sendKeys(Path);


	}
	
	@Step("Upload Documents")
	public static void uploadDocuments(String loc, String Path) throws InterruptedException{
		WebElement element= driver.findElement(By.id(loc));
		System.out.println(Path);
		element.sendKeys(Path);


	}
	@Step("Press Escape Key")
	public static void performEscapeKey() throws InterruptedException, AWTException{
		
		//Actions action = new Actions(driver);
		//action.sendKeys(Keys.ESCAPE).build().perform();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}
	
	@Step("find multiple element by xpath")
	public static List<AndroidElement> getElementsByIdentification(String loc)
	{
		List<AndroidElement> multipleElements=driver.findElements(By.xpath(loc));
		String [] A=loc.split("#",2);
		String locType=A[0];
		String locAddress=A[1];

		System.out.println(A[0]+":"+A[1]);

		if (locType.equalsIgnoreCase("id"))	 
		{
			multipleElements=driver.findElements(By.id(locAddress)); 
		}
		else if (locType.equalsIgnoreCase("xpath"))

		{
			multipleElements=driver.findElements(By.xpath(locAddress));
		}
		else {
			System.out.println("Invalid location is given ");
		}
		String text="";
		for (int i=0;i<multipleElements.size();i++)
			text=text+"\n"+(i+1)+"."+multipleElements.get(i).getText();
		
		System.out.println("Element Count :"+multipleElements.size()+"\n{"+text+"\n}");
		return multipleElements;
	}
	
	public static void verifyText(String loc , String text) throws InterruptedException
	{
		waitForElement(loc);
		Assert.assertEquals((getElementByIdentification(loc).getText()).toLowerCase(), text.toLowerCase());
	}
	
	@Step("click on {0}")
	public static void  actionClick (String loc) throws InterruptedException
	{
		waitForElement(loc);
		WebElement element=getElementByIdentification(loc);
		Actions ob = new Actions(driver);
		ob.moveToElement(element);
		ob.click(element);
		Action action  = ob.build();
		action.perform();
		element.click();
        		
		
        
		
	}
	
	public void openApp() {
		Lib.openApp();
	}
	
	@Step("get application Id")
	public static String  getApplicationId() {
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String[] parts = url.split("application/");
		System.out.println(parts[1]);
		String applicationIdWithRef = parts[1];
		String[] parts1 = applicationIdWithRef.split("\\?");
		String applicationId = parts1[0];
		System.out.println(applicationId);
		return applicationId;
		
	}
	
	@Step("get application RequestId")
	public static String  getApplicationRequestId() {
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String[] parts = url.split("app_id");
		System.out.println(parts[1]);
		String applicationIdWithRef = parts[1];
		String[] parts1 = applicationIdWithRef.split("\\=");
		String applicationRequestId = parts1[1];
		System.out.println(applicationRequestId);
		return applicationRequestId;
		
	}
	
	
	public static void inputClear (String loc) throws InterruptedException
	    {
	        waitForElement(loc);
	        WebElement element=getElementByIdentification(loc);
	        //new TouchAction(driver).moveTo(element).release().perform();
	        
	        element.clear();
	       // driver.navigate().back();
	    }

	    @Step("Press a key")
	    public static void pressKey(String loc, Keys key) throws InterruptedException, AWTException{
	        
	        WebElement element= getElementByIdentification(loc);
	        element.sendKeys(key);

	        
	    }
	public static boolean checkText(String loc , String text) throws InterruptedException
	    {
	        waitForElement(loc);
	        System.out.println(getElementByIdentification(loc).getText().toLowerCase());
	        System.out.println(text.toLowerCase());
	        System.out.println(((String)getElementByIdentification(loc).getText().toLowerCase()).equals(text.toLowerCase()));
	        return ((String)getElementByIdentification(loc).getText().toLowerCase()).equals(text.toLowerCase());
	    }

	    @Step("Hover over an element")
	    public static void hover(String loc) {
	        WebElement element=getElementByIdentification(loc);
	        
	        Actions builder = new Actions(driver);
	        builder.moveToElement(element).build().perform();
	    }

	    public static void  longWaitForElement(String loc) throws InterruptedException
	    {
	        Thread.sleep(1000);
	        WebDriverWait wait = new WebDriverWait(driver, 300);

	        String [] A=loc.split("#",2);
	        String locType=A[0];
	        String locAddress=A[1];
	        if (locType.equalsIgnoreCase("id"))
	        {
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locAddress)));
	        }

	        if (locType.equalsIgnoreCase("xpath"))
	        {
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locAddress)));
	        }
	        Thread.sleep(1000);
	    }

	    @Step("Verify text of the drop-down selection")
	    public static void verifyDropText(String loc, String text) throws InterruptedException
	        {
	            waitForElement(loc);
	            WebElement element=getElementByIdentification(loc);
	            Select dropdown = new Select(element);
	            System.out.println("Verifying Text");
	            System.out.println(dropdown.getFirstSelectedOption().getText().toLowerCase() + " |  &  | " + text.toLowerCase());
	            Assert.assertEquals(dropdown.getFirstSelectedOption().getText().toLowerCase(), text.toLowerCase());
	        }
	    public static void refresh() {
	        driver.navigate().refresh();
	    }
	
}
