package de.fhws.fiw.pvs.week05.FactorialRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FactorialServiceImpl extends UnicastRemoteObject implements IFactorialService
{
    String SERVICE_NAME = "FactorialService";

    protected FactorialServiceImpl() throws RemoteException
    {
        super( );
    }


    @Override
    public int factorial(int n2 ) throws RemoteException
    {
        int result = 1;
        if(n2 > 1)
        {
            while(n2 != 0)
            {
                result *= n2;
                n2--;
            }
        }
        return result;
    }
}
