import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transaction extends JFrame implements ActionListener {
    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    Transaction(String pin) {
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

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");

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

        if (e.getSource() == b7) {
            System.exit(0);
        }

        if (e.getSource() == b1) {
            this.setVisible(false);
            new Deposit(pin).setVisible(true);
        }

        if (e.getSource() == b2) {
            this.setVisible(false);
            new Withdraw(pin).setVisible(true);
        }

        if (e.getSource() == b3) {
            this.setVisible(false);
            new FastCash(pin).setVisible(true);
        }

        if (e.getSource() == b5) {
            this.setVisible(false);
            new PinChange(pin).setVisible(true);
        }

        if (e.getSource() == b6) {
            this.setVisible(false);
            new BalemceEnquiry(pin).setVisible(true);
        }

        if (e.getSource() == b4) {
            new MiniStatment(pin).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Transaction("");
    }
}