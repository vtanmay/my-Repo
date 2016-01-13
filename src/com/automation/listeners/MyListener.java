package com.automation.listeners;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

public class MyListener implements IReporter{
	public MyListener() {

		Reporter.log("AAAAAAAAAAAAAAA");
		Reporter.log("test");
		Reporter.log("AAAAasdsdasdAA");
	}

	@Override
	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1,
			String arg2) {
		// TODO Auto-generated method stub
		
	}
}
