package de.fhws.fiw.pvs.week05.rmi;

import java.rmi.Naming;

public class Server
{
	public static void main( String[] args )
	{
		try
		{
			IExampleService exampleService = new ExampleServiceImpl( );
			Naming.rebind( IExampleService.SERVICE_NAME, exampleService );

			ISecondService secondService = new SecondServiceImpl( );
			Naming.rebind( ISecondService.SERVICE_NAME, secondService );

			System.out.println( "Server is running..." );
		}
		catch ( Exception e )
		{
			e.printStackTrace( );
		}
	}
}