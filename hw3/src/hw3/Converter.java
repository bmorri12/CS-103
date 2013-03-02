package hw3;

class Converter {
	
	String infix;
	
	Converter( String infix )
	{
		this.infix = infix;
	}
	
	public QueueAr toPostFix() throws Exception {
		this.infix = this.infix + ')';
		
		int len = this.infix.length();
		
		QueueAr s = new QueueAr( len ); // output stack
		StackLi internal = new StackLi(); // stack for internal manipulation
		
		// wrap it all
		internal.push( '(' );
		
		char token;
		for( int j = 0; j < len; j++ )
		{
			token = this.infix.charAt( j );

			if( Calculator.isOperand( token ) )
			{
				s.enqueue( token ); // put the token onto the output stack
			}
			else if( token == '(' )
			{
				internal.push( token );
			}
			else if( token == ')' )
			{
				while( !internal.isEmpty() )
				{
					if( internal.top() != '(' )
					{
						s.enqueue( internal.topAndPop() );
					}
					else
					{
						internal.pop();
					}
				}
			}
			else
			{
				while( !internal.isEmpty() && Calculator.precedence( token, internal.top() ) )
				{
					if( internal.top() == '(' )
					{
						internal.pop();
					}
					else
					{
						s.enqueue( internal.topAndPop() );
					}
				}
				internal.push( token );
			}

		}
		
		// add final bits
		while( ! internal.isEmpty() )
		{
			s.enqueue( internal.topAndPop() );
		}
		
		return s;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Converter conv = new Converter( "(4+8)*(6-5)/((3-2)*(2+2))");
		
		try {
			conv.toPostFix().print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String s = "23+4*63/-";
//		int len = s.length();
//		StackLi stack = new StackLi();
//		char token;
//		Double digit1 = new Double (0), digit2 = new Double (0),ans;
//		double num, op1, op2, result;
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

}
