package com.automation.base;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.util.DemoTestNGUtil;
import com.automation.util.LoggerUtil;

public class WebDriverBaseTestpage extends LoadableComponents {
	public static WebDriverWait webDriverWait = null;
	public static WebDriver driver = null;
	public static Logger logger = null;
	public static DemoTestNGUtil commonUtil = null;

	public WebDriverBaseTestpage() {

		System.out.println(properties.getProperty("browser").toLowerCase());
		if (driver == null) {

			if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (properties.getProperty("browser").equalsIgnoreCase(
					"chrome")) {
				System.setProperty("webdriver.chrome.driver",
						properties.getProperty("server.path"));
				driver = new ChromeDriver();

			} else if (properties.getProperty("browser").equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						properties.getProperty("server.path"));
				driver = new InternetExplorerDriver();
			}

			webDriverWait = new WebDriverWait(driver, 10);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			PageFactory.initElements(driver, this);

			logger = new LoggerUtil().getLoggerInstance();
			commonUtil = new DemoTestNGUtil().getCommonUtilInstance();

		}
	}

	public void open(Object object) {
		driver.get(properties.getProperty("app.url"));
	}

}
