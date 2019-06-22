/* ������������!
 * ��� ��� ������ ���������. ��� ����� ����������� � ���������.
 * ��� ������� �� 3 ������ � ������� ����������� ������ ������: 
 * ������� ����, �������� � �������.
 * ������������� � �������, � �������� ��� ����� ���������� ����� 
 * �� ���������� ������, �������� ����������, ���� ������������ ��� ���-�� �� ��, 
 * � ������� �� ����� ��������� �� ������ � ���������� ������.
 * ����������� ��� ������� � ����� ��� ������ �������� ������� 
 * ������������� ������ �� 4 ���������: 
 * 1) ���� �� � ��� ����� �������� ��� ���������.
 * 2) ���� �� � ��� �����.
 * 3) ������� ����� � 4) ��������
 * ����� ����������� ������� ������ �� ���������, ���� ������������ ������� �������� �����.
 * �������� �������������� ������� ������ Scanner - findInLine � ����������� �����������. 
 */


import java.io.IOException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws IOException {
		welcome();
		do {
			Validation v = new Validation();
			Calculation c = new Calculation();
			Scanner inputLine = new Scanner(System.in);
			//������, ����� ��� ��������, ��� ������ ����� System.in ��������� �� ����. 
			String i = inputLine.nextLine();
			boolean isThereANumbers = v.NumbersValidation(i);
			boolean isThereALetters = v.LettersValidation(i);
			boolean isThereARomans = v.RomansValidation(i);
			boolean isThereAOperands = v.OperandsValidation(i);
			boolean exit = v.quit(i);
			if (exit) Runtime.getRuntime().exit(0);
			System.out.println("************");
			
			/*����� ��� ���� ��� �� ������ 4 ��������� ��������� ������,
			*�������� �� ������������ ������ ��� ����� ������ ��� ���.
			*���� ������ �����, �� ������ ������ ��������, ���� �� ���
			*����� ��� � ������ ��� ������ �������, � ���������� � ����� Calculation,
			*��� ���������� ������� � ������� ����������. 
			*/
			
			finished:
			{
				if (isThereALetters) 
				{System.out.println("����� �����������!" + "\n"); break finished; } 
				else if (isThereARomans && isThereANumbers)
				{System.out.println("��������� �������� � ������� ���� �����������!" + "\n"); break finished; }
				else if (isThereANumbers && isThereAOperands)
				{int p = c.NumbersCalculating(i); System.out.println(p + "\n");}
				else if (isThereARomans && isThereAOperands)
				{int p = c.RomansToArabic(i); System.out.println(p + "\n");}
			}
		} while(true); //��������� �������� �� �����, �� ��� ��� ���� ������������ �� ����� ����� 'exit'
	}
		
	private static void welcome() {
		System.out.println("������������, " + 
				"��� ��������� �������� � ������ �������� � ��������� �������.\n" +
				"� �������� ����������� ������ ������ 2 ����������, ������ �����������.\n" +
				"����� �����������.\n\n" +
				"��� ������ �� ��������� �������� 'exit' �� ����������.\n");}
}