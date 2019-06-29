import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws Exception {
		welcome();
		do {
			Parsing p = new Parsing();
			Scanner inputLine = new Scanner(System.in);
			String i = inputLine.nextLine();
			boolean exit = p.exit(i);
			if (exit) Runtime.getRuntime().exit(0);
			String n = p.parser(i);
			System.out.println("************");
			System.out.println(n + "\n\n");
		} while(true); }
	
		
	private static void welcome() {
		System.out.println("Здравствуйте, " + 
				"эта программа работает с целыми римскими и арабскими цифрами.\n" +
				"Буквы недопустимы.\n\n" +
				"Для выхода из программы наберите 'exit' на клавиатуре.\n");}
}