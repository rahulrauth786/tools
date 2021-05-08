package com.indifi.mobileAutomation.MobileLogin;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumDemo {

	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) {
		try {
			openIndifiApp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}
	}

	public static void openIndifiApp() throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10.0");
		caps.setCapability("udid", "RZ8N905QF7N");
		caps.setCapability("appPackage", "com.riviera.indifi.app");
		caps.setCapability("appActivity", ".MainActivity");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, caps);
		Thread.sleep(5000);
		// driver.findElementById("Xpath//*[@id=\"screenshotContainer\"]/div/div/div/div/div/div[1]").click();;
		WebElement num = driver.findElementById("android:id/text1");
		num.click();
		WebElement enterPhoneNumber = driver.findElementById("com.riviera.indifi.app:id/loginPhoneEditText");
		enterPhoneNumber.clear();
		enterPhoneNumber.sendKeys("8888833333");
		WebElement next = driver.findElementById("com.riviera.indifi.app:id/loginContinueButton");
		next.click();
		Thread.sleep(5000);

		driver.findElementById("com.riviera.indifi.app:id/editOtpBox1").sendKeys("1");
		driver.findElementById("com.riviera.indifi.app:id/editOtpBox2").sendKeys("2");
		driver.findElementById("com.riviera.indifi.app:id/editOtpBox3").sendKeys("3");
		driver.findElementById("com.riviera.indifi.app:id/editOtpBox4").sendKeys("4");
		driver.findElementById("com.riviera.indifi.app:id/otpButtonVerify").click();

		System.out.println("App Started Successfully");

	}
	
	public static void topUpPage() {
		driver.findElementById("com.riviera.indifi.app:id/loanDetailsCustomerButton1").click();
	}

}
