package hw3;

public class Calculator
{
	QueueAr q;
	
	Calculator( String infix )
	{
		Converter conv = new Converter( infix );
		try {
			this.q = conv.toPostFix();
			
			System.out.println( "converted to postfix: " + this.q.toString() );
			System.out.println( "answer is: " + this.result() );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double result()
	{
		return Calculator.result( this.q );
	}
	
	public static double result( QueueAr q )
	{
		double num, op1, op2, result;
		
		String token;
		StackLi stack = new StackLi();
		
		op1 = 0;
		op2 = 0;
		
		while( !q.isEmpty( ) )
		{
			token = (String) q.dequeue();
						
			if( Calculator.isOperand( token ) )
			{
				stack.push( new Double( token ) );
			}
			else if( Calculator.isOperator( token ) )
			{
				try{
					op1 = (Double)stack.topAndPop();
					op2 = (Double)stack.topAndPop();
				} catch (Exception e) {}  //catch but do nothing
				result = Calculator.evaluate( op2, token.charAt(0), op1 );
				try{
					stack.push(new Double(result));
				} catch (Exception e) {}
			}

		}
				
		return (Double) stack.topAndPop();

	}
	
	public static boolean isOperator(char op)
	{
		return ((op=='*') || (op =='/') || (op=='+') || (op=='-') || (op=='(') || (op==')'));
	}
	
	public static boolean isOperator(String op)
	{
		return Calculator.isOperator( op.charAt( 0) );
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
		Calculator calc = new Calculator( "(300+23)*(43-21)/(84+7)" );
		
		
	}
}
