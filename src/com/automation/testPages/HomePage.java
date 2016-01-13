package com.automation.testPages;

import java.util.logging.Level;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.base.WebDriverBaseTestpage;
import com.automation.resources.HomePage_loc;
import com.automation.util.LoggerUtil;

public class HomePage extends WebDriverBaseTestpage implements HomePage_loc{
	
	@FindBy(css = text_HomeLogo)
	WebElement textHomeLogo;
	
	@FindBy(xpath = link_StudentLogin)
	WebElement linkStudentLogin; 

	public HomePage() {
	}
	
	public WebElement getTextHomeLogo() {
		return textHomeLogo;
	}
	
	public WebElement getLinkStudentLogin() {
		return linkStudentLogin;
	}

	public void launchApplication() {
		open("/");
	}

	public void verifyLogo() {
		getTextHomeLogo().isDisplayed();
	}

	public void studentLogin() {
		
		getLinkStudentLogin().click();
		logger.log(Level.INFO, "clicked on student login link");
	}

	public void verifyLogo(String string, String string2) {
		
		
	}
	
}
