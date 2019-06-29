import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class Calculation {

	int NumbersCalculation(ArrayList<String> sequence) {
	    int number1 = 0; 
	    while (true) {       
	        try {                
	            if (number1==0) number1 = getNextNumber(sequence);  
	            char operator = getNextOperator(sequence);  
	            int number2 = getNextNumber(sequence);
	            switch (operator) {   
	                case '+':
	                    number1 += number2; 
	                    break;
	                case '-':
	                    number1 -= number2;
	                    break;
	                case '*':
	                    number1 *= number2;
	                    break;
	                case '/':
	                	if (number2==0) throw new IllegalArgumentException();
	                    number1 /= number2;
	                    break;
	            }
	        } catch (java.lang.IndexOutOfBoundsException e) { 
	            return number1;
	        }
	    }
	}
	
	static int listToInt(ArrayList<Integer> nextNumber) {
	    int result = 0;
	    int offset = 1;
	    for(int i = nextNumber.size() - 1; i >= 0; i--) {
	        result += nextNumber.get(i)*offset;
	        offset *= 10;
	    }
	    return result;
	}
	
	static char getNextOperator(ArrayList<String> sequence) {
	    String function = "[+\\-*/]+";   
	    if (sequence.get(0).matches(function)) {  
	        return sequence.remove(0).charAt(0);  
	    }
	    return ' ';
	}	
	
	private static int getNextNumber(ArrayList<String> sequence) { 
	    int number = 666;
	    ArrayList<Integer> nextNumber = new ArrayList<Integer>();
	    if (sequence.size() == 0) throw new IndexOutOfBoundsException(); 
	    while (true) {
	    	try {
			    if (sequence.get(0).matches("[+\\-*/]") && sequence.get(1).matches("[+\\-*/]")) {
			    	throw new IllegalArgumentException();
			    } else if (sequence.get(0).matches("[\\d]")) { 
			    	number = Integer.parseInt(sequence.remove(0)); 
			        nextNumber.add(number);}
			    else if (sequence.get(0).matches("[+\\-*/]")) break;
	    	}  catch (java.lang.IndexOutOfBoundsException e) {number = listToInt(nextNumber);
		    return number;  } }
		    number = listToInt(nextNumber);
		    return number;   
	}

}