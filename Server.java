package finalproject;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server 
{
	public static final int port = 9666;

	public static void main(String args[]) throws IOException
	{
		 	InetAddress ip;
	        String hostname;
	        try {
	            ip = InetAddress.getLocalHost();
	            hostname = ip.getHostName();
	            System.out.println("Your current IP address : " + ip);
	            System.out.println("Your current Hostname : " + hostname);
	 
	        } catch (UnknownHostException e) {
	 
	            e.printStackTrace();
	        }
	        
		new Server().runServer();
	}
	public void runServer() throws IOException
	{
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Server up and ready for connections.");
		while(true)
		{
			Socket sock = serverSocket.accept();
			new ServerThread(sock).start();
		}
	}

}
