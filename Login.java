/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Barnaan
 */
public class Login extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
       TextArea username = new TextArea();
       TextArea password = new TextArea();
       username.setMaxHeight(40);
       password.setMaxHeight(40);
       
        
        
        Button btn = new Button();
        btn.setText("Login");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
             
            String   userName =  username.getText();
                System.out.println(userName);
                String customUserName = "Barnaan";
                String customPassword = "password";
              String  password1 = password.getText();
              
              if(userName.equals(customUserName) && password1.equals(customPassword)){
               System.out.println(" This form is working "); 
            }
              else{
                  System.out.println(" The shit is not working") ;
              }
                
            }
        });
        
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20 ,30, 20, 30));
        VBox loginForm = new VBox(10);
        loginForm.getChildren().addAll(username,password,btn);
//        
//        root.setTop(username);
//        root.setTop(password);
//        root.getChildren().addAll(btn);
root.setTop(loginForm);

        
        Scene scene = new Scene(root, 500, 450);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
