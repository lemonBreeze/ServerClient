package de.fhws.fiw.pvs.week05.ExerciseSer;

import java.io.*;
class A implements Serializable { B b; }
class B implements Serializable { C c; }
class C implements Serializable { A a; }

public class cyclicObjectSerialization
{


    public static void main( String [] args ) throws IOException {
        A a = new A();
        a.b = new B();
        a.b.c = new C();
        a.b.c.a = a;
        new ObjectOutputStream( new ByteArrayOutputStream( ) ).writeObject( a );
        System.out.println("It works");

    }
    //every single Objects in a cyclic graph has to implement Serialization to marshall and unmarshall to serialise the cyclic graph.

}
