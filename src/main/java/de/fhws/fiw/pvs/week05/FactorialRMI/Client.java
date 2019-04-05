package de.fhws.fiw.pvs.week05.FactorialRMI;



import java.rmi.Naming;

public class Client
{
    private static final String ADDRESS_FACTORIAL = "rmi://localhost/" + IFactorialService.SERVICE_NAME;

    public static void main( String[] args )
    {
        try
        {
            IFactorialService factorialService = ( IFactorialService ) Naming.lookup( ADDRESS_FACTORIAL );

            System.out.println("The FactorialNumber of 3 is: " + factorialService.factorial(3));
        }
        catch ( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
