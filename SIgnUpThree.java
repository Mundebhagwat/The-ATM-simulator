import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SIgnUpThree extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JRadioButton r1, r2, r3, r4;
    JButton b1, b2;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    String formnm;

    public SIgnUpThree(String formnm) {
        this.formnm = formnm;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(700, 800));
        getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);
        this.setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        this.setLocation(300, 100);

        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Relewya", Font.BOLD, 22));

        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Relewya", Font.BOLD, 18));

        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Relewya", Font.BOLD, 18));

        l4 = new JLabel("XXXX-XXXX-XXXX-4249");
        l4.setFont(new Font("Relewya", Font.BOLD, 18));

        l5 = new JLabel("Your 16 digit card number");
        l5.setFont(new Font("Relewya", Font.BOLD, 12));

        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));

        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Relewya", Font.BOLD, 18));

        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Relewya", Font.BOLD, 18));

        l9 = new JLabel("(4-digit-password)");
        l9.setFont(new Font("Relewya", Font.BOLD, 12));

        l10 = new JLabel("Service Required:");
        l10.setFont(new Font("Relewya", Font.BOLD, 18));

        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Relewya", Font.BOLD, 18));

        l12 = new JLabel(formnm);
        l12.setFont(new Font("Relewya", Font.BOLD, 18));

        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFocusable(false);
        b1.addActionListener(this);
        b1.setFont(new Font("Relewya", Font.BOLD, 18));
        this.add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFocusable(false);
        b2.addActionListener(this);
        b2.setFont(new Font("Relewya", Font.BOLD, 18));
        this.add(b2);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Releway", Font.BOLD, 16));

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Releway", Font.BOLD, 16));

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Releway", Font.BOLD, 16));

        c4 = new JCheckBox("Email Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Releway", Font.BOLD, 16));

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Releway", Font.BOLD, 16));

        c6 = new JCheckBox("E-Statmente");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Releway", Font.BOLD, 16));

        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",
                true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Releway", Font.BOLD, 12));

        r1 = new JRadioButton("Saving Account");
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Releway", Font.BOLD, 16));
        r1.setFocusable(false);
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Releway", Font.BOLD, 16));
        r2.setFocusable(false);
        r2.setBackground(Color.WHITE);

        r3 = new JRadioButton("Current Account");
        r3.setBackground(Color.WHITE);
        r3.setFont(new Font("Releway", Font.BOLD, 16));
        r3.setFocusable(false);
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBackground(Color.WHITE);
        r4.setFont(new Font("Releway", Font.BOLD, 16));
        r4.setFocusable(false);
        r4.setBackground(Color.WHITE);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);

        l1.setBounds(200, 10, 600, 40);
        this.add(l1);

        l2.setBounds(100, 70, 400, 30);
        this.add(l2);

        l3.setBounds(100, 200, 400, 30);
        this.add(l3);

        l4.setBounds(280, 200, 400, 30);
        this.add(l4);

        l5.setBounds(100, 215, 400, 30);
        this.add(l5);

        l6.setBounds(100, 225, 500, 30);
        this.add(l6);

        l7.setBounds(100, 270, 400, 30);
        this.add(l7);

        l8.setBounds(280, 270, 200, 30);
        this.add(l8);

        l9.setBounds(100, 285, 200, 30);
        this.add(l9);

        l10.setBounds(100, 330, 400, 30);
        this.add(l10);

        l11.setBounds(500, 10, 200, 30);
        this.add(l11);

        l12.setBounds(650, 10, 100, 30);
        this.add(l12);

        r1.setBounds(250, 70, 200, 30);
        this.add(r1);

        r2.setBounds(450, 70, 200, 30);
        this.add(r2);

        r3.setBounds(250, 130, 200, 30);
        this.add(r3);

        r4.setBounds(450, 130, 300, 30);
        this.add(r4);

        c1.setBounds(280, 330, 200, 30);
        c1.setFocusable(false);
        this.add(c1);

        c2.setBounds(500, 330, 300, 30);
        c2.setFocusable(false);
        this.add(c2);

        c3.setBounds(280, 390, 200, 30);
        c3.setFocusable(false);
        this.add(c3);

        c4.setBounds(500, 390, 350, 30);
        c4.setFocusable(false);
        this.add(c4);

        b1.setBounds(200, 460, 100, 30);
        this.add(b1);

        b2.setBounds(400, 460, 100, 30);
        this.add(b2);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String aType = null;
        if (r1.isSelected()) {
            aType = "Saving Account";
        } else if (r2.isSelected()) {
            aType = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            aType = "Current Account";
        } else if (r4.isSelected()) {
            aType = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 1849709000000000L;
        String cardNo = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String facility = "";
        if (c1.isSelected()) {
            facility = facility + " ATM Card";
        }
        if (c2.isSelected()) {
            facility = facility + " Internet Banking";
        }
        if (c3.isSelected()) {
            facility = facility + " Mobile Banking";
        }
        if (c4.isSelected()) {
            facility = facility + " EMAIL Alerts";
        }
        if (c5.isSelected()) {
            facility = facility + " Cheque Book";
        }
        if (c6.isSelected()) {
            facility = facility + " E-Statement";
        }

        Conn c1 = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {

            if (e.getSource() == b1) {
                c1 = new Conn(); // Assuming this initializes the connection correctly
                String query1 = "INSERT INTO sign_up3 (formnm, aType, cardNo, pin, facility) VALUES (?, ?, ?, ?, ?)";
                pstmt1 = c1.getConnection().prepareStatement(query1);

                // Set parameters for the query1
                pstmt1.setString(1, formnm);
                pstmt1.setString(2, aType);
                pstmt1.setString(3, cardNo);
                pstmt1.setString(4, pin);
                pstmt1.setString(5, facility);

                // Exicute query1
                pstmt1.executeUpdate();

                String query2 = "INSERT INTO login (formnm, cardNo, pin) VALUES(?, ?, ?)";
                pstmt2 = c1.getConnection().prepareStatement(query2);

                // Set parameters for the query2
                pstmt2.setString(1, formnm);
                pstmt2.setString(2, cardNo);
                pstmt2.setString(3, pin);

                // Execute the query2
                pstmt2.executeUpdate();
                JOptionPane.showMessageDialog(this, "CardNo: " + cardNo + "\n Pin: " + pin);
                this.setVisible(false);
                new Transaction(pin).setVisible(true);
            } else if (e.getSource() == b2) {
                System.exit(0);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage());
        } finally {
            // Close resources
            try {
                if (pstmt1 != null && pstmt2 != null) {
                    pstmt1.close();
                    pstmt2.close();
                }
                if (c1 != null && c1.getConnection() != null) {
                    c1.getConnection().close(); // Close the actual connection
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new SIgnUpThree("");
    }
}