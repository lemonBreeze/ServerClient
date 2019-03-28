package de.fhws.fiw.pvs.week05.BinaryDataJSON;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by braunpet on 04.04.17.
 */
public class TcpServer
{
	public static void main( final String[] args ) throws Exception
	{
		final ServerSocket serverSocket = new ServerSocket( 6789 );

		while ( true )
		{
			final Socket socket = serverSocket.accept( );
			final InputStreamReader inputStreamReader = new InputStreamReader( socket.getInputStream( ) );
			final BufferedReader inFromClient = new BufferedReader( inputStreamReader );
			final String input = inFromClient.readLine( );

			System.out.println( "Received from Client: " + input );

			final String output = input.toUpperCase( );

			final OutputStreamWriter outputStreamWriter = new OutputStreamWriter( socket.getOutputStream( ) );
			final BufferedWriter bufferedWriter = new BufferedWriter( outputStreamWriter );
			bufferedWriter.append( output ).append( '\n' );
			bufferedWriter.flush( );
			bufferedWriter.close( );
			inFromClient.close( );
			socket.close( );
		}
	}
}
