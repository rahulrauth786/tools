package com.indifi.mobileAutomation.MobileLogin;

import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackDemo {

//  public static String userName = "ajayjagdeva1";
//  public static String accessKey = "SMx6W2zPwpL7iT3xsKVg";

  public static void main(String[] args) throws MalformedURLException, InterruptedException {
	    
      DesiredCapabilities caps = new DesiredCapabilities();
      
      // Set your access credentials
      caps.setCapability("browserstack.user", "rahulrauth1");
      caps.setCapability("browserstack.key", "JetxE9Wq7fZtyWBCpMvU");
      
      // Set URL of the application under test
      caps.setCapability("app", "bs://972295dfdd0e8fa6259337e8d265fce1e7f4c589");
      
      // Specify device and os_version for testing
      caps.setCapability("device", "Google Pixel 3");
      caps.setCapability("os_version", "9.0");
        
      // Set other BrowserStack capabilities
      caps.setCapability("project", "First Java Project");
      caps.setCapability("build", "Java Android");
      caps.setCapability("name", "first_test");
        
      
      // Initialise the remote Webdriver using BrowserStack remote URL
      // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
            new URL("http://hub.browserstack.com/wd/hub"), caps);
        
           
      /* Write your Custom code here */
        driver.findElementById("com.riviera.indifi.app:id/loginPhoneEditText").sendKeys("8888833333");
        System.out.println("com.riviera.indifi.app:id/loginPhoneEditText");
        driver.findElementById("com.riviera.indifi.app:id/loginContinueButton").click();
        System.out.println("com.riviera.indifi.app:id/loginPhoneEditText");
        Thread.sleep(5000);
        driver.findElementById("com.riviera.indifi.app:id/editOtpBox1").sendKeys("1");
        driver.findElementById("com.riviera.indifi.app:id/editOtpBox2").sendKeys("2");
	    driver.findElementById("com.riviera.indifi.app:id/editOtpBox3").sendKeys("3");
	    driver.findElementById("com.riviera.indifi.app:id/editOtpBox4").sendKeys("4");
	    System.out.println("com.riviera.indifi.app:id/editOtpBox1");
	    driver.findElementById("com.riviera.indifi.app:id/otpButtonVerify").click();
	    System.out.println("com.riviera.indifi.app:id/otpButtonVerify");
	    Thread.sleep(10000);
      // Invoke driver.quit() after the test is done to indicate that the test is completed.
         driver.quit();
    
    
  }
}

