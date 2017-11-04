package properties;

public class PropertiesLoaderVariability {
	private static PropertiesLoader loader = new PropertiesLoader("variability.properties");
	public static String getValor(String key){
		return (String)loader.getValue(key);
	}
}
