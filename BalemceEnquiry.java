import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalemceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;

    BalemceEnquiry(String pin) {
        this.pin = pin;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(700, 700));
        this.setLayout(null);
        this.setLocation(200, 10);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 700, 700);
        this.add(l3);

        l1 = new JLabel();
        l1.setFont(new Font("Releway", Font.BOLD, 15));
        l1.setBounds(120, 230, 400, 40);
        l1.setForeground(Color.WHITE);
        l3.add(l1);

        b1 = new JButton("Back");
        b1.setBounds(270, 405, 120, 20);
        b1.setFocusable(false);
        b1.setFont(new Font("System", Font.BOLD, 12));
        b1.addActionListener(this);
        l3.add(b1);

        double balance = 0.0;
        try {

            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM deposit WHERE pin = '" + pin + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    balance += Double.parseDouble(rs.getString("amount"));
                } else {
                    balance -= Double.parseDouble(rs.getString("amount"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        l1.setText("<html>Your current Bank balance is: <br> Rs " + balance + "</html>");

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        new Transaction(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalemceEnquiry("");
    }
}