
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    JTextField t1;
    JButton b1, b2;
    JLabel l1, l3;
    String pin;

    Withdraw(String pin) {
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

        l1 = new JLabel("ENTER THE AMOUNT YOU WANT TO WITHDRAW");
        l1.setFont(new Font("System", Font.BOLD, 12));
        l1.setForeground(Color.WHITE);
        l1.setBounds(128, 225, 400, 30);
        l3.add(l1);

        t1 = new JTextField();
        t1.setFont(new Font("Releway", Font.BOLD, 14));
        t1.setBounds(130, 260, 250, 30);

        // Attach the NumericFilter
        PlainDocument doc = (PlainDocument) t1.getDocument();
        doc.setDocumentFilter(new NumericFilter());

        l3.add(t1);

        b1 = new JButton("Withdraw");
        b1.setBounds(290, 380, 100, 20);
        b1.setFocusable(false);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("Exit");
        b2.setBounds(290, 405, 100, 20);
        b2.setFocusable(false);
        b2.addActionListener(this);
        l3.add(b2);

        this.setVisible(true);
    }

    static class NumericFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if (string.matches("\\d+")) { // Allow only digits
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (text.matches("\\d+")) { // Allow only digits
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        Conn c1 = new Conn();
        PreparedStatement pstmt = null;
        if (e.getSource() == b1) {
            String amountText = t1.getText();
            Date date = new Date();
            if (amountText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw.");
            } else {
                double amount = Double.parseDouble(amountText);
                try {
                    // Fetch the current balance
                    ResultSet rs = c1.s.executeQuery("SELECT * FROM deposit WHERE pin = '" + pin + "'");
                    double balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("deposit")) {
                            balance += Double.parseDouble(rs.getString("amount"));
                        } else {
                            balance -= Double.parseDouble(rs.getString("amount"));
                        }
                    }

                    if (balance < amount) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance.");
                        return;
                    }

                    // Insert the withdrawal record into the bank table
                    String query = "INSERT INTO deposit (pin, date, type, amount) VALUES (?, ?, ?, ?)";
                    pstmt = c1.getConnection().prepareStatement(query);
                    pstmt.setString(1, pin);
                    pstmt.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
                    pstmt.setString(3, "withdrawal");
                    pstmt.setDouble(4, amount);

                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " withdrawn successfully.");

                    // Redirect or update UI as needed
                    this.setVisible(false);
                    new Transaction(pin).setVisible(true);

                } catch (Exception ae) {
                    ae.printStackTrace();
                }
            }
        }

        if (e.getSource() == b2) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
