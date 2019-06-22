import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class Calculation {
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
	
	/*ћетодом WhichOperand пользуютс€ функции NumbersCalculating и RomansToArabic
	 *дл€ определени€ того, что нужно делать с числами которые они извлекли из строки,
	 *полученой из класса Main
	 */
	
	static String WhichOperand (String f) {
		Scanner input = new Scanner(f);
		input.useDelimiter("[a-zA-Z0-9]+"); 
		// ѕроисходит удаление всех букв и чисел. ќстаЄтс€ только символ операнда
		String o = input.next();
		input.close();
		return o;
	}
	
	public int NumbersCalculating(String u) {
		int op1, op2;
		int res = 0;
		Scanner input = new Scanner(u);
		input.useDelimiter("[^0-9]+");
		// ѕроисходит разделение строки в месте где находитс€ операнд. 
		// —трока раздел€етс€ на 2 токена и поочереди записываетс€ в 2 переменные.
		op1 = input.nextInt();
		op2 = input.nextInt();
		String o = WhichOperand(u);
		switches:
		{
		switch (o) {
			case("/"):
				res = op1 / op2;
				input.close();
				break switches;
			case("*"):
				res = op1 * op2;
				input.close();
				break switches ;
			case("+"):
				res = op1 + op2;
				input.close();	
				break switches;
			case("-"):
				res = op1 - op2;
				input.close();
				break switches;
			}		
		}
		return res;	
	}
		
	public String RomansToArabic(String u) { 
		String o = WhichOperand(u);
		int res = 0;
		String pp;
		Scanner input = new Scanner(u);
		input.useDelimiter("[^VXILCDM]+");
		// ѕроисходит разделение строки в месте где находитс€ операнд. 
		// —трока раздел€етс€ на 2 токена и поочереди записываетс€ в 2 переменные.
		String op1 = input.next();
		String op2 = input.next();	
		int num1 = RomansTranslation(op1);
		int num2 = RomansTranslation(op2);
		input.close();
		switches:
		{
		switch (o) {
			case("/"):
				res = num1 / num2;
				break switches;
			case("*"):
				res = num1 * num2;
				break switches ;
			case("+"):
				res = num1 + num2;
				break switches;
			case("-"):
				res = num1 - num2;
				break switches;
			}		
		}
		pp = intToRoman(res);
		return pp;	
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
}

