package evaluator.arith;

import language.Operand;
import language.Operator;
import parser.IllegalPostfixExpressionException;
import parser.PostfixParser.Type;
import parser.Token;
import parser.arith.ArithPostfixParser;
import stack.LinkedStack;
import stack.StackInterface;
import evaluator.PostfixEvaluator;

/**
 * An {@link ArithPostfixEvaluator} is a postfix evaluator over simple arithmetic expressions.
 *
 */
public class ArithPostfixEvaluator implements PostfixEvaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;
	
	/**
	 * Constructs an {@link ArithPostfixEvaluator}
	 */
	public ArithPostfixEvaluator(){
		this.stack = new LinkedStack(); //TODO initialize your LinkedStack
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer evaluate(String expr) throws IllegalPostfixExpressionException {
		// TODO use all of the things you've built so far to 
		// implement the algorithm for postfix expression evaluation
		
		ArithPostfixParser parser = new ArithPostfixParser(expr);
		for (Token<Integer> token : parser) {
			Type type = token.getType();
			switch(type){ 
			case OPERAND:
				stack.push(token.getOperand());
				//TODO What do we do when we see an operand?
				break;
			case OPERATOR:
				if (token.getOperator().toString() == "!"){
					token.getOperator().setOperand(0, stack.pop());
					stack.push(token.getOperator().performOperation());
				}
				else{
					token.getOperator().setOperand(1, stack.pop());
					token.getOperator().setOperand(0, stack.pop());
					stack.push(token.getOperator().performOperation());
				}
				//TODO What do we do when we see an operator?
				break;
			default:
				throw new IllegalStateException("Parser returned an invalid Type: " + type);
			}			
		}
		
		//TODO What do we return?
		if (stack.size() != 1)
			throw new IllegalPostfixExpressionException();
		return stack.pop().getValue();
	}

}
