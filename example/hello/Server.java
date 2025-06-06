package example.hello;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {

    public Server() {}

    @Override
    public String sayHello() {
        return "Hello, world!";
    }

    @Override
    public int soma(int a, int b) {
        return a + b;
    }

    
    @Override
    public String toUpperCase(String input) {
        return input.toUpperCase();
    }

    
    @Override
    public double media(double[] numeros) {
        double soma = 0;
        for (double num : numeros) {
            soma += num;
        }
        return numeros.length == 0 ? 0 : soma / numeros.length;
    }

    public static void main(String args[]) {

        try {
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

           
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
