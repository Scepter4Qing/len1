package sc;

public class Interpreter {
	Parser parser;
	
	public Interpreter(Parser p) {
		parser = p;
	}
	
	public int interpret() {
		AST tree = parser.parse();
		return tree.visit();
	}
	
	
	
}
