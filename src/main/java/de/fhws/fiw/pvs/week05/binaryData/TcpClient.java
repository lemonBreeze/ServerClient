package de.fhws.fiw.pvs.week05.binaryData;

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
		String input = "Hello World!";
		byte[] byteArr = input.getBytes();

		System.out.println(sendMessage(byteArr));

	}

	public static byte[] sendMessage( final byte[] message) throws Exception {
		final Socket clientSocket = new Socket("localhost", 6789);
		OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());


		for (int i = 0; i < message.length; i++) {
			osw.write(message[i]);
		}

		osw.flush();
		osw.close();
		return (message);


	}



}
