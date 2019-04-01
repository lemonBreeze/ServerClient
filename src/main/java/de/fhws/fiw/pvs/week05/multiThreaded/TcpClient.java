package de.fhws.fiw.pvs.week05.multiThreaded;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class TcpClient extends Thread
{
	Socket clientSocket = null;
	int value;
	String message;

	public TcpClient(int value, String message)
	{
		this.value= value;
		this.message = message;
	}

	@Override
	public void run()
	{
		try
		{
				final BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
				clientSocket = new Socket("localhost", 6789);
				final OutputStreamWriter outToServer = new OutputStreamWriter(clientSocket.getOutputStream());
				final InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
				final BufferedReader inFromServer = new BufferedReader(inputStreamReader);

				String input = message + "," + Integer.toString(value);

				outToServer.append(input).append('\n');
				outToServer.flush();


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try
			{
				clientSocket.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	};

	public static void main( final String[] argv ) throws Exception
	{
		TcpClient tcp1 = new TcpClient(1, "Client");
		TcpClient tcp2 = new TcpClient(2, "Client");
		TcpClient tcp3 = new TcpClient(3, "Client");

		tcp1.start();
		tcp3.start();
		tcp2.start();
	}


}
