package me.nionata.gotnext;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestClient {
	
	public static void main(String args[]) {
		Scanner consoleIn = new Scanner(System.in);
		Socket sock;
		Scanner sockIn;
		PrintStream p;
		
		try {
			sock = new Socket("localhost", 1291);
			sockIn = new Scanner(sock.getInputStream());
			p = new PrintStream(sock.getOutputStream());
			
			System.out.println("Enter any number");
			int number = consoleIn.nextInt();

			p.println(number);
			int temp = sockIn.nextInt();
			System.out.println(temp);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		consoleIn.close();
	}

}
