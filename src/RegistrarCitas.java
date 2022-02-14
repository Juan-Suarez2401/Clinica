import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RegistrarCitas {

    public void Registrar(String nombre, String identificacion, String cel, String tipo){

        Connection con = null;
        String user = "postgres";
        String pass = "2401";
        try{
            Class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/clinica",user,pass);
            JOptionPane.showMessageDialog(null,"Se guardo correctamente");
            String sql = "INSERT INTO \"citas\" VALUES ('"+identificacion+"','"+nombre+"','"+cel+"','"+tipo+"')";
            Statement st = con.createStatement();
            st.executeQuery(sql);

            st.close();
            con.close();
        }catch(Exception e){

        }
    }
}
