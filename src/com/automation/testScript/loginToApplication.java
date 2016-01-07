package com.automation.testScript;

import java.util.logging.Level;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.automation.testPages.HomePage;
import com.automation.testPages.LoginPage;
import com.automation.util.LoggerUtil;

public class loginToApplication {

	@Test
	public void f() {
		HomePage homePage = new HomePage();
		homePage.launchApplication();
		homePage.verifyLogo();
		homePage.studentLogin();
		homePage.logger.log(Level.INFO, "Execution completed");
		
	}

}
