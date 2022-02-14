import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class prueba2  extends  JFrame{
    private JPanel panel1;
    private JButton registrarCitas;
    private JButton mostrarCitas;
                        private JPanel ButtonPanel;
    private JPanel CardPanel;
    private JPanel Card1Pnale;
    private JPanel Card2Panel;
    private JPanel Card3Panel;
    private JButton pacientes;
    private JTextField Nombre_paciente;
    private JTextField fecha;
    private JTextField identificacion;
    private JButton guardarButton;
    private JButton salirButton;
    private JTextField direccion;
    private JTextField telefono;
    private JTextField NombreCita;
    private JTextField IdentificacionCita;
    private JTextField CelCita;
    private JTextField TipoCita;
    private JButton guardarButton1;
    private JButton salirButton1;
    private JTable table1;
    private JButton salirButton2;
    private JButton eliminarCitaButton;
    private JButton correo;
    private JButton actualizar;
    private JTextField buscar;
    private JButton buscarButton;


    public prueba2() {
        super("ejemplo2");
        setContentPane(panel1);

        pacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardPanel.removeAll();
                CardPanel.add(Card1Pnale);
                CardPanel.repaint();
                CardPanel.revalidate();
            }
        });
        registrarCitas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardPanel.removeAll();
                CardPanel.add(Card2Panel);
                CardPanel.repaint();
                CardPanel.revalidate();
            }
        });
        mostrarCitas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardPanel.removeAll();
                CardPanel.add(Card3Panel);
                CardPanel.repaint();
                CardPanel.revalidate();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                dispose();
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarPaciente pa = new RegistrarPaciente();
                pa.RegistrarPaciente(Nombre_paciente.getText(),fecha.getText(),identificacion.getText(),direccion.getText(),telefono.getText());
                limpiar();
            }
        });
        salirButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                dispose();
            }
        });
        guardarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarCitas re = new RegistrarCitas();
                re.Registrar(NombreCita.getText(),IdentificacionCita.getText(),CelCita.getText(),TipoCita.getText());
                limpiar2();
            }
        });


        setContentPane(panel1);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre", new String[]{"Identificacion"});
        modelo.addColumn("Edad", new String[]{"Nombre"});
        modelo.addColumn("Nacionalidad", new String[]{"Celular"});
        modelo.addColumn("Edad", new String[]{"Tipo de cita"});
        String[] p1= new String[4];

        Connection con = null;
        String user = "postgres";
        String pass = "2401";
        try{

            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/clinica",user,pass);
            String sql = "SELECT * FROM \"citas\"";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                p1[0]= rs.getString("id");
                p1[1]= rs.getString("Nombre_paciente");
                p1[2]= rs.getString("celular");
                p1[3]= rs.getString("tipo_cita");
                modelo.addRow(p1);
            }
            rs.close();
            st.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        table1.setModel(modelo);
        salirButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                dispose();
            }
        });
        eliminarCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame pru = new Eliminar_citas();
                pru.setVisible(true);
                pru.setSize(500,180);
            }
        });
        correo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame correo= new enviar_correo();
                correo.setVisible(true);
                correo.setSize(500,300);
            }
        });
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(panel1);
                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("Nombre", new String[]{"Identificacion"});
                modelo.addColumn("Edad", new String[]{"Nombre"});
                modelo.addColumn("Nacionalidad", new String[]{"Celular"});
                modelo.addColumn("Edad", new String[]{"Tipo de cita"});
                String[] p1= new String[4];

                Connection con = null;
                String user = "postgres";
                String pass = "2401";
                try{

                    con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/clinica",user,pass);
                    String sql = "SELECT * FROM \"citas\"";
                    Statement st = con.createStatement();
                    ResultSet rs= st.executeQuery(sql);
                    while(rs.next()){
                        p1[0]= rs.getString("id");
                        p1[1]= rs.getString("Nombre_paciente");
                        p1[2]= rs.getString("celular");
                        p1[3]= rs.getString("tipo_cita");
                        modelo.addRow(p1);
                    }
                    rs.close();
                    st.close();

                }catch(Exception exe){
                    System.out.println(exe.getMessage());
                }
                table1.setModel(modelo);
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(panel1);
                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("Nombre", new String[]{"Identificacion"});
                modelo.addColumn("Edad", new String[]{"Nombre"});
                modelo.addColumn("Nacionalidad", new String[]{"Celular"});
                modelo.addColumn("Edad", new String[]{"Tipo de cita"});
                String[] p1= new String[4];

                Connection con = null;
                String user = "postgres";
                String pass = "2401";
                try{

                    con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/clinica",user,pass);
                    String sql = "SELECT * FROM \"citas\" WHERE id= "+buscar.getText()+"";
                    Statement st = con.createStatement();
                    ResultSet rs= st.executeQuery(sql);
                    while(rs.next()){
                        p1[0]= rs.getString("id");
                        p1[1]= rs.getString("Nombre_paciente");
                        p1[2]= rs.getString("celular");
                        p1[3]= rs.getString("tipo_cita");
                        modelo.addRow(p1);
                    }
                    rs.close();
                    st.close();

                }catch(Exception exe){
                    System.out.println(exe.getMessage());
                }
                table1.setModel(modelo);
            }
        });
    }

    //-------------------------------------Limpiar Pacientes------------------------------
    public void limpiar (){
        JTextField caja;
        for(int i=0;i < Card1Pnale.getComponentCount(); i++){
            if(Card1Pnale.getComponent(i).getClass().getName().equals("javax.swing.JTextField")){
                caja= (JTextField)Card1Pnale.getComponent(i);
                caja.setText("");
            }
        }
    }

    //-------------------------------------Limpiar Citas------------------------------
    public void limpiar2 (){
        JTextField caja;
        for(int i=0;i < Card2Panel.getComponentCount(); i++){
            if(Card2Panel.getComponent(i).getClass().getName().equals("javax.swing.JTextField")){
                caja= (JTextField)Card2Panel.getComponent(i);
                caja.setText("");
            }
        }
    }
}

