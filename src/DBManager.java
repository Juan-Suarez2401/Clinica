import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    private static String user= "postgres";
    private static String pass= "2401";

    public static Connection connection;

    public static void iniConexion(){
        try{
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/clinica", user,pass);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Conexion fallida "+ e.getMessage() );
        }
    }
}
