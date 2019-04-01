package de.fhws.fiw.pvs.week05.BinaryDataJSON;

import com.owlike.genson.Genson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;


public class TcpClient
{
	public static void main( final String[] argv ) throws Exception
	{
		sendMessage( 22, "James" , "Paul");
	}

	public static void sendMessage( final int value, final String message, final String person) throws Exception
	{
		final Socket clientSocket = new Socket( "localhost", 6789 );

		final OutputStreamWriter outToServer = new OutputStreamWriter( clientSocket.getOutputStream( ) );
		final InputStreamReader inputStreamReader = new InputStreamReader( clientSocket.getInputStream( ) );
		final BufferedReader inFromServer = new BufferedReader( inputStreamReader );

		final Map<String, Object> map = new HashMap( );
		map.put( "value", value );
		map.put( "message", message );
		map.put("person", person);

		final Genson genson = new Genson( );
		final String json = genson.serialize( map );

		String output2 = Base64.getEncoder().encodeToString(json.getBytes());


		System.out.println( json );

		outToServer.append( output2 ).append( '\n' );
		outToServer.flush( );

		final String output = inFromServer.readLine( );

		final Map<String, Object> inMap = genson.deserialize( output, Map.class );
		System.out.println( "RESPONSE FROM SERVER: value = " + inMap.get( "VALUE" ) );
		System.out.println( "RESPONSE FROM SERVER: message = " + inMap.get( "MESSAGE" ) );
		System.out.println( "RESPONSE FROM SERVER: binary = " + inMap.get( "BINARY" ) );
		clientSocket.close( );
	}
}