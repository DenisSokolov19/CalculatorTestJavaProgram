import java.util.Scanner;

public class Validation {	
	public boolean quit (String s) {
		Scanner input = new Scanner(s);
		while(input.hasNextLine()){		
				String str = input.findInLine("exit");
				if(str != null) {input.close(); return true;}
				else break;
		}
		input.close();
		return false;	
	}
	public boolean LettersValidation (String s) {
		Scanner input = new Scanner(s);
		while(input.hasNextLine()){		
				String str = input.findInLine("[a-zA-Z&&[^VXILCDM]]");
				String str2 = input.findInLine("\\p{InCyrillic}");
				if(str != null || str2 != null) {input.close(); return true;}
				else break;
		}
		input.close();
		return false;	
	}
	public boolean NumbersValidation (String s) {
		Scanner input = new Scanner(s);
		while(input.hasNextLine()){		
				String str = input.findInLine("[1-9]");
				if(str != null) {input.close(); return true;}
				else break;
		}
		input.close();
		return false;	
	}
	public boolean RomansValidation (String s) {
		Scanner input = new Scanner(s);
		while(input.hasNextLine()){		
				String str = input.findInLine("[VXILCDM]");
				if(str != null) {input.close(); return true;}
				else break;
		}
		input.close();
		return false;	
	}
	public boolean OperandsValidation (String s) {
		/*В отличии от букв и цифр, задача поиска операндов  
		 *методами regex оказалась сложно-реализуемой.
		 */
		if (s.contains("-") || s.contains("+")
				|| s.contains("*") || s.contains("/")) {
			return true;
	    }
		return false;	
	}
}

