package de.fhws.fiw.pvs.week05.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by braunpet on 13.04.17.
 */
public class SecondServiceImpl extends UnicastRemoteObject implements ISecondService
{
	private int value;

	public SecondServiceImpl( ) throws RemoteException
	{
	}

	@Override public int getValue( ) throws RemoteException
	{
		return this.value;
	}

	@Override public void setValue( int value ) throws RemoteException
	{
		this.value = value;
	}
}
