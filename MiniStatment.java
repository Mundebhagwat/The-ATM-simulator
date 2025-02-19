
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatment extends JFrame implements ActionListener {
    JButton b1;
    JLabel l1;
    String pin;
    JPanel contentpPanel;

    MiniStatment(String pin) {
        this.pin = pin;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(new Dimension(1200, 1200));
        this.setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);

        // Initialize contentpPanel first
        contentpPanel = new JPanel();
        contentpPanel.setBackground(Color.WHITE);
        contentpPanel.setLayout(null);
        contentpPanel.setPreferredSize(new Dimension(300, 1200));

        l1 = new JLabel();
        l1.setBounds(20, 130, 1200, 1200);
        l1.setFont(new Font("Releway", Font.BOLD, 16));
        contentpPanel.add(l1);

        JLabel l2 = new JLabel("Indian Post Payment Bank");
        l2.setBounds(30, 20, 400, 40);
        l2.setFont(new Font("Releway", Font.BOLD, 22));
        contentpPanel.add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 130, 400, 40);
        l3.setFont(new Font("Releway", Font.BOLD, 16));
        contentpPanel.add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 400, 30);
        l4.setFont(new Font("Releway", Font.BOLD, 16));
        contentpPanel.add(l4);

        JScrollPane scrollPane = new JScrollPane(contentpPanel);
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(16);

        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM login WHERE pin = '" + pin + "'");
            while (rs.next()) {
                l3.setText("Card Number: " + rs.getString("cardNo").substring(0, 4) + "XXXXXXXX"
                        + rs.getString("cardNo").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            double balance = 0.0;
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM deposit WHERE pin = '" + pin + "'");

            while (rs.next()) {
                l1.setText(l1.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("amount") + "<br><br><html>");

                if (rs.getString("type").equals("deposit")) {
                    balance += Double.parseDouble(rs.getString("amount"));
                } else {
                    balance -= Double.parseDouble(rs.getString("amount"));
                }
            }
            l4.setText("Your Current Balance: Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        b1 = new JButton("Exit");
        b1.setBounds(500, 10, 100, 30);
        b1.setFont(new Font("Releway", Font.BOLD, 16));
        b1.addActionListener(this);
        b1.setFocusable(false);
        contentpPanel.add(b1);

        this.setContentPane(scrollPane);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new MiniStatment("");
    }
}
