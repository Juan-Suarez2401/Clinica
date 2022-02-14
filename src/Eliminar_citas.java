import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Eliminar_citas extends JFrame{
    private JPanel panel1;
    private JTextField id;
    private JButton eliminarButton;

    public Eliminar_citas(){
        super("eliminar");
        setContentPane(panel1);


        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar();
                dispose();
            }
        });
    }

    public void eliminar(){
        Connection con = null;
        String user = "postgres";
        String pass = "2401";

        try{
            Class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/clinica",user,pass);
            JOptionPane.showMessageDialog(null,"Se elimino exitosamente");
            String sql = "DELETE FROM citas WHERE id= "+id.getText()+"";
            Statement st = con.createStatement();
            st.executeQuery(sql);

            con.close();
            st.close();

        }catch(Exception e){

        }
    }
}
