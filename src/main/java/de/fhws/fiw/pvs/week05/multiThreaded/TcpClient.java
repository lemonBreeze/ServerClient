package de.fhws.fiw.pvs.week05.multiThreaded;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by braunpet on 04.04.17.
 */
public class TcpClient
{
	public static void main( final String[] argv ) throws Exception
	{
		System.out.println(sendMessage(42, "James"));
		System.out.println(sendMessage(39, "Penny"));
	}

	private static String sendMessage(final int value,final String message) throws Exception
	{
		final BufferedReader inFromUser = new BufferedReader( new InputStreamReader( System.in ) );
		final Socket clientSocket = new Socket( "localhost", 6789 );

		final OutputStreamWriter outToServer = new OutputStreamWriter( clientSocket.getOutputStream( ) );
		final InputStreamReader inputStreamReader = new InputStreamReader( clientSocket.getInputStream( ) );
		final BufferedReader inFromServer = new BufferedReader( inputStreamReader );

		String input = message + "," + Integer.toString(value);
		//System.out.println( "INPUT: " );
		//final String input = inFromUser.readLine( );

		outToServer.append( input ).append( '\n' );
		outToServer.flush( );

		final String output = inFromServer.readLine( );
		clientSocket.close( );
		return output;
	}

}
