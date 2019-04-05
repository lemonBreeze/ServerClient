package de.fhws.fiw.pvs.week05.FactorialRMI;

import java.rmi.Naming;

public class Server
{
    public static void main( String[] args )
    {
        try
        {
            IFactorialService factorialService = new FactorialServiceImpl();
            Naming.rebind( IFactorialService.SERVICE_NAME, factorialService );

            System.out.println( "Server is running..." );
        }
        catch ( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
