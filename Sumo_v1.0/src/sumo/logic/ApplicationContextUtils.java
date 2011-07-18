package sumo.logic;
/*
 * Filename:ApplicationContextUtils.java
 * Ersteller: danielburgstaller
 */
public class ApplicationContextUtils {
	private static  ApplicationContext applicationContext;
	private ApplicationContextUtils() {}
	
	public static synchronized ApplicationContext getApplicationContext(){
		if (applicationContext == null) {
			applicationContext = new ApplicationContext();
		}
		return applicationContext;
	}
}