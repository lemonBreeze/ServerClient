package de.fhws.fiw.pvs.week05.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by braunpet on 13.04.17.
 */
public interface ISecondService extends Remote
{
	String SERVICE_NAME = "SecondService";

	int getValue( ) throws RemoteException;

	void setValue( int value ) throws RemoteException;
}
