package FiveQuestions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*

3) Create method to remove specific lines from file,method signature as per follows
--> private static void removeLine(filePath,1,5,7); // 1,5,7 lines remove from file
*
*
*OUTPUT::--
*	org file:ABC.txt
*		Line 1
		Line 2
		Line 3
		Line 4
		Line 5
		Line 6
		Line 7
		Line 8
		Line 9
		Line 10


*	Line renoved File:XYZ.txt
*		Line 2
		Line 3
		Line 4
		Line 6
		Line 8
		Line 9
		Line 10

*/
public class Q3 {
 
	private static void createFile() throws IOException {
		File f = new File("ABC.txt");
	
		BufferedWriter bw = new BufferedWriter(new FileWriter("ABC.txt"));
		for(int i =1 ;i<=10;i++)
		{
		bw.write("Line " +i);	
		bw.newLine();
		}
		bw.close();
	}
	
	private static void removeLine(String filePath,int l1, int l2,int l3) throws IOException {
		File f = new File("XYZ.txt");
		f.createNewFile();

		BufferedReader br = new BufferedReader(new FileReader("ABC.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("XYZ.txt"));
		String line;
		int lineNo =0;
		while ((line = br.readLine()) != null) {
			lineNo++;
			
			if((lineNo == l1)||(lineNo == l2)||(lineNo == l3)) {continue; }
			bw.write(line);
			bw.newLine();

		}
		br.close();
		bw.close();
		
	}
	
	public static void main(String[] args)  {
		try {
			Q3.createFile();
			Q3.removeLine("ABC.txt", 1, 5, 7);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
