package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 * �����
 * ����ģ�飺LimeSurvey����ģ�飨��ҳ�趨��ȫ�����ã�
 */

public class ReadProperties {

	public static final String filePath="conf/config.properties";	

	public static String getPropertyValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		fis.close();
		return prop.getProperty(key);		
	}
	
}
