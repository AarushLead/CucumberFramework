package com.cucumber.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.project.enums.EnvironmentType;

public class ConfigFileReaderUtil {
	private Properties prop;
	private final String dirPath;
	private String filePath;
	private String url;
	private String chroPath;
	private String firePath;
	private String iePath;
	private String implicitlyWait;
	private String pageLoadWait;
	private String envName;

	public ConfigFileReaderUtil() {
		dirPath = System.getProperty("user.dir");
		filePath = dirPath + "/configurtion/appconfig.properties";
		loadConfigFile(filePath);
	}
	public void loadConfigFile(String path)
	{
		try {
			FileReader fis = new FileReader(new File(path));
			BufferedReader bfr = new BufferedReader(fis);
			try {
				prop = new Properties();
				prop.load(fis);
				bfr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("appconfig.properties not found at " + filePath);
		}
	}

	public String getUrl() {
		this.url = prop.getProperty("appUrl");
		if (url != null) {
			return this.url;
		} else {
			throw new RuntimeException("App url not specified in appConfig.properties file");
		}
	}

	public String getChroPath() {
		this.chroPath = prop.getProperty("chroDriverpath");
		if (chroPath != null) {
			return this.chroPath;
		} else {
			throw new RuntimeException("chropath not specified in appConfig.properties file");
		}
	}

	public String getFirePath() {
		this.firePath = prop.getProperty("fireDriverpath");
		if (firePath != null) {
			return this.firePath;
		} else {
			throw new RuntimeException("Firepath not specified in appConfig.properties file");
		}
	}

	public String getIEPath() {
		this.iePath = prop.getProperty("ieDriverpath");
		if (iePath != null) {
			return this.iePath;
		} else {
			throw new RuntimeException("IE path not specified in appConfig.properties file");
		}
	}
	public Long getImplicitlywait() {
		this.implicitlyWait = prop.getProperty("implicitlywait");
		if (implicitlyWait != null) {
			return Long.parseLong(implicitlyWait);
		} else {
			throw new RuntimeException("Not able to parse value :" + implicitlyWait + " into Long");
		}
	}

	public Long getPageLoadWait() {
		this.pageLoadWait = prop.getProperty("pageLoadwait");
		if (pageLoadWait != null) {
			return Long.parseLong("pageLoadwait");
		} else {
			throw new RuntimeException("Not able to parse value " + pageLoadWait + " into Long");
		}
	}

	public EnvironmentType getEnvironmentType() {
		this.envName = prop.getProperty("environment");
		if (envName == null || envName.equalsIgnoreCase("local")) {
			return EnvironmentType.LOCAL;
		} else if (envName.equalsIgnoreCase("Remote")) {
			return EnvironmentType.REMOTE;
		} else {
			throw new RuntimeException(
					"Environment Type Key value in Configuration.properties is not matched : " + envName);
		}
	}

}
