package hw3;

public class Calculator
{
	QueueAr q;
	
	Calculator( String infix )
	{
		Converter conv = new Converter( infix );
		try {
			this.q = conv.toPostFix();
			
			this.q.print();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void result( QueueAr q )
	{
		double num, op1, op2, result;
		
		String token;
		StackLi stack = new StackLi();
		
		while( !q.isEmpty( ) )
		{
//            System.out.println( this.dequeue( ) );
			token = (String) q.dequeue();
			
			if( Calculator.isOperand( token ) )
			{
				stack.push( new Double( token ) );
			}

		}
		
//		for(int j = 0; j < len; j++)
//		{
//			token = s.charAt(j);
//			if( isOperand(token) )
//			{
//				num = token - '0';
//				try{
//					stack.push(new Double(num));
//				} catch (Exception e) {} // catch but do nothing
//			}
//			else if( isOperator(token))
//			{
//				try{
//					digit2 = (Double)stack.topAndPop();
//					digit1 = (Double)stack.topAndPop();
//				} catch (Exception e) {}  //catch but do nothing
//				op2 = digit2.doubleValue();
//				op1 = digit1.doubleValue();
//				result = evaluate(op1, token, op2);
//				try{
//					stack.push(new Double(result));
//				} catch (Exception e) {}  //catch but do nothing
//			}
//		}
//		ans = (Double)stack.topAndPop();
//		System.out.println("result is " + ans.doubleValue() );
	}
	
	public static boolean isOperator(char op)
	{
		return ((op=='*') || (op =='/') || (op=='+') || (op=='-') || (op=='(') || (op==')'));
	}
	
	public static boolean isOperand(String op)
	{
		try
		{
			double d = Double.parseDouble( op );
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}
	
	public static boolean isOperand(char op)
	{
		return ((op >= '0') && (op <= '9'));
	}
	
	public static double evaluate(double op1, char operator, double op2 )
	{
		switch( operator)
		{
			case '*': return op1*op2;
			case '/': return op1/op2;
			case '+': return op1+op2;
			case '-': return op1-op2;
		}
		
		System.out.println("not a valid operator");
		return 0;
	}
	
	/**
	 * Returns the priority of a character
	 */
	public static int priority( char op )
	{
		if( op == '/' || op == '*' )
		{
			return 2;
		}
		else if( op == '+' || op == '-' )
		{
			return 1;
		}
		return 0;
	}
	
	/**
	 * Compares the precedence of 2 operators.
	 * 
	 * @return true if op1 has precedence over op2
	 */
	public static boolean precedence( char op1, char op2 )
	{
		return ( Calculator.priority( op1) >= Calculator.priority( op2 ) );
	}
	
	public static boolean precedence( String op1, String op2 )
	{
		return ( Calculator.priority( op1.charAt( 0 )) >= Calculator.priority( op2.charAt( 0 ) ) );
	}
	
	public static void main(String[] asd)
	{
		Calculator calc = new Calculator( "(4+8)*(6-5)/((3-2)*(2+2))" );
		
		System.out.println( calc.result() );
		
	}
}
