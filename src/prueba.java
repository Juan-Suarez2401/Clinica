
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class prueba extends JFrame {
    private JPanel panel;
    private JTextField usuario;
    private JPasswordField password;
    private JButton ingresarButton;
    private JButton salirButton;



    public prueba(){
        super("Ejemplo");
        setContentPane(panel);
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                dispose();
            }
        });
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = null;
                String user= "postgres";
                String pass= "2401";
                String usuario1 = usuario.getText();
                String password1= String.valueOf(password.getPassword());
                int resultado =0;
                try{
                    Class.forName("org.postgresql.Driver");
                    con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clinica",user,pass);
                    String sql= "SELECT * FROM \"Usuarios\" WHERE usuario ='"+usuario1+"' and password= '"+password1+"'";
                    Statement st = con.createStatement();
                    ResultSet sr= st.executeQuery(sql);
                    if(sr.next()){
                        resultado=1;
                        if(resultado==1){
                            abrir();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Usuario y/o contraseña incorrecta");
                    }
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        });
    }

    public void abrir (){
        JFrame pru = new prueba2();
        pru.setVisible(true);
        pru.setSize(750,600);
        this.dispose();
    }
}


