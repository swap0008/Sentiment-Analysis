import java.util.Scanner;

class sentAnalysis {
	String threadName;

	public static void main(String argc[]) {
		int opt;
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose Option: 1) Enter Line 2) Text File");
		opt = sc.nextInt();
		stringSearch ss = new stringSearch();
		fileSearch fs = new fileSearch();
		if(opt == 1) {
			ss.set();
		} else if(opt == 2) {
			fs.set();
		}
	}
}