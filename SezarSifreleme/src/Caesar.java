import javax.swing.*;
import java.awt.*;

public class Caesar {
    private JFrame frame;
    private JTextField keyField,messageField;
    Caesar(){
        frame = new JFrame("Caesar Şifreleme Uygulaması");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label1 = new JLabel("Anahtar Değeri:");
        label1.setFont(new Font("Arial", Font.PLAIN, 16));
        keyField = new JTextField(5);
        panel1.add(label1);
        panel1.add(keyField);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label2 = new JLabel("Mesaj:");
        label2.setFont(new Font("Arial", Font.PLAIN, 16));
        messageField = new JTextField(20);
        panel2.add(label2);
        panel2.add(messageField);

        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Caesar();
    }
}
