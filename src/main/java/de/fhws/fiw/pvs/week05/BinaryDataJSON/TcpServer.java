package de.fhws.fiw.pvs.week05.BinaryDataJSON;

import com.owlike.genson.Genson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Base64;


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


			byte[] decodeBytes = Base64.getDecoder().decode(input);
			String decoded = new String(decodeBytes);
			System.out.println(decoded);


			decoded = decoded.toUpperCase();
			final Map<String, Object> inMap = genson.deserialize( decoded, Map.class );


			System.out.println( "RECEIVED FROM CLIENT: value = " + inMap.get( "VALUE" ) );
			System.out.println( "RECEIVED FROM CLIENT: message = " + inMap.get( "MESSAGE" ) );
			System.out.println( "RECEIVED FROM CLIENT: person = " + inMap.get( "PERSON" ) );

			final OutputStreamWriter outputStreamWriter = new OutputStreamWriter( socket.getOutputStream( ) );
			final BufferedWriter bufferedWriter = new BufferedWriter( outputStreamWriter );
			bufferedWriter.append( decoded ).append( '\n' );
			bufferedWriter.flush( );
			bufferedWriter.close( );
			inFromClient.close( );
			socket.close( );
		}
	}
}