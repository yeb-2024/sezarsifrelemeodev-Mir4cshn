import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Caesar implements ActionListener {
    private JFrame frame;
    private JTextField keyField,messageField;
    private JButton encryptButton,decryptButton;
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

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        encryptButton = new JButton("Şifrele");
        encryptButton.setFont(new Font("Arial", Font.PLAIN, 16));
        encryptButton.addActionListener(this);
        decryptButton = new JButton("Çöz");
        decryptButton.setFont(new Font("Arial", Font.PLAIN, 16));
        decryptButton.addActionListener(this);
        panel3.add(encryptButton);
        panel3.add(decryptButton);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Caesar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
