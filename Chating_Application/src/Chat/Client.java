package Chat;

import java.net.*;
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
			socket = new Socket("localhost",8000); 
			System.out.println("Connection Done...");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			startReading();
			startWriting();
		}
		catch (Exception e) 
		{
			
		}
	}
	
	
	public void startReading()
	{
		Runnable r1 = () -> {
			System.out.println("Reading Started...");
			try 
			{
				while(true)
				{
					String msg = br.readLine();
					
					if(msg.equals("Exit"))
					{
						System.out.println("Server Terminated The Chat");
						break;
					}
					
					System.out.println("Server : " + msg);
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
		Runnable r2 = () -> {
			System.out.println("Writing Started...");
			
			try 
			{
				while(true && !socket.isClosed())
				{
					BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
					
					String content = br1.readLine();
					out.println(content);
					out.flush();
					
					if(content.equals("Exit"))
					{
						socket.close();
						break;
					}
					
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}	
		};
		
		new Thread(r2).start();
	}
	
	
	public static void main(String[] args) 
	{
		System.out.println("This is Client...");
		new Client();
		
	}

}
