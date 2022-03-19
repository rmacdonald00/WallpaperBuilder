package providerManagers;

import java.io.FileInputStream;
import java.util.Properties;

public abstract class ProviderManager<T> {
	
	private static String configFilepath = "./config/config.properties";
	private Properties properties;
	
	private void loadProperties(){
		properties = new Properties();
		try (FileInputStream fis = new FileInputStream(configFilepath)) {
			properties.load(fis);
		} catch (Exception ex) {
		    ex.printStackTrace();
		    System.exit(1);
		}
	}
	
	protected String getConfigType(String sectionTitle) {
		if(properties == null) {
			loadProperties();
		}
		return properties.getProperty(sectionTitle);
	}
	
	
	
	public abstract T getBuilder();
	
}
