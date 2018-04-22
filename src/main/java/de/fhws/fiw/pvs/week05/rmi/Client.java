package de.fhws.fiw.pvs.week05.rmi;

import java.rmi.Naming;

public class Client
{
	private static final String ADDRESS_EXAMPLE = "rmi://localhost/" + IExampleService.SERVICE_NAME;
	private static final String ADDRESS_SECOND = "rmi://localhost/" + ISecondService.SERVICE_NAME;

	public static void main( String[] args )
	{
		try
		{
			IExampleService exampleService = ( IExampleService ) Naming.lookup( ADDRESS_EXAMPLE );

			System.out.println( "Echo: " + exampleService.echo( "Hello" ) );

			System.out.println( "Server Time: " + exampleService.getServerTime( ) );

			System.out.println( "Summe: " + exampleService.add( 101, 207 ) );

			System.out.println( exampleService.reverse( new Location( -10f, 10f ) ) );

			ISecondService secondService = ( ISecondService ) Naming.lookup( ADDRESS_SECOND );

			secondService.setValue( 4711 );

			exampleService.foo( secondService );

			System.out.println( "Value: " + secondService.getValue( ) );
		}
		catch ( Exception e )
		{
			e.printStackTrace( );
		}
	}
}