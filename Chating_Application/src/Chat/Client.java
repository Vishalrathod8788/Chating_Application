package Chat;

import java.net.Socket;
import java.io.*;

public class Client {
	
	Socket socket;
	
	BufferedReader br;
	PrintWriter out;
	
	public Client() 
	{
		try 
		{
			System.out.println("Sending Request To Sever...");
			socket = new Socket("127.0.0.1",7777); 
			System.out.println("Waiting...");
		}
		catch (Exception e) 
		{
		
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("This is Client...");
	}

}
