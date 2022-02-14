import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame= new prueba();
                frame.setSize(600,600 );
                frame.setVisible(true);
            }
        });


    }
}
