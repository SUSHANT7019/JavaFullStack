package FiveQuestions;

import java.util.Scanner;

/*
2) Multi-Threaded Console Chat: Create a multi-threaded console-based chat where 
one thread reads user input and another thread prints simulated chatbot responses.

*
*/
class ThreadExample{
	String str;

	Scanner sc = new Scanner(System.in);
	public synchronized void get() {
		System.out.print("You : ");
		str= sc.nextLine();
		
	}
	public synchronized void put() {
		System.out.println("Bot : "+ str);
	}
}

public class Q2 {
public static void main(String[] args) {
	ThreadExample obj= new ThreadExample();

	Runnable read =()->obj.get();
	Runnable write =()->obj.put();
	
	Thread t1 =new Thread(read ,"Read");
	Thread t2 =new Thread(write ,"Write");
	
		t1.start();
		t2.start();	
	
}
}
