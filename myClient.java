import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class myClient {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		//socket do servidor
		Socket echoSocket = new Socket("localhost", 23456);
		
		//Input
		ObjectInputStream in = new ObjectInputStream(echoSocket.getInputStream());
		
		//Output
		ObjectOutputStream out = new ObjectOutputStream(echoSocket.getOutputStream());
		
		String user = "Client1";
		String password ="1234";
		
		//Enviar para servidor
		out.writeObject(user);
		out.writeObject(password);
		
		//Ler resposta do servidor
		Boolean fromServer = (Boolean) in.readObject();		
		System.out.println(fromServer);
		
		//Fechar
		out.close();
		in.close();
		echoSocket.close();

	}

}
