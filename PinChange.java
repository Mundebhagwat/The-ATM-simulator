
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.AttributeSet;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3, l4;
    String pin;

    PinChange(String pin) {
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

        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(200, 225, 400, 30);
        l3.add(l1);

        l2 = new JLabel("New Pin: ");
        l2.setFont(new Font("Releway", Font.BOLD, 14));
        l2.setBounds(130, 260, 100, 20);
        l2.setForeground(Color.WHITE);
        l3.add(l2);

        l4 = new JLabel("Re-Enter Pin: ");
        l4.setFont(new Font("Releway", Font.BOLD, 14));
        l4.setBounds(130, 300, 150, 20);
        l4.setForeground(Color.WHITE);
        l3.add(l4);

        t1 = new JPasswordField();
        t1.setFont(new Font("Releway", Font.BOLD, 14));
        t1.setBounds(230, 260, 160, 20);

        t2 = new JPasswordField();
        t2.setFont(new Font("Releway", Font.BOLD, 14));
        t2.setBounds(230, 300, 160, 20);

        // Attach the NumericFilter
        PlainDocument doc1 = (PlainDocument) t1.getDocument();
        doc1.setDocumentFilter(new NumericFilter());

        PlainDocument doc2 = (PlainDocument) t2.getDocument();
        doc2.setDocumentFilter(new NumericFilter());

        l3.add(t1);
        l3.add(t2);

        b3 = new JButton("Change Pin");
        b3.setBounds(270, 380, 120, 20);
        b3.setFont(new Font("System", Font.BOLD, 12));
        b3.setFocusable(false);
        b3.addActionListener(this);
        l3.add(b3);

        b2 = new JButton("Back");
        b2.setBounds(270, 405, 120, 20);
        b2.setFocusable(false);
        b2.setFont(new Font("System", Font.BOLD, 12));
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
        try {
            if (e.getSource() == b3) {
                String newPin = new String(t1.getPassword());
                String rePin = new String(t2.getPassword());

                if (newPin.length() < 4) {
                    JOptionPane.showMessageDialog(null, "Pin must be at least 4 digit long!");
                    return;
                }

                if (rePin.length() < 4) {
                    JOptionPane.showMessageDialog(null, "Pin must be at least 4 digit long!");
                    return;
                }

                if (!newPin.equals(rePin)) {
                    JOptionPane.showMessageDialog(null, "Pin does not match");
                    return;
                }

                if (!rePin.equals(newPin)) {
                    JOptionPane.showMessageDialog(null, "Pin does not match");
                    return;
                }

                Conn c1 = new Conn();
                String query1 = "UPDATE sign_up3 SET pin = '" + rePin + "' WHERE pin = '" + pin + "'";
                String query2 = "UPDATE login SET pin = '" + rePin + "' WHERE pin = '" + pin + "'";
                String query3 = "UPDATE deposit SET pin = '" + rePin + "' WHERE pin = '" + pin + "'";

                c1.s.executeUpdate(query1);
                c1.s.executeUpdate(query2);
                c1.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Your pin is updated successfully");

                this.setVisible(false);
                new Transaction(rePin).setVisible(true);

            } else if (e.getSource() == b2) {
                this.setVisible(false);
                new Transaction(pin).setVisible(true);
            }

        } catch (Exception ae) {
            ae.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}