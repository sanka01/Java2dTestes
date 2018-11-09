import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame {

    private int altura = 600,largura = 800;


    public Principal(){
        setTitle("Java 2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add(new Java2d(largura,altura));
        add(new Poligono2D(largura,altura));
        setSize(largura, altura);
        setLocationRelativeTo(null);

    }
    public static void main(String args[]) {

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new Principal().setVisible(true);
            }
        });

    }

}
