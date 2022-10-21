package sc;




public class Lexer {
	String text;
	int pos;
	char current_Char;
	
	public Lexer(String t) {
		text = t;
		pos = 0;
		current_Char = text.charAt(pos);
	} 
	
	public void advance() {
		pos += 1;
		//System.out.println(current_Char);
		if(pos > text.length()-1)
			current_Char = '\\';
		else
			current_Char = text.charAt(pos);
	}
	
	public void whiteSpace() {
		while(current_Char != '\\' && Character.isSpaceChar(current_Char))
			advance();
	}
	
	public String integer() {
		String r = "";
		while(current_Char != '\\' && Character.isDigit(current_Char)) {	
			r += current_Char;
			advance();
		}
		return r;
	}
	
	public Token getNextToken() {
		while(current_Char != ('\\')) {
			if(Character.isSpaceChar(current_Char))
				whiteSpace();
			if(Character.isDigit(current_Char)) 
				return new Token("INT",integer());
			if(current_Char == '+') {
				advance();
				return new Token("PLUS","+");
			}
			if(current_Char == '-'){
				advance();
				return new Token("MINUS","-");
			}
			if(current_Char == '*'){
				advance();
				return new Token("MUL","*");
			}
			if(current_Char == '/'){
				advance();
				return new Token("DIV","/");
			}
			if(current_Char == ')'){
				advance();
				return new Token("RPA",")");
			}
			if(current_Char == '('){
				advance();
				return new Token("LPA","(");
			}
		}
		return new Token("EOF","");
	}
	
	
}
