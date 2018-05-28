package me.nionata.gotnext;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	public static void main(String args[]) throws Exception {
		run();
	}
	
	public static void run() throws Exception {
		//Initializes the port the socket server will be on
		ServerSocket serverSocket = new ServerSocket(1291);
		System.out.println("The server is waiting for a client on port " + serverSocket.getLocalPort());
		
		//Accepts the connection for the client socket
		Socket socket = serverSocket.accept();
		System.out.println("Client connected on port " + socket.getLocalPort());
	
		Scanner sockIn = new Scanner(socket.getInputStream());
		PrintStream sockOut = new PrintStream(socket.getOutputStream());
		
		int number;
		do {
			number = sockIn.nextInt();
			int temp = number * 2;
			sockOut.println(temp);
			System.out.println("New input from client: " + number + "\nReturning: " + temp);
		} while(number != 0);
		
		serverSocket.close();
		sockIn.close();
	}

}
