package language.arith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import language.Operand;
import language.Operator;

import org.junit.Before;
import org.junit.Test;

public class DivOperatorTest {
	Operator<Integer> operator;
	Operand<Integer> op0;
	Operand<Integer> op1;
	
	@Before
	public void setup(){
		operator = new DivOperator();
		op0 = new Operand<Integer>(5);
		op1 = new Operand<Integer>(7);
	}

	@Test (timeout = 5000)
	public void testPerformOperation() {		
		operator.setOperand(0, op0);
		operator.setOperand(1, op1);
		
		Operand<Integer> result = operator.performOperation();
		int value = result.getValue();
		assertEquals("Operator applied to 5 and 7 should produce 0.", 0,  value);
	}
	
	@Test (timeout = 5000, expected = NullPointerException.class)
	public void testNullArgumentException(){
		operator.setOperand(0, null);
		fail("Operator should not allow null arguments");
	}

}
