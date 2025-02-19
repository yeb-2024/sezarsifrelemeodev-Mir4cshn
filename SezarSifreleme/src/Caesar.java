import javax.swing.*;
import java.awt.*;

public class Caesar {
    private JFrame frame;
    Caesar(){
        frame = new JFrame("Caesar Şifreleme Uygulaması");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));
    }

    public static void main(String[] args) {
        new Caesar();
    }
}
