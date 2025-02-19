import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2, b3;
    String pin;

    public Login(String pin) {
        this.pin = pin;
        this.setTitle("Automated Teller Machine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        imageLabel.setBounds(70, 20, 100, 80);
        this.add(imageLabel);

        l1 = new JLabel();
        l1.setText("WELCOME TO ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200, 40, 400, 40);
        this.add(l1);

        l2 = new JLabel();
        l2.setText("Card No:");
        l2.setFont(new Font("Osward", Font.BOLD, 28));
        l2.setBounds(180, 150, 220, 30);
        this.add(l2);

        l3 = new JLabel();
        l3.setText("Pin No:");
        l3.setFont(new Font("Osward", Font.BOLD, 28));
        l3.setBounds(198, 200, 220, 40);
        this.add(l3);

        tf1 = new JTextField();
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        tf1.setBounds(320, 157, 230, 30);
        this.add(tf1);

        pf2 = new JPasswordField();
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(320, 207, 230, 30);
        this.add(pf2);

        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(320, 280, 100, 40);
        b1.setFocusable(false);
        b1.addActionListener(this);
        this.add(b1);

        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(450, 280, 100, 40);
        b2.setFocusable(false);
        b2.addActionListener(this);
        this.add(b2);

        b3 = new JButton("LOGIN");
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFocusable(false);
        b3.setBounds(320, 350, 230, 40);
        b3.addActionListener(this);
        this.add(b3);

        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(new Dimension(800, 480));
        this.setLayout(null);
        this.setLocation(300, 100);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b2) {
            tf1.setText("");
            pf2.setText("");
        } else if (e.getSource() == b1) {
            this.setVisible(false);
            new SignUpOne().setVisible(true);
        } else if (e.getSource() == b3) {

            try {
                Conn c1 = new Conn();
                String cardNo = tf1.getText();
                String pin = pf2.getText();
                String query = "SELECT * FROM login WHERE cardNo = '" + cardNo + "' and pin = '" + pin + "'";
                ResultSet rs = c1.s.executeQuery(query);
                if (rs.next()) {
                    this.setVisible(false);
                    new Transaction(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Login("");
    }
}