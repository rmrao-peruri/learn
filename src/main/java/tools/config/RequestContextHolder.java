package tools.config;

public class RequestContextHolder {
	private static final ThreadLocal<String> countryHolder = new ThreadLocal<String>();
	
	public static void setCountry(String ctry) {
		countryHolder.set(ctry);
	}

	public static String getCountry() {
		return countryHolder.get();
	}
}
