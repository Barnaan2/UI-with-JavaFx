
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Barnaan
 */
public class Client {
    
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("localhost",3000);
        
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        DataInputStream dataInput = new DataInputStream(input);
        DataOutputStream dataOutput = new DataOutputStream(output);
        
        System.out.println("server" + dataInput.readUTF());
        String scanner = new Scanner(System.in).nextLine();
        dataOutput.writeUTF(scanner);
       
        
    }
}
