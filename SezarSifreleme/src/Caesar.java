import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Caesar implements ActionListener {
    private String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private JFrame frame;
    private JTextField keyField,messageField,resultField;
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

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel resultLabel = new JLabel("Sonuç: ");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        resultField = new JTextField(20);
        resultField.setEditable(false);
        panel4.add(resultLabel);
        panel4.add(resultField);


        JPanel panel5 = new JPanel();
        panel5.setPreferredSize(new Dimension(400, 20));

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Caesar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int key = Integer.parseInt(keyField.getText().trim());
            String message = messageField.getText().trim();

            if (message.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Lütfen bir mesaj girin.", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String result;
            if (e.getSource() == encryptButton) {
                result = caesarCipher(message, key, "Şifrele");
                JOptionPane.showMessageDialog(frame, "Şifreleme başarılı!", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                result = caesarCipher(message, key, "Çöz");
                JOptionPane.showMessageDialog(frame, "Çözme başarılı!", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Lütfen geçerli bir anahtar girin.", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }
    public  String caesarCipher(String metin, int anahtar, String islem) {
        StringBuilder sonuc = new StringBuilder();
        metin = metin.toUpperCase();

        for (char harf : metin.toCharArray()) {
            int indeks = SYMBOLS.indexOf(harf);
            if (indeks != -1) {
                int yeniIndeks = (islem.equals("Şifrele")) ? (indeks + anahtar) % SYMBOLS.length() : (indeks - anahtar + SYMBOLS.length()) % SYMBOLS.length();
                sonuc.append(SYMBOLS.charAt(yeniIndeks));
            } else {
                sonuc.append(harf);
            }
        }
        return sonuc.toString();
    }
}