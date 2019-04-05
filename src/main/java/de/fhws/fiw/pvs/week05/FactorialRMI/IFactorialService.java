package de.fhws.fiw.pvs.week05.FactorialRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFactorialService extends Remote
{
    String SERVICE_NAME = "FactorialService";
    public int factorial(int n2 ) throws RemoteException;

}


