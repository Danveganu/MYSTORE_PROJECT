package com.mystore.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	public static Properties p;
	 String cpPath=System.getProperty("user.dir")+"\\config\\config.properties";
	
	public ConfigDataProvider() throws IOException {
	    //String cpPath=System.getProperty("user.dir")+"\\config\\config.properties";
		File src=new File(cpPath);
		try {
			FileInputStream file = new FileInputStream(src);  // this is for getting file location
			p=new Properties();                     // this is for creating properties class object
			p.load(file);                           // this is for loading Properties file into object of properties class
			}
		catch (FileNotFoundException e){
			e.printStackTrace();
			} 
		       
			}
	    public String getAppURL() {
		 String value=p.getProperty("AppURL");
		
		if(value!=null) 
			return value;
		else
			throw new RuntimeException("url not correct in properties file");
		}
}

