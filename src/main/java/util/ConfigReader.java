package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;
	public Properties init_Properties() {
		
		properties=new Properties();
		try {
			FileInputStream fis=new FileInputStream("./src/test/resources/config/config.properties");
		properties.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return properties;
	}
}
