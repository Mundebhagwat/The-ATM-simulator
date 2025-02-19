import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    FastCash(String pin) {

        this.pin = pin;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(700, 700));
        this.setLocation(300, 10);
        getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 700, 700);
        this.add(l2);

        l1 = new JLabel("Please select your Transaction");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(150, 225, 400, 40);
        l1.setForeground(Color.WHITE);
        l2.add(l1);

        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("Back");

        b1.setBounds(125, 320, 100, 20);
        b1.setFont(new Font("System", Font.BOLD, 10));
        b1.setFocusable(false);
        b1.addActionListener(this);
        l2.add(b1);

        b2.setBounds(260, 320, 140, 20);
        b2.setFont(new Font("System", Font.BOLD, 10));
        b2.setFocusable(false);
        b2.addActionListener(this);
        l2.add(b2);

        b3.setBounds(125, 350, 100, 20);
        b3.setFont(new Font("System", Font.BOLD, 10));
        b3.setFocusable(false);
        b3.addActionListener(this);
        l2.add(b3);

        b4.setBounds(260, 350, 140, 20);
        b4.setFont(new Font("System", Font.BOLD, 10));
        b4.setFocusable(false);
        b4.addActionListener(this);
        l2.add(b4);

        b5.setBounds(125, 380, 100, 20);
        b5.setFont(new Font("System", Font.BOLD, 10));
        b5.setFocusable(false);
        b5.addActionListener(this);
        l2.add(b5);

        b6.setBounds(260, 380, 140, 20);
        b6.setFont(new Font("System", Font.BOLD, 10));
        b6.setFocusable(false);
        b6.addActionListener(this);
        l2.add(b6);

        b7.setBounds(300, 405, 100, 20);
        b7.setFont(new Font("System", Font.BOLD, 10));
        b7.setFocusable(false);
        b7.addActionListener(this);
        l2.add(b7);

        this.setUndecorated(true);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == b7) {
                this.setVisible(false);
                new Transaction(pin).setVisible(true);
                return;
            }
            JButton button = (JButton) e.getSource();
            Double amount = Double.parseDouble(button.getText().substring(3));
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM deposit WHERE pin = '" + pin + "'");
            double balance = 0.0;
            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    balance += Double.parseDouble(rs.getString("amount"));
                } else {
                    balance -= Double.parseDouble(rs.getString("amount"));
                }
            }
            if (e.getSource() != b7 && balance < amount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balence!");
                return;
            }

            Date date = new Date();
            String query = "INSERT INTO deposit (pin, date, type, amount) VALUES(?, ?, ?, ?)";
            PreparedStatement pstmt = null;
            pstmt = c1.getConnection().prepareStatement(query);

            pstmt.setString(1, pin);
            // option 1 to pass date
            // pstmt.setString(2, date.toString());
            // option 2
            pstmt.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
            pstmt.setString(3, "withdrawal");
            pstmt.setDouble(4, amount);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

            this.setVisible(false);
            new Transaction(pin).setVisible(true);

        } catch (Exception ae) {
            ae.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new FastCash("");

    }
}