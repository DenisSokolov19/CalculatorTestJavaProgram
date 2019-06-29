import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class Parsing {
	
	public boolean exit (String s) {
		Scanner input = new Scanner(s);
		while(input.hasNextLine()){		
				String str = input.findInLine("exit");
				if(str != null) {input.close(); return true;}
				else break;
		}
		input.close();
		return false;	
	}
	
	static int romansNumeralsList(char c) { 
		if (c == 'I') return 1; 
		if (c == 'V') return 5; 
		if (c == 'X') return 10; 
		if (c == 'L') return 50; 
		if (c == 'C') return 100; 
		if (c == 'D') return 500; 
		if (c == 'M') return 1000; 
		return 0;}
	
	private static final TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
	static {
	    map.put(1000, "M");
	    map.put(900, "CM");
	    map.put(500, "D");
	    map.put(400, "CD");
	    map.put(100, "C");
	    map.put(90, "XC");
	    map.put(50, "L");
	    map.put(40, "XL");
	    map.put(10, "X");
	    map.put(9, "IX");
	    map.put(5, "V");
	    map.put(4, "IV");
	    map.put(1, "I");
	}
	
	String parser(String input) throws Exception{
		Calculation n = new Calculation();
		int x = 0;
		if (input.indexOf("-")==0) throw new IllegalArgumentException();
	    char[] inputChars = input.toCharArray();  
	    ArrayList<String> sequence = new ArrayList<>();
	    boolean haveNumber = false;
	    boolean haveRoman = false;
	    for (char c : inputChars) { 
		        if ((new String("" + c)).matches("[a-zA-Z&&[^VXILCDM]]")) { 
		        	throw new IllegalArgumentException();
		        } else if ((new String("" + c)).matches("[VXILCDM]")) { 
		        	sequence.add("" + c);
		        	haveRoman = true; if (haveRoman && haveNumber) throw new IllegalArgumentException();
		        } else if ((new String("" + c)).matches("[+\\-*/]+")) {  
		            sequence.add("" + c);  
		        } else if ((new String("" + c)).matches("[\\d]+")) {  
		        	sequence.add("" + c);
		        	haveNumber=true; if (haveRoman && haveNumber) throw new IllegalArgumentException();
		        } else if ((new String("" + c)).matches("[,.]+")) { 
		        	throw new IllegalArgumentException();}
	        } 
	        if (haveRoman) {
	        	sequence = romansParser(sequence);
	        	sequence = listSplit(sequence);
	        	x = n.NumbersCalculation(sequence);
		        String numberAsString = intToRoman(x);
		        return numberAsString;
	        }
	        x = n.NumbersCalculation(sequence);
	        String numberAsString = String.valueOf(x);
	        return numberAsString;
	    }    
	
	ArrayList<String> romansParser(ArrayList<String> sequence){ 
		ArrayList<String> sequence2 = new ArrayList<>();
	    while (true) {
	    	try {
	    		sequence2.add(RomansToArabic(sequence));
	    		sequence2.add(getNextOperator(sequence));
	    	} catch (java.lang.IndexOutOfBoundsException e) 
	    		{return sequence2;}
	    }
	} 
	
	static String getNextOperator(ArrayList<String> sequence) {
	    String function = "[+\\-*/]+";   
	    if (sequence.get(0).matches(function)) {  
	        return sequence.remove(0);  
	    }
	    return null;
	}	    
	
		String RomansToArabic(ArrayList<String> sequence) {
			ArrayList<String> sequence2 = new ArrayList<String>();
			while (true) {
		    	try {
				    if (sequence.get(0).matches("[+\\-*/]") && sequence.get(1).matches("[+\\-*/]")) {
				    	throw new IllegalArgumentException();
				    } else if (sequence.get(0).matches("[VXILCDM]")) 
				    	sequence2.add(sequence.remove(0));
				    else if (sequence.get(0).matches("[+\\-*/]")) break;
		    	}  catch (java.lang.IndexOutOfBoundsException e) 
		    		{String res = String.join("", sequence2);
		    		int j = RomansTranslation(res);
		    		String numberAsString = String.valueOf(j);
			        return numberAsString; }
		   }String res = String.join("", sequence2);
			int j = RomansTranslation(res);
			String numberAsString = String.valueOf(j);
			return numberAsString; 
		}
		
		static int RomansTranslation(String h) {
			int res = 0; 
			for (int i=0; i<h.length(); i++) 
			{ 
				int s1 = romansNumeralsList(h.charAt(i)); 
				if (i+1 <h.length()) 
					{ 
					int s2 = romansNumeralsList(h.charAt(i+1));  
						if (s1 >= s2) 
						{res = res + s1;} 
						else
						{res = res + s2 - s1; i++;} 
					} 
				else
				{res = res + s1; i++;} 
			}
			return res; 
		}

		static String intToRoman(int num) {

		    StringBuilder roman = new StringBuilder("");
		    for (Integer i: map.keySet()) {
		        for (int j = 1; j <= num / i; j++) {
		            roman.append(map.get(i));
		        }
		        num %= i;
		    }
		    return roman.toString();
		}
		
		static ArrayList<String> listSplit(ArrayList<String> sequence) {
			ArrayList<String> sequence2 = new ArrayList<String>();
			String res = String.join("", sequence);
			char[] inputChars = res.toCharArray();
			for (char c : inputChars) {    
		        	sequence2.add("" + c);
		        }
			return sequence2;
	    } 
			
}


