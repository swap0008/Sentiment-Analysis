import java.io.*;
import java.util.Scanner;

class stringSearch extends Thread {
	String threadName;
	static String line, words[];
	static float posCount = 0;
	static float negCount = 0;

	stringSearch() {}

	stringSearch(String name) {
		threadName = name;
	}

	public void run() {
		int i;
		for(i=0; i<words.length; i++) {
			if(threadName.equals("A")) {
				try {
					BufferedReader br = new BufferedReader(new FileReader("pos.txt"));
					while(true) {
					if(br.readLine().equals(words[i])) {
							posCount++;
						}
					}
				} catch(Exception e) {

				}
			} 
			if(threadName.equals("B")) {
				try {
					BufferedReader br = new BufferedReader(new FileReader("neg.txt"));
					while(true) {
						if(br.readLine().equals(words[i])) {
							negCount++;
						}
					}
				} catch(Exception e) {

				}
			} 
		}		
		if(threadName.equals("B")) {
			System.out.println("Postive: " + (posCount/(posCount + negCount))*100 + "%\nNegative: " + (negCount/(posCount + negCount))*100 + "%");
		}	
	}

	void set() {
		stringSearch A = new stringSearch("A");
		stringSearch B = new stringSearch("B");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String or Line:");
		line = sc.nextLine();
		words = line.replace(".","").toLowerCase().split("\\s+");
		A.start();
		B.start();
	}
}