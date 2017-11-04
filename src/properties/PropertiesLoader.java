package properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
	private Properties properties;
	private String nameProperties;
	
	protected PropertiesLoader(String name) {
		this.nameProperties = name;
        this.properties = new Properties();
        InputStream in = this.getClass().getResourceAsStream(this.nameProperties);
        try {
        	properties.load(in);
            in.close();
        } catch(IOException e){
        	e.printStackTrace();
        }
	}
	
	protected String getValue(String key) {
		return (String) properties.getProperty(key);
	}
	
	
}
