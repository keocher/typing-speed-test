package typingspeedtest;
import java.util.Scanner;

public class typingpseed {
	 private static final Scanner scan = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		
		System.out.println("----------Welcome to the Typing Speed Test!!----------");
		System.out.println("You will be given 5 phrases to type as fast as you can");
		System.out.println("----------------------Good Luck!----------------------");
		System.out.println("");
		
		System.out.println("Press enter to start");
		scan.nextLine();
		clearConsole();
		startTest();		
		
	}
	public static void clearConsole() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
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
		long[] timeTaken = new long[5];
		
		for(int i=0;i<5;i++) {
		System.out.println("Phrase " + (i+1) + ": " + phrases[i]);
		System.out.println("----------------------******----------------------");
		long startTime = System.currentTimeMillis();
		input[i] = scan.nextLine();
		long endTime = System.currentTimeMillis();
		timeTaken[i] = endTime - startTime;
		clearConsole();
		}
		
		for(int i=0;i<5;i++) {
			System.out.println("Phrase " + (i+1) + ": " + phrases[i]);
			System.out.println("You typed: " + input[i]);
			System.out.println("Time taken: " + timeTaken[i]/1000.0 + " seconds");
			System.out.println("----------------------******----------------------");
		}
	

	
	}
}
