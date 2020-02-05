package util;

public class ConstantsText {
	
	public static final String LINK_TOURS;

	static {
		StringBuilder link = new StringBuilder();
		link.append(System.getProperty("user.dir"));
		link.append("\\src\\main\\resources\\data\\tours.txt");
		LINK_TOURS = link.toString();
	}

	public static final String LINK_CLIENTS;

	static {
		StringBuilder link = new StringBuilder();
		link.append(System.getProperty("user.dir"));
		link.append("\\src\\main\\resources\\data\\clients.txt");
		LINK_CLIENTS = link.toString();
	}
	
	public static final String LINK_ORDERS;

	static {
		StringBuilder link = new StringBuilder();
		link.append(System.getProperty("user.dir"));
		link.append("\\src\\main\\resources\\data\\orders.txt");
		LINK_ORDERS = link.toString();
	}

}
