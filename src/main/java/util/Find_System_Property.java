package util;

public class Find_System_Property {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// System.getProperties().list(System.out); // to get the system properties list
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.version"));
	}

}
