package de.fhws.fiw.pvs.assignment05;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * (c) Tobias Fertig, FHWS 2017
 */
public class PersonManagementClient
{
	private final ManagedChannel channel;
	private final de.fhws.fiw.pvs.assignment05.PersonManagementServiceGrpc.PersonManagementServiceBlockingStub
		blockingStub;

	public PersonManagementClient( final String host, final int port )
	{
		/* In the following statement, do NOT remove usePlaintext or set it to false. */
		channel = ManagedChannelBuilder.forAddress( host, port ).usePlaintext( true ).build( );
		blockingStub = de.fhws.fiw.pvs.assignment05.PersonManagementServiceGrpc.newBlockingStub( channel );
	}

	public static void main( final String[] args ) throws InterruptedException
	{
		final PersonManagementClient client = new PersonManagementClient( "localhost", 8888 );
		try
		{
			client.createPerson( "Hans", "Wurst", new Date( ).getTime( ) );
			client.createPerson( "Hans2", "Wurst", new Date( ).getTime( ) );
			client.createPerson( "Hans3", "Wurst", new Date( ).getTime( ) );
			client.createPerson( "Hans4", "Wurst", new Date( ).getTime( ) );

			client.createPerson( "Hans", "Wurst2", new Date( ).getTime( ) );
			client.createPerson( "Hans", "Wurst3", new Date( ).getTime( ) );
			client.createPerson( "Hans", "Wurst4", new Date( ).getTime( ) );

			System.out.println( "------------------------------------SEARCH PERSONS-----------------------" );
			client.searchPerson( "Wurst" );
			System.out.println( "------------------------------------LIST PERSONS-----------------------" );
			client.listAll( );
		}
		finally
		{
			client.shutdown( );
		}
	}

	public void shutdown( ) throws InterruptedException
	{
		channel.shutdown( ).awaitTermination( 5, TimeUnit.SECONDS );
	}

	/**
	 * Say hello to server.
	 */
	public void createPerson( final String firstname, final String lastname, final long birthday )
	{
		final PersonManagement.Person person = PersonManagement.Person.newBuilder( )
																	  .setFirstname( firstname )
																	  .setLastname( lastname )
																	  .setBirthday( birthday )
																	  .build( );

		try
		{
			final PersonManagement.CreateReply response = blockingStub.createPerson( person );
			System.out.println( response.getPerson( ) + " created" );
		}
		catch ( final StatusRuntimeException e )
		{
			e.printStackTrace( );
		}
	}

	public void searchPerson( final String lastname )
	{
		final PersonManagement.SearchRequest request =
			PersonManagement.SearchRequest.newBuilder( ).setLastname( lastname ).build( );

		try
		{
			final PersonManagement.SearchResponse response = blockingStub.search( request );
			printResponse( response );
		}
		catch ( final StatusRuntimeException e )
		{
			e.printStackTrace( );
		}
	}

	public void listAll( )
	{
		final PersonManagement.SearchRequest request =
			PersonManagement.SearchRequest.newBuilder( ).setLastname( "" ).build( );

		try
		{
			final PersonManagement.SearchResponse response = blockingStub.listAll( request );
			printResponse( response );
		}
		catch ( final StatusRuntimeException e )
		{
			e.printStackTrace( );
		}
	}

	private void printResponse( final PersonManagement.SearchResponse response )
	{
		for ( final PersonManagement.Person person : response.getPersonList( ) )
		{
			System.out.println( person );
		}
	}
}
