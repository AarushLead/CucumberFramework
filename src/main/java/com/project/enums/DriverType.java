package com.project.enums;

public enum DriverType {
FIREFOX("webdriver.chrome.driver"),
CHROME("webdriver.chrome.driver"),
IE("webdriver.ie.driver");
private String driverName;
	DriverType(String driverName)
	{
		this.driverName=driverName;
		
	}
	public String getdriverName()
	{
		return this.driverName;
	}
}
