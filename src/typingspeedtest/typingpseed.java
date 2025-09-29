package typingspeedtest;
import java.util.Scanner;

public class typingpseed {
	 private static final Scanner scan = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		
		System.out.println("----------Welcome to the Typing Speed Test!!----------");
		System.out.println("You will be given 5 phrases to type as fast as you can");
		System.out.println("----------------------Good Luck!----------------------");
		System.out.println("");
		
		System.out.println("Press '.' to start");
		if (scan.nextLine().equals(".")) {
			clearConsole();
			startTest();
		}
		
		
		
		
		
		
		
		
	}
	public static void clearConsole() {
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	}
	
	public static void startTest() {
		String[] phrases = {
				"please give me a job",
				"i really want money",
				"I promise to work as hard as I can",
				"I will never ever let you down",
				"Thank you for your time"
			};
		String[] input = new String[5];
		
		input[0] = scan.nextLine();
		
	}
	
}
