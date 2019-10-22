package com.cucumber.manager;

import com.cucumber.utils.ConfigFileReaderUtil;
import com.cucumber.utils.ExcelFileReaderUtil;

public class FileReaderManager 
{
private static FileReaderManager frm;
private static ConfigFileReaderUtil cfr;
private static ExcelFileReaderUtil efr;

private FileReaderManager(){}
public static FileReaderManager getInstance()
{   
	if(frm==null)
	{
		synchronized(frm)
		{
			if(frm==null)
			{
				frm=new FileReaderManager();
			}
		}
	}
	return frm;
}
public  ConfigFileReaderUtil getConfigFile()
{
	return(cfr==null) ?new ConfigFileReaderUtil() :cfr;
}
public  ExcelFileReaderUtil getExcelFile()
{
	return(efr==null) ?new ExcelFileReaderUtil() :efr;	
}

}
