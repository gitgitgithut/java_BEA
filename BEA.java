import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BEA {
	
	private static String filePath[];
	
	public static void main(String[] arg) {
		filePath = new String[7];
		filePath[0] = "D:\\Files\\Queen's\\Fourth Year\\CMPE 365\\Lab 1\\es1.csv";
		filePath[1] = "D:\\Files\\Queen's\\Fourth Year\\CMPE 365\\Lab 1\\es2.csv";
		filePath[2] = "D:\\Files\\Queen's\\Fourth Year\\CMPE 365\\Lab 1\\es3.csv";
		filePath[3] = "D:\\Files\\Queen's\\Fourth Year\\CMPE 365\\Lab 1\\us1.csv";
		filePath[4] = "D:\\Files\\Queen's\\Fourth Year\\CMPE 365\\Lab 1\\us2.csv";
		filePath[5] = "D:\\Files\\Queen's\\Fourth Year\\CMPE 365\\Lab 1\\us3.csv";
		filePath[6] = "D:\\Files\\Queen's\\Fourth Year\\CMPE 365\\Lab 1\\us4.csv";
		int i;
		System.out.printf("Using the Basic Best Employee Algorithm:\n");
		for (i = 0; i < filePath.length; i++) {
			String data[] = readFile(filePath[i]);
			basicBEA(data);
		}
		System.out.printf("\nUsing the improved Best Employee Algorithm:\n");
		for (i = 0; i < filePath.length; i++) {
			String data[] = readFile(filePath[i]);
			improvedBEA(data);
		}
	}
	
	private static String[] readFile(String filePath) {
		String readLine = "";
		String[] list = new String[1000];
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
			readLine = br.readLine();
			list = readLine.split(","); 
		}catch(IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private static void basicBEA(String data[]) {
		float max = -1;
		int i, pos = 0;
		for (i = 0; i < data.length; i++) {
			float score = (float) Float.parseFloat(data[i]);
			if (score > max) {
				max = score;
				pos = i;
			}
		}
		System.out.printf("You should hire the " + (pos + 1) + " person who has score of " + max + "\n");
	}
	
	private static void improvedBEA(String data[]) {
		float score, max = -1;
		int i, pos = 0, interview = (int) (data.length/Math.E);
		for (i = 0; i < interview; i++) {
			score = (float) Float.parseFloat(data[i]);
			if (score > max) { 
				max = score;
				pos = i;
			}
		}
		i = interview;
		while (i < data.length) {
			score = (float) Float.parseFloat(data[i]);
			if (score > max) {
				System.out.printf("You should hire the " + (i + 1) + " person who has score of " + max + "\n");
				return;
			}
			else
				i++;
		}
		System.out.printf("You should hire the " + (pos + 1) + " person who has score of " + max + "\n");
	}
}
