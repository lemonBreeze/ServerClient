package de.fhws.fiw.pvs.assignment05;

import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (c) Tobias Fertig, FHWS 2017
 */
public class PersonManagementServiceImpl
	extends de.fhws.fiw.pvs.assignment05.PersonManagementServiceGrpc.PersonManagementServiceImplBase
{
	private final Map<String, List<PersonManagement.Person>> persons;

	public PersonManagementServiceImpl( )
	{
		super( );
		this.persons = new HashMap<>( );
	}

	@Override public void createPerson( final PersonManagement.Person request,
		final StreamObserver<PersonManagement.CreateReply> responseObserver )
	{
		List<PersonManagement.Person> personList = persons.get( request.getLastname( ) );

		if ( personList == null )
		{
			personList = new ArrayList<>( );
		}

		personList.add( request );

		persons.put( request.getLastname( ), personList );

		final PersonManagement.CreateReply reply =
			PersonManagement.CreateReply.newBuilder( ).setPerson( request ).build( );

		responseObserver.onNext( reply );
		responseObserver.onCompleted( );
	}

	@Override public void search( final PersonManagement.SearchRequest request,
		final StreamObserver<PersonManagement.SearchResponse> responseObserver )
	{
		final String pattern = request.getLastname( );

		final List<PersonManagement.Person> personList = persons.get( pattern );

		final PersonManagement.SearchResponse reply;

		if ( personList != null )
		{
			reply = PersonManagement.SearchResponse.newBuilder( ).addAllPerson( personList ).build( );
		}
		else
		{
			reply = PersonManagement.SearchResponse.newBuilder( ).build( );
		}

		responseObserver.onNext( reply );
		responseObserver.onCompleted( );
	}

	@Override public void listAll( final PersonManagement.SearchRequest request,
		final StreamObserver<PersonManagement.SearchResponse> responseObserver )
	{
		final PersonManagement.SearchResponse.Builder replyBuilder = PersonManagement.SearchResponse.newBuilder( );

		for ( final Map.Entry<String, List<PersonManagement.Person>> stringListEntry : persons.entrySet( ) )
		{
			replyBuilder.addAllPerson( stringListEntry.getValue( ) );
		}

		responseObserver.onNext( replyBuilder.build( ) );
		responseObserver.onCompleted( );
	}
}
