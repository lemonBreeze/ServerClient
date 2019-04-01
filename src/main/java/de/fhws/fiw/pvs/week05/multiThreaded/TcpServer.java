package de.fhws.fiw.pvs.week05.multiThreaded;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServer
{
	ServerSocket serverSocket = null;
	BufferedReader inFromClient = null;
	BufferedWriter bufferedWriter = null;
	boolean ServerOn = true;

	class clientServerThread extends Thread
	{
		Socket socket = null;

		public clientServerThread()
		{
			super();
		}

		clientServerThread(Socket s)
		{
			socket=s;
		}

		@Override
		public void run()
		{
			try {

				final InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
				inFromClient = new BufferedReader(inputStreamReader);
				final String input = inFromClient.readLine();
				Thread.sleep(10000);
				System.out.println("Received from Client: " + input);


				final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
				bufferedWriter = new BufferedWriter(outputStreamWriter);
				bufferedWriter.append(input).append('\n');
				bufferedWriter.flush();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}


		TcpServer()
		{
			try
			{
				serverSocket = new ServerSocket( 6789 );
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			while(ServerOn) {
				try {
					Socket clientSocket = serverSocket.accept();
					clientServerThread cliThread = new clientServerThread(clientSocket);
					cliThread.start();

				} catch(Exception e) {
					System.out.println("Exception found on accept. Ignoring. Stack Trace :");
					e.printStackTrace();

				}
			}





}


	public static void main( final String[] args )
	{
			TcpServer server = new TcpServer();
	}

}