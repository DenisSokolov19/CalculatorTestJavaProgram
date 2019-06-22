import java.util.Scanner;

public class Calculation {
	static int ValuesList(char c) { 
		if (c == 'I') return 1; 
		if (c == 'V') return 5; 
		if (c == 'X') return 10; 
		if (c == 'L') return 50; 
		if (c == 'C') return 100; 
		if (c == 'D') return 500; 
		if (c == 'M') return 1000; 
		return 0;}
	
	/*������� WhichOperand ���������� ������� NumbersCalculating � RomansToArabic
	 *��� ����������� ����, ��� ����� ������ � ������� ������� ��� �������� �� ������,
	 *��������� �� ������ Main
	 */
	
	static String WhichOperand (String f) {
		Scanner input = new Scanner(f);
		input.useDelimiter("[a-zA-Z0-9]+"); 
		// ���������� �������� ���� ���� � �����. ������� ������ ������ ��������
		String o = input.next();
		input.close();
		return o;
	}
	
	public int NumbersCalculating(String u) {
		int op1, op2;
		int res = 0;
		Scanner input = new Scanner(u);
		input.useDelimiter("[^0-9]+");
		// ���������� ���������� ������ � ����� ��� ��������� �������. 
		// ������ ����������� �� 2 ������ � ��������� ������������ � 2 ����������.
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
		
	public int RomansToArabic(String u) { 
		String o = WhichOperand(u);
		int res = 0;
		Scanner input = new Scanner(u);
		input.useDelimiter("[^VXILCDM]+");
		// ���������� ���������� ������ � ����� ��� ��������� �������. 
		// ������ ����������� �� 2 ������ � ��������� ������������ � 2 ����������.
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
		return res;	
	}
	
	/* ���� ������, �������� ������� ���� -->> �������� 
	 * ��� �������� ����� � ���������.
	 */
	static int RomansTranslation(String h) {
		int res = 0; 
		for (int i=0; i<h.length(); i++) 
		{ 
			int s1 = ValuesList(h.charAt(i)); 
			if (i+1 <h.length()) 
				{ 
				int s2 = ValuesList(h.charAt(i+1));  
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
}

