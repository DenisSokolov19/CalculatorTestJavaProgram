/* Здравствуйте!
 * Это моя первая программа. Мне очень понравилось её создавать.
 * Она состоит из 3 файлов в которых выполняются разные методы: 
 * главный файл, проверки и расчёты.
 * Ознакомившись с задачей, я посчитал что более правильным будет 
 * не прекращать работу, выбросив исключение, если пользователь ввёл что-то не то, 
 * а вывести на экран сообщение об ошибке и продолжить заново.
 * Реализовать эту функцию я решил при помощи проверки введёной 
 * пользователем строки по 4 критериям: 
 * 1) Есть ли в ней буквы латиницы или кириллицы.
 * 2) Есть ли в ней числа.
 * 3) Римские цифры и 4) Операнды
 * Также реализована функция выхода из программы, если пользователь напишет ключевое слово.
 * Проверка осуществляется методом класса Scanner - findInLine и регулярными выражениями. 
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
			//Кстати, много где написано, что сканер через System.in закрывать не надо. 
			String i = inputLine.nextLine();
			boolean isThereANumbers = v.NumbersValidation(i);
			boolean isThereALetters = v.LettersValidation(i);
			boolean isThereARomans = v.RomansValidation(i);
			boolean isThereAOperands = v.OperandsValidation(i);
			boolean exit = v.quit(i);
			if (exit) Runtime.getRuntime().exit(0);
			System.out.println("************");
			
			/*Далее идёт блок где на основе 4 критериев программа решает,
			*допустил ли пользователь ошибку при вводе данных или нет.
			*Если данные верны, то строка минует проверку, ведь мы уже
			*знаем что в строке нет ничего лишнего, и посылается в класс Calculation,
			*где происходит подсчёт и возврат результата. 
			*/
			
			finished:
			{
				if (isThereALetters) 
				{System.out.println("Буквы недопустимы!" + "\n"); break finished; } 
				else if (isThereARomans && isThereANumbers)
				{System.out.println("Сочетание арабских и римских цифр недопустимо!" + "\n"); break finished; }
				else if (isThereANumbers && isThereAOperands)
				{int p = c.NumbersCalculating(i); System.out.println(p + "\n");}
				else if (isThereARomans && isThereAOperands)
				{int p = c.RomansToArabic(i); System.out.println(p + "\n");}
			}
		} while(true); //Программа работает по кругу, до тех пор пока пользователь не введёт слово 'exit'
	}
		
	private static void welcome() {
		System.out.println("Здравствуйте, " + 
				"эта программа работает с целыми римскими и арабскими цифрами.\n" +
				"К подсчёту допускаются только первые 2 переменные, будьте внимательны.\n" +
				"Буквы недопустимы.\n\n" +
				"Для выхода из программы наберите 'exit' на клавиатуре.\n");}
}