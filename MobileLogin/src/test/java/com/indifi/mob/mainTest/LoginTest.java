package com.indifi.mob.mainTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.indifi.mob.common.ComBase;

public class LoginTest extends ComBase {
	
	
	
	@Test(priority = 1)
	public static void Login() throws InterruptedException {
		input("com.riviera.indifi.app:id/loginPhoneEditText", "8888833333");
		click("com.riviera.indifi.app:id/loginContinueButton");
		Thread.sleep(10000);
	}
	
	@Test(priority = 2)
	public static void OtpPage() throws InterruptedException {
		
		input("com.riviera.indifi.app:id/editOtpBox1", "1");
		input("com.riviera.indifi.app:id/editOtpBox2", "2");
		input("com.riviera.indifi.app:id/editOtpBox3", "3");
		input("com.riviera.indifi.app:id/editOtpBox4", "4");
		click("com.riviera.indifi.app:id/otpButtonVerify");
		Thread.sleep(10000);
		driver.quit();
		
	}

}

