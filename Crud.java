

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Barnaan
 */
public class PrepStmt {
    static Connection database(){
          Connection db = null;
        try{
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           String url = "jdbc:derby://localhost:1527/Java";
           String userName = "root";
           String password = "cc3377ch";
           db = DriverManager.getConnection(url,userName,password);
           
           
        }
        catch(ClassNotFoundException|SQLException e){
            System.out.println("Error happened in the Database method " + e);
        }
        return db;
    }
   
    
    
    
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student Name:- ");
        String name = input.nextLine();
        System.out.println("ID : ");
        String id = input.nextLine();
       
        
        try{
            
            // ? is called maker.
           String sql = "INSERT INTO students values(?,?)";
           PreparedStatement dynamic = database().prepareStatement(sql);
           dynamic.setString(1,id);
           dynamic.setString(2,name);
           int status = dynamic.executeUpdate();
           if(status == 1){
               System.out.println("Added new student");
           }
           else{
               System.out.println("something is not working ");
           }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
}
