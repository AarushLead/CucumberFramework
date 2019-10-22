package com.cucumber.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.project.enums.DriverType;
import com.project.enums.EnvironmentType;

public class WebDriverManager
{
	protected static WebDriver driver;
	protected static String chropath = FileReaderManager.getInstance().getConfigFile().getChroPath();
	protected static String firepath = FileReaderManager.getInstance().getConfigFile().getFirePath();
	protected static String iepath = FileReaderManager.getInstance().getConfigFile().getIEPath();
	protected static EnvironmentType environmentType=FileReaderManager.getInstance().getConfigFile().getEnvironmentType();
	protected DriverType driverType;

	public static WebDriver getDriver(String driverName) {
		if (driver == null) {
			driver = generateDriver(driverName);
		}
		return driver;
	}

	public  static WebDriver generateDriver(String driverName)
	{
		switch(environmentType)
		{
		case LOCAL:
			driver=localDriver(driverName);
			break;
		case REMOTE:
			driver=remoteDriver();
			break;
		}
		return driver;
	}
		
		
	private static WebDriver remoteDriver() {
		
		throw new RuntimeException("RemoteDriver is not yet implemented yet");
	}

	public  static WebDriver localDriver(String driverName) {
		
		switch(DriverType.valueOf(driverName.toUpperCase()))
		{
		case FIREFOX:
			System.setProperty(DriverType.FIREFOX.getdriverName(),firepath);
			driver=new FirefoxDriver();
		case CHROME:
			System.setProperty(DriverType.CHROME.getdriverName(),chropath);
			driver=new ChromeDriver();
			break;
		case IE:
			System.setProperty(DriverType.IE.getdriverName(),iepath);
			driver=new InternetExplorerDriver();
			break;
		default:
			System.setProperty(DriverType.FIREFOX.getdriverName(),firepath);
			break;
		}
		return driver;
	}
}
