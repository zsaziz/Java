package language;

public abstract class UnaryOperator<T> implements Operator<T> {
	
	protected Operand<T> op;
	
	public int getNumberOfArguments(){
		return 1;
	}
	
	public void setOperand(int i, Operand<T> operand){
		if (operand == null)
			throw new NullPointerException("Could not set null operand");
		if (i != 0)
			throw new IllegalArgumentException();
		if (op != null)
			throw new IllegalStateException();
		op = operand;
	}

}
