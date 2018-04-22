package de.fhws.fiw.pvs.week05.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.ZonedDateTime;

public interface IExampleService extends Remote
{
	String SERVICE_NAME = "ExampleService";

	String echo( String msg ) throws RemoteException;

	ZonedDateTime getServerTime( ) throws RemoteException;

	int add( int n1, int n2 ) throws RemoteException;

	Location reverse( Location location ) throws RemoteException;

	void foo( ISecondService secondService ) throws RemoteException;

}