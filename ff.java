package sc;

public class ff {
	public static void main(String[] args) {
		Lexer l = new Lexer("5 - - - + - (3 + 4) - +2");
		Parser p = new Parser(l);
		Interpreter i = new Interpreter(p);
		int result = i.interpret();
		System.out.println(result);
	}
}
