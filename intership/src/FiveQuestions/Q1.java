package FiveQuestions;

import java.io.*;
import java.util.*;

/*
 * 1) Logging User Input to a File: Capture user inputs from System.in continuously
 *  and log them to a file using PrintWriter. Include timestamps for each input.

  */
public class Q1 {
	
	public static void input() throws Exception {
		String str;
		Scanner sc = new Scanner(System.in);
		BufferedWriter writer = new BufferedWriter(new FileWriter("XYZ.txt"));
		
		System.out.println("Enter file text (Exit for leave) :");
		do {
			str=sc.nextLine();
			String time = new Date().toString();
			
			if(str.equalsIgnoreCase("Exit"))
			{
				break;
			}else {
				writer.write("["+time+"]"+str);
				writer.newLine();
					
			}
			
		}while(true);
		writer.close();
		sc.close();
	}
	
public static void main(String[] args) {
	try {
		Q1.input();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
