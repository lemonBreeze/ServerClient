package de.fhws.fiw.pvs.week05.sockets.step1;

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
		final BufferedReader inFromUser = new BufferedReader( new InputStreamReader( System.in ) );
		final Socket clientSocket = new Socket( "localhost", 6789 );

		final OutputStreamWriter outToServer = new OutputStreamWriter( clientSocket.getOutputStream( ) );
		final InputStreamReader inputStreamReader = new InputStreamReader( clientSocket.getInputStream( ) );
		final BufferedReader inFromServer = new BufferedReader( inputStreamReader );

		System.out.println( "INPUT: " );
		final String input = inFromUser.readLine( );

		outToServer.append( input ).append( '\n' );
		outToServer.flush( );

		final String output = inFromServer.readLine( );

		System.out.println( "RESPONSE FROM SERVER: " + output );
		clientSocket.close( );
	}

}
