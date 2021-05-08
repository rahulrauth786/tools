package com.indifi.mob.init;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Lib {

	public Lib(AndroidDriver<AndroidElement> driver) {
		openApp();
	}

	public static AndroidDriver<AndroidElement> openApp() {
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
		AndroidDriver<AndroidElement> driver = null;
		try {
			driver = new AndroidDriver<AndroidElement>(
					new URL("http://hub.browserstack.com/wd/hub"), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driver;

	}

}
