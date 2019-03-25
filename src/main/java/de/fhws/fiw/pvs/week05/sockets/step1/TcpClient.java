package de.fhws.fiw.pvs.week05.sockets.step1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
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

		final DataOutputStream outToServer = new DataOutputStream( clientSocket.getOutputStream( ) );
		final BufferedReader inFromServer =
			new BufferedReader( new InputStreamReader( clientSocket.getInputStream( ) ) );

		System.out.println( "INPUT: " );
		final String input = inFromUser.readLine( );

		outToServer.writeBytes( input + "\n" );
		final String output = inFromServer.readLine( );

		System.out.println( "RESPONSE FROM SERVER: " + output );
		clientSocket.close( );
	}

}
