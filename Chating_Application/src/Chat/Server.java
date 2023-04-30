package Chat;

import java.net.*;
import java.io.*;

public class Server 
{
	ServerSocket server;
	Socket socket;
	
	BufferedReader br;
	PrintWriter out;
	
	public Server() 
	{
		try
		{
			server = new ServerSocket(8000);
			System.out.println("Server is ready to accept to connection");
			System.out.println("Waiting...");
			socket = server.accept();
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			startReading();
			startWriting();
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void startReading()
	{
		// Reading Thread...
		
		// Lembda Expretion
		
			Runnable r1 = () -> {
				System.out.println("Reading Started...");
				try 
				{
					while(true)
					{
						String msg = br.readLine();
						
						if(msg.equals("Exit"))
						{
							System.out.println("Client Terminated The Chat");
							break;
						}
						
						System.out.println("Client : " + msg);
					}
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
			};
			new Thread(r1).start();
	}
	
	public void startWriting()
	{
		// Writing Thread...
		
		// Lembda Expretion
		
			Runnable r2 = () -> {
				System.out.println("Writing Started...");
				
				try 
				{
					while(true)
					{
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						
						String content = br1.readLine();
						out.println(content);
						out.flush();
						
					}
				} catch (Exception e)
				{
					e.printStackTrace();
				}	
			};
			
			new Thread(r2).start();
	}
	
	public static void main(String[] args) {
		System.out.println("This is Server... Going to Start Server");
		new Server();
	}
}
 