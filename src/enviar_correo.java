import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class enviar_correo extends JFrame{
    private JPanel panel1;
    private JTextField asunto;
    private JTextField correo;
    private JTextArea mensaje;
    private JButton enviarButton;
    private JButton salirButton;
    private JPanel panel2;

    public enviar_correo(){
        super("correo");
        setContentPane(panel1);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarCorreo();
                limpiar();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void enviarCorreo(){
        String remitente = "juankarlos2401@gmail.com";
        String clave = "24010203*";
        String destino = correo.getText();
        String contenido= mensaje.getText();

        Properties prosp = new Properties();
        prosp.put("mail.smtp.host","smtp.gmail.com");
        prosp.put("mail.smtp.port","587");
        prosp.put("mail.smtp.auth","true");
        prosp.put("mail.smtp.starttls.enable","true");
        prosp.put("mail.smtp.user",remitente);
        prosp.put("mail.smtp.clave",clave);

        Session session = Session.getDefaultInstance(prosp);
        MimeMessage mensaje = new MimeMessage(session);

        try{
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            mensaje.setSubject(asunto.getText());
            mensaje.setText(contenido);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com",remitente,clave);
            transport.sendMessage(mensaje,mensaje.getAllRecipients());
            transport.close();
            System.out.println("Correo enviado");
        }catch(Exception es){
            es.printStackTrace();
        }

    }
    public void limpiar (){
        JTextField caja;
        for(int i=0;i < panel2.getComponentCount(); i++){
            if(panel2.getComponent(i).getClass().getName().equals("javax.swing.JTextField")){
                caja= (JTextField)panel2.getComponent(i);
                caja.setText("");
            }
        }
    }
}
