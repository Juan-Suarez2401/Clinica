import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RegistrarPaciente {
    public void RegistrarPaciente(String nombre, String fecha,String identificacion, String direccion, String cel ){
        Connection con = null;
        String user = "postgres";
        String pass = "2401";

        try{
            Class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/clinica",user,pass);
            JOptionPane.showMessageDialog(null,"Se registro exitosamente");
            String sql = "INSERT INTO \"pacientes\" VALUES ('"+nombre+"','"+fecha+"','"+direccion+"','"+identificacion+"','"+cel+"') ";
            Statement st = con.createStatement();
            st.executeQuery(sql);

            con.close();
            st.close();
        }catch(Exception es){
        }
    }
}
