package sc;

public class UnaryOp extends AST{
	Token op;
	AST expr;
	
	public UnaryOp(Token o, AST e) {
		op = o;
		expr = e;
	}
	
	public int visit() {
		int result = 0;
		if(op.type == "PLUS")
			result = expr.visit();
		else if (op.type== "MINUS")
			result = - expr.visit();
		return result;
	}
}
