package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

	private static Properties prop;
	static {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
			prop.load(fis);
			
		}catch(IOException e) {
			throw new RuntimeException("config.properties not found or not readable",e);
		}
	}
	
	 public static String get(String key) {
	        return prop.getProperty(key);
	    }
}
