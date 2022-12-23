import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Barnaan
 */
public class JavaDatabase extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label idLabel = new Label("Id");
        Label nameLabel = new Label("Name");

        TextField id = new TextField();
        TextField name = new TextField();
        Button search = new Button();
        Button next = new Button();
        Button prv = new Button();
        next.setText("Next");
        prv.setText("Prv");
        search.setText("search");

        GridPane view = new GridPane();
        view.setAlignment(Pos.CENTER);
        view.setHgap(10);
        view.setVgap(10);
        view.setPadding(new Insets(25, 25, 25, 25));
        Label userName = new Label("User Name:");
        view.add(userName, 0, 1);
        view.add(name, 0, 2);
        view.add(id, 0, 4);
        view.add(idLabel, 0, 3);
        view.add(search, 1, 5);
        view.add(next, 4, 5);
        view.add(prv, 2, 5);

        search.setOnAction(e -> {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Java", "root", "cc3377ch");
                Statement st =conn.createStatement();
                ResultSet rs =st.executeQuery("select * from students where id = '"+id.getText()+"'");
                while(rs.next())
                {
                    name.setText(rs.getString("Name"));
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JavaDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(JavaDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        Scene scene = new Scene(view, 300, 250);
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
