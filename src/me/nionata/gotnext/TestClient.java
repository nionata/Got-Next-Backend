package me.nionata.gotnext;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {
	
	public static void main(String args[]) throws Exception {
		run();
	}
	
	public static void run() throws Exception {
		Scanner consoleIn = new Scanner(System.in);
		Socket socket = new Socket("localhost", 1291);
		Scanner sockIn = new Scanner(socket.getInputStream());
		PrintStream sockOut = new PrintStream(socket.getOutputStream());
		
		int number;
		do {
			System.out.print("Enter any number: ");
			number = consoleIn.nextInt();
			sockOut.println(number);
			
			int temp = sockIn.nextInt();
			System.out.println(temp + "\n");
		} while (number != 0);
		
		consoleIn.close();
		socket.close();
		sockIn.close();
	}

}
