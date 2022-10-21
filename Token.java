package sc;

public class Token {
	String type;
	String value;
	
	public Token(String t, String v) {
		type = t;
		value = v;
	}
	
	public void printToken() {
		System.out.println(
			"Token:"+type+','+value	);
	}
}
