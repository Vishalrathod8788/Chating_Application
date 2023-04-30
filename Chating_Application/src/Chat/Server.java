package Chat;

import java.net.*;
import java.io.*;

public class Server 
{
	ServerSocket server;
	Socket socket;
	public Server() 
	{
		try
		{
			server = new ServerSocket(7777);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("This is Server... Going to Start Server");
		new Server();
	}
}
 