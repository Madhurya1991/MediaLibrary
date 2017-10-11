package finalproject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test_VLC_Player {

	static Robot robot;
	public static void main(String[] args) throws IOException, AWTException
	{
		 robot = new Robot();
		try
		{
			InetAddress PlayerIP = InetAddress.getLocalHost();
			//String PlayerName = PlayerIP.getHostName();
			
			int PlayerPort = 10000;
			System.out.println("Renderer started at IPAddress: " +PlayerIP+ " and port number: " +PlayerPort+ "...waiting for controller...");
			String WebServerIP = "10.21.75.234"; // Hardcode the IP address here
			int WebServerPort = 8080; // Default Port Number used by Mongoose Server
			System.out.println("Connecting to Web Server started at IPAddress: " +WebServerIP+ " and port number: " +WebServerPort);

			//Socket Connection Logic
			for(;;)
			{
				try (ServerSocket serverSocket = new ServerSocket(PlayerPort)) 
				{
					Socket socket = serverSocket.accept();
					System.out.println("Controller connected...");
					BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String messageInput= bufferedReader.readLine();
					System.out.println("The following URL is received from client:"+messageInput);
					System.out.println("Requesting media server...");
					if (messageInput.equals("pause"))
					{
						go_pause();

					}
					else if (messageInput.equals("play"))
					{
						go_play();

					}
					else if (messageInput.equals("stop"))
					{
						go_stop();

					}
					else if (messageInput.equals("forward"))
					{
						go_forward();

					}
					else if (messageInput.equals("reverse"))
					{
						go_reverse();

					}
					else if (!messageInput.equals("play") ||!messageInput.equals("pause")||!messageInput.equals("stop")||!messageInput.equals("forward")||!messageInput.equals("reverse"))
					{

						String VLCplayer ="C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe \"http://"; //127.0.0.1:8080/Blue%20-%20All%20Rise%20(2).mp4";
						messageInput = messageInput.trim().replaceAll(" ","%20");
						String PlayerPath = VLCplayer + WebServerIP + ":" + WebServerPort + "/" + messageInput;
						Runtime rt = Runtime.getRuntime();
						rt.exec(PlayerPath);
					}
				}
			}
		}
		catch(IllegalArgumentException e1)
		{
			System.err.println("Use: java Renderer <Local IPAddress> <Localport> <Remote IPAddress> <Remote Port>");
		}

	}

	//Robot Class to control VLC Player - play, pause, stop, forward, rewind 
	
	private static void go_pause()throws AWTException 
	{ //To change body of generated methods, choose Tools | Templates.
		try{
			

			robot.keyPress(KeyEvent.VK_SPACE);
			robot.keyRelease(KeyEvent.VK_SPACE);
		}
		catch(IllegalArgumentException e1) {
			System.err.println("Use: java Renderer <Local IPAddress> <Localport> <Remote IPAddress> <Remote Port>");
		}

	}
	private static void go_play()throws AWTException { //To change body of generated methods, choose Tools | Templates.
		try{
			//Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_SPACE);
			robot.keyRelease(KeyEvent.VK_SPACE);
		}
		catch(IllegalArgumentException e1) {
			System.err.println("Use: java Renderer <Local IPAddress> <Localport> <Remote IPAddress> <Remote Port>");
		}

	}
	private static void go_stop()throws AWTException { //To change body of generated methods, choose Tools | Templates.
		try{
			//Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_S);
			robot.keyPress(KeyEvent.VK_S);
		}
		catch(IllegalArgumentException e1) {
			System.err.println("Use: java Renderer <Local IPAddress> <Localport> <Remote IPAddress> <Remote Port>");
		}

	}
	private static void go_forward()throws AWTException { //To change body of generated methods, choose Tools | Templates.
		try{
			// Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_ALT);
		}
		catch(IllegalArgumentException e1) {
			System.err.println("Use: java Renderer <Local IPAddress> <Localport> <Remote IPAddress> <Remote Port>");
		}

	}
	private static void go_reverse()throws AWTException { //To change body of generated methods, choose Tools | Templates.
		try{
			// Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_LEFT);
			robot.keyRelease(KeyEvent.VK_LEFT);
			robot.keyRelease(KeyEvent.VK_ALT);
		}
		catch(IllegalArgumentException e1) {
			System.err.println("Use: java Renderer <Local IPAddress> <Localport> <Remote IPAddress> <Remote Port>");
		}

	}
}


