package principal;

import java.util.Stack;

public class ExceptionParentesis extends Exception{
	
	public ExceptionParentesis(Stack<Integer> pos) {
		super(pos.toString());
	}
}
