package com.greatlearning.lab3;
import java.util.*;
public class BalancingBrackets {
	
	static boolean checkingBraketsBalanace(String strBalanceExpression){
		
		Deque <Character > Stack = new ArrayDeque <Character> ();
		
		for (int i = 0; i <strBalanceExpression.length();i++)
		{
			char Character = strBalanceExpression.charAt(i);
			
			if (Character == '(' || Character == '[' || Character == '{' ){
				
				Stack.push(Character);
				continue;
				
				}
			//if current character is not opening
			//bracket, then it must be closing, so stack can not be empty at this point
			
			if (Stack.isEmpty())
				return false;
			
			char check;
			switch (Character) {
			
			case ')':
				
				check = Stack.pop();
					
					if (check == '{' || check == '[' )
						return false;
								break;
						
			case '}':
				check = Stack.pop();
				if (check == '(' || check == '[')
					return false;	
				break;
			
				case ']':
					check = Stack.pop();
					if (check == '(' || check == '{') 
					return false;
					break;
			}
			
		}
		
	
	return (Stack.isEmpty());
			
	}
	
	public static void main (String [] args ) {
		String strBalanceBracket = "([[{}]])";
		//please enter above "([[{}]]))" to get the output for unbalanced bracket
		
		boolean result;
		result =  checkingBraketsBalanace (strBalanceBracket);
		
		if (result)
			System.out.println ("The entered String has Balanced Brackets");
		else
			System.out.println ("The entered Strings do not contain Balanced Brackets");
	
	}

}
