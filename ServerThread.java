package finalproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread 
{
	
		Socket sock;
		ServerThread(Socket sock)
		{
			this.sock = sock;
		}
		public void run()
		{
			try 
			{
				String message = null;
				PrintWriter printWriter = new PrintWriter(sock.getOutputStream(),true);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				String messageInput= bufferedReader.readLine();
				System.out.println("User "+messageInput +" is now connected to the server.");
				while((message = bufferedReader.readLine())!= null)
				{
					System.out.println("Incoming client message is " + message);
					//printWriter.println("Server echoing client -> -> " + message);
					String messageOutput = null;
					New_Database db= new New_Database();
					messageOutput = db.movies(message);
					printWriter.println(messageOutput);
				}
				sock.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}


}
