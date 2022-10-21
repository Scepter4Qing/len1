package sc;

public class BinOp extends AST {
	AST leftNode;
	Token op;
	AST rightNode;
	
	public BinOp(AST left, Token o, AST right ) {
		leftNode = left;
		op = o;
		rightNode = right;
	}
	
	public int visit() {
		int result = 0;
		if (op.type == "PLUS") {
			result = leftNode.visit() + rightNode.visit();
		}
		if (op.type == "MINUS") {
			result = leftNode.visit() - rightNode.visit();
		}
		if (op.type == "MUL") {
			result = leftNode.visit() * rightNode.visit();
		}
		if (op.type == "DIV") {
			result = leftNode.visit() / rightNode.visit();
		}
		//System.out.println(result);
		return result;
	}
}
