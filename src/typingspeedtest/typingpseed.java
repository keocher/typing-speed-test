package typingspeedtest;
import java.util.Scanner;

public class typingpseed {
	//global scanner
	private static final Scanner scan = new Scanner(System.in);
	
	//main method
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
	
	//method to clear console
	public static void clearConsole() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}

	//method to start the test
	public static void startTest() {
		String[] phrases = {
				"please give me a job i will be so happy",
				"i really think i would fit in with your team",
				"if i am bad i will pay you ten grand",
				"i dont mean that i just need ten word sentences",
				"but i do mean the job part please please please"
			};
		
		//variables
		String[] input = new String[5];
		double[] timeTaken = new double[5];
		Result results[] = new Result[5];
		
		//test loop
		for(int i=0;i<5;i++) {
			System.out.println("Phrase " + (i+1) + ": " + phrases[i]);
			System.out.println("----------------------******----------------------");
			long startTime = System.currentTimeMillis();
			input[i] = scan.nextLine();
			long endTime = System.currentTimeMillis();
			timeTaken[i] = (double)(endTime - startTime)/1000;
			results[i] = new Result(timeTaken[i], calculateWPM(timeTaken[i]), calculateAccuracy(phrases[i], input[i]));
			clearConsole();
		}
		
		//test complete message
		String complete = "------------------TEST COMPLETE!------------------";char[] completeChars = complete.toCharArray();
		for(int i=0;i<completeChars.length;i++) {
		
			try {
				System.out.print(completeChars[i]);
		        Thread.sleep(50); 
		    } catch (InterruptedException e) {
		        Thread.currentThread().interrupt();
		    }
		
		}
		clearConsole();
		
		//results
		System.out.println("Here are your results:");
		
		for (int i=0;i<5;i++) {
			System.out.println("Phrase " + (i+1) + ": ");
			System.out.println("Time: " + String.format("%.2f", results[i].getTime()) + " seconds");
			System.out.println("WPM: " + results[i].getWpm());
			System.out.println("Accuracy: " + results[i].getAccuracy() + "%");
			System.out.println("----------------------******----------------------");
		}
		
		//average
		Result average = getAverage(results);
		System.out.println("Average: ");
		System.out.println("Time: " + String.format("%.2f", average.getTime())
		 + " seconds");
		System.out.println("WPM: " + average.getWpm());
		System.out.println("Accuracy: " + average.getAccuracy() + "%");
		System.out.println("----------------------******----------------------");
		
		
	
	}
	
		public static int calculateWPM(double time) {
			 int words = 10; // or count words dynamically
			 double timeMinutes = time / 60.0;
			 return (int) (words / timeMinutes);
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
		
		public static Result getAverage(Result[] results) {
			double totalTime =0 ;
			int totalWpm=0;
			int totalAccuracy=0;
			
			for (int i=0;i<5;i++) {
				totalTime += results[i].getTime();
				totalWpm += results[i].getWpm();
				totalAccuracy += results[i].getAccuracy();
			}
			
			double avgTime = totalTime/5;
			int avgWpm = totalWpm/5;
			int avgAccuracy = totalAccuracy/5;
			return new Result(avgTime, avgWpm, avgAccuracy);
			
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