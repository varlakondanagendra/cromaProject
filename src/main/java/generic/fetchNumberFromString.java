package generic;

public class fetchNumberFromString {

	public static void main(String[] args) {
		String s1="asdfghj12345";
		String s2= 	numbers(s1);
        System.out.println("Numbers extracted from the text: " + s2);
      
		
	}

public static String numbers(String s1) {	
    StringBuilder numberBuilder = new StringBuilder();
    for(char c:s1.toCharArray()) {
    	 if (Character.isDigit(c)) {
             numberBuilder.append(c);
    	 }
    }
    return numberBuilder.toString();
}
}