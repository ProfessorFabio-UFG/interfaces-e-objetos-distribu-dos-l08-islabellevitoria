package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String sayHello() throws RemoteException;
    int soma(int a, int b) throws RemoteException;

    // Novos métodos
    String toUpperCase(String input) throws RemoteException;
    double media(double[] numeros) throws RemoteException;
}
