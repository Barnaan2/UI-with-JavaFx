import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Barnaan
 */
public class Sever {
    public static void main(String[] args)throws IOException{
        ServerSocket server = new ServerSocket(3000);
        Socket socket= server.accept();
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        DataInputStream dataInput = new DataInputStream(input);
        DataOutputStream dataOutput = new DataOutputStream(output);
        
        System.out.println("client" + dataInput.readUTF());
        System.out.println("Server");
        String scanner = new Scanner(System.in).nextLine();
        dataOutput.writeUTF(scanner);
    }
    
}
