import java.io.*;
import java.util.Scanner;

class fileSearch {
	String objectName;
	static String fName;
	static float posCount = 0;
	static float negCount = 0;
	static int totalCount = 0;

	fileSearch() {}

	fileSearch(String name) {
		objectName = name;
	}

	void search(String[] words) {
		int i;
		for(i=0; i<words.length; i++) {
			totalCount++;
			if(objectName.equals("A")) {
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
			if(objectName.equals("B")) {
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
	}

	void set() {
		fileSearch A = new fileSearch("A");
		fileSearch B = new fileSearch("B"); 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Text File Name With Path: ");
		fName = sc.nextLine();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fName));
			while(true) {
			     String[] words = br.readLine().replace(".","").toLowerCase().split("\\s+");
			     A.search(words);
			     B.search(words);
			}
		} catch(Exception e) {}
		System.out.println("Total Words: " + totalCount + " Postive Words: " + posCount + " Negative Words: " + negCount);
		System.out.println("Postive: " + (posCount/(posCount + negCount))*100 + "%\nNegative Words: " + (negCount/(posCount + negCount))*100 + "%");
	}
}