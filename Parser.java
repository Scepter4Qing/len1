package sc;

public class Parser {
	Lexer lexer;
	Token currentToken;
	
	public Parser(Lexer l) {
		lexer = l;
		currentToken = lexer.getNextToken();
	}
		
	public void eat(String type) {
		if(currentToken.type == type)
			currentToken = lexer.getNextToken();
	}
	
	public AST factor() {
		Token t = currentToken;
		AST node = null;
		if (t.type == "PLUS") {
			eat("PLUS");
			node = new UnaryOp(t, factor());
		}else if(t.type == "MINUS") {
			eat("MINUS");
			node = new UnaryOp(t, factor());
		}
		else if(t.type == "INT") {
			eat("INT");
			node = new Num(t);
		}else if(t.type == "LPA"){
			eat("LPA");
			node = expr();
			eat("RPA");
		}	
		return node;
	}
	
	public AST term() {
		AST node = factor();
		while(currentToken.type == "MUL" | 
				currentToken.type == "DIV") {
			Token t = currentToken;
			if(t.type == "MUL") {
				eat("MUL");
			}
			if(t.type == "DIV") {
				eat("DIV");
			}
			node = new BinOp(node, t, factor() );
		}
		return node;
	}
	
	public AST expr() {
		AST node = term();
		while(currentToken.type == "PLUS" | 
				currentToken.type == "MINUS") {
			Token t = currentToken;
			if(currentToken.type == "PLUS") {
				eat("PLUS");
			}
			if(currentToken.type == "MINUS") {
				eat("MINUS");
			}
			node = new BinOp(node, t, term() );	
		}
		return node;
	}
	
	public AST parse() {
		return expr();
	}
}
