package example.hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        System.out.println("Initiating client");

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            System.out.println("Registry has been located");
            Hello stub = (Hello) registry.lookup("Hello");
            System.out.println("Found server");


            String response = stub.sayHello();
            System.out.println("response: " + response);

            
            int resp = stub.soma(100, 1000);
            System.out.println("Response from soma: " + resp);

            
            String upper = stub.toUpperCase("mensagem do cliente");
            System.out.println("Response from toUpperCase: " + upper);

            double[] array = {10.0, 20.0, 30.0, 40.0};
            double avg = stub.media(array);
            System.out.println("Response from media: " + avg);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
