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
				"please give me a job i will be so happy",
				"i really think i would fit in with your team",
				"if i am bad i will pay you ten grand",
				"i dont mean that i just need ten word sentences",
				"but i do mean the job part please please please"
			};
		String[] input = new String[5];
		long[] timeTaken = new long[5];
		Result results[] = new Result[5];
		
		for(int i=0;i<5;i++) {
		System.out.println("Phrase " + (i+1) + ": " + phrases[i]);
		System.out.println("----------------------******----------------------");
		long startTime = System.currentTimeMillis();
		input[i] = scan.nextLine();
		long endTime = System.currentTimeMillis();
		timeTaken[i] = endTime - startTime;
		results[i] = new Result((double)timeTaken[i]/1000, calculateWPM(timeTaken[i]), calculateAccuracy(phrases[i], input[i]));
		clearConsole();
		}
		
		System.out.println("TEST COMPLETE!");
		
	
	}
	
		public static int calculateWPM(long time) {
			int wpm = (int) (time/10000)*60;
			return wpm;
		}
		
		public static int calculateAccuracy(String phrase, String input) {
			char[] phraseChars = phrase.toCharArray();
			char[] inputChars = input.toCharArray();
			int correctChars = 0;
			
			for(int i=0;i<phraseChars.length && i<inputChars.length;i++) {
				if(phraseChars[i] == inputChars[i]) {
					correctChars++;
				}
			}
			int accuracy = (int) ((double)correctChars/phraseChars.length*100);
			return accuracy;
		}
		
		static class Result{
			
			double time=0;
			int wpm=0;
			int accuracy=0;
			
			public Result(double time, int wpm, int accuracy) {
				this.time = time;
				this.wpm = wpm;
				this.accuracy = accuracy;			
			}
			
			public double getTime() {
				return this.time;
			}
			public int getWpm() {
				return this.wpm;
			}
			public int getAccuracy() {
				return this.accuracy;
			}
			public void setTime(double time) {
				this.time = time;
			}
			public void setWpm(int wpm) {
				this.wpm = wpm;
			}
			public void setAccuracy(int accuracy) {
				this.accuracy = accuracy;
			}
			
			
		}
}