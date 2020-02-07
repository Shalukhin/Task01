package util;

public class ConstantsText {
	
	public static final String LINK_TOURS;

	static {
		StringBuilder link = new StringBuilder();
		link.append(System.getProperty("user.dir"));
		link.append("\\src\\main\\resources\\data\\tours.txt");
		LINK_TOURS = link.toString();
	}	

}
