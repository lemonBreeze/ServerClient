package de.fhws.fiw.pvs.week05.BinaryDataJSON;

import com.owlike.genson.Genson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

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

			final Genson genson = new Genson( );
			System.out.println( "Received from Client: " + input );

			final String output = input.toUpperCase( );
			final Map<String, Object> inMap = genson.deserialize( output, Map.class );
			System.out.println( "RECEIVED FROM CLIENT: value = " + inMap.get( "VALUE" ) );
			System.out.println( "RECEIVED FROM CLIENT: message = " + inMap.get( "MESSAGE" ) );
			System.out.println( "RECEIVED FROM CLIENT: binary = " + inMap.get( "BINARY" ) );

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