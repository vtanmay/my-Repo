package com.automation.testScript;

import java.util.logging.Level;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automation.testPages.HomePage;

public class loginToApplication {

	@Test
	public void VerifyLogin1() {
		HomePage homePage = new HomePage();
		homePage.launchApplication();
		Reporter.log("asdhn aksdhajs");
		homePage.verifyLogo();
		homePage.studentLogin();
		
		homePage.logger.log(Level.INFO, "Execution completed");
		
	}
	
	@Test
	public void VerifyLogin3() {
		HomePage homePage = new HomePage();
		homePage.launchApplication();
		Reporter.log("");
		homePage.verifyLogo();
		homePage.studentLogin();
		Reporter.log("ABC askjfhksjd");
		homePage.logger.log(Level.INFO, "Execution completed");
		
	}

}
