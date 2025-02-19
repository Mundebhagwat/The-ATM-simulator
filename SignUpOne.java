
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    JRadioButton r1, r2, r3, r4, r5;
    JButton b;
    JDateChooser dateChooser;
    JPanel contentPanel;

    Random random = new Random();
    long first4 = (random.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4); // this for positive val.

    SignUpOne() {

        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(850, 900));
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(300, 10);
        this.setLayout(null);

        l1 = new JLabel("APPLICATION FORM NO: " + first);
        l1.setFont(new Font("Railway", Font.BOLD, 38));

        l2 = new JLabel("Page 1: Personal Details");
        l2.setFont(new Font("Railway", Font.BOLD, 22));

        l3 = new JLabel("Name:");
        l3.setFont(new Font("Railway", Font.BOLD, 20));

        l3 = new JLabel("Name:");
        l3.setFont(new Font("Railway", Font.BOLD, 20));

        l4 = new JLabel("Middle Name:");
        l4.setFont(new Font("Railway", Font.BOLD, 20));

        l5 = new JLabel("Date of Birth:");
        l5.setFont(new Font("Railway", Font.BOLD, 20));

        l6 = new JLabel("Gender:");
        l6.setFont(new Font("Railway", Font.BOLD, 20));

        l7 = new JLabel("Email Address:");
        l7.setFont(new Font("Railway", Font.BOLD, 20));

        l8 = new JLabel("Maratial Status:");
        l8.setFont(new Font("Railway", Font.BOLD, 20));

        l9 = new JLabel("Address:");
        l9.setFont(new Font("Railway", Font.BOLD, 20));

        l10 = new JLabel("City:");
        l10.setFont(new Font("Railway", Font.BOLD, 20));

        l11 = new JLabel("Pin Code:");
        l11.setFont(new Font("Railway", Font.BOLD, 20));

        l12 = new JLabel("State:");
        l12.setFont(new Font("Railway", Font.BOLD, 20));

        l13 = new JLabel("Date:");
        l13.setFont(new Font("Railway", Font.BOLD, 20));

        l14 = new JLabel("Month:");
        l14.setFont(new Font("Railway", Font.BOLD, 20));

        l15 = new JLabel("Year:");
        l15.setFont(new Font("Railway", Font.BOLD, 20));

        t1 = new JTextField();
        t1.setFont(new Font("Railway", Font.BOLD, 14));

        t2 = new JTextField();
        t2.setFont(new Font("Railway", Font.BOLD, 14));

        t3 = new JTextField();
        t3.setFont(new Font("Railway", Font.BOLD, 14));

        t4 = new JTextField();
        t4.setFont(new Font("Railway", Font.BOLD, 14));

        t5 = new JTextField();
        t5.setFont(new Font("Railway", Font.BOLD, 14));

        t6 = new JTextField();
        t6.setFont(new Font("Railway", Font.BOLD, 14));

        t7 = new JTextField();
        t7.setFont(new Font("Railway", Font.BOLD, 14));

        t8 = new JTextField();
        t8.setFont(new Font("Railway", Font.BOLD, 14));

        t9 = new JTextField();
        t9.setFont(new Font("Railway", Font.BOLD, 14));

        t10 = new JTextField();
        t10.setFont(new Font("Railway", Font.BOLD, 14));

        b = new JButton("Next");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Railway", Font.BOLD, 14));

        r1 = new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Rialway", Font.BOLD, 14));

        r2 = new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Rialway", Font.BOLD, 14));

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        r3 = new JRadioButton("Married");
        r3.setBackground(Color.WHITE);
        r3.setFont(new Font("Rialway", Font.BOLD, 14));

        r4 = new JRadioButton("UnMarried");
        r4.setBackground(Color.WHITE);
        r4.setFont(new Font("Rialway", Font.BOLD, 14));

        r5 = new JRadioButton("Other");
        r5.setBackground(Color.WHITE);
        r5.setFont(new Font("Rialway", Font.BOLD, 14));

        ButtonGroup groupStatus = new ButtonGroup();
        groupStatus.add(r3);
        groupStatus.add(r4);
        groupStatus.add(r5);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        this.add(dateChooser);

        l1.setBounds(140, 20, 600, 40);
        contentPanel.add(l1);

        l2.setBounds(290, 80, 600, 30);
        contentPanel.add(l2);

        l3.setBounds(100, 130, 600, 30);
        contentPanel.add(l3);

        l4.setBounds(100, 180, 600, 30);
        contentPanel.add(l4);

        l5.setBounds(100, 230, 600, 30);
        contentPanel.add(l5);

        l6.setBounds(100, 280, 600, 30);
        contentPanel.add(l6);

        l7.setBounds(100, 330, 600, 30);
        contentPanel.add(l7);

        l8.setBounds(100, 380, 600, 30);
        contentPanel.add(l8);

        l9.setBounds(100, 430, 600, 30);
        contentPanel.add(l9);

        l10.setBounds(100, 480, 600, 30);
        contentPanel.add(l10);

        l11.setBounds(100, 530, 600, 30);
        contentPanel.add(l11);

        l12.setBounds(100, 580, 600, 30);
        contentPanel.add(l12);

        l13.setBounds(100, 630, 600, 30);
        contentPanel.add(l13);

        l14.setBounds(100, 680, 600, 30);
        contentPanel.add(l14);

        l15.setBounds(100, 730, 600, 30);
        contentPanel.add(l15);

        // text fields
        t1.setBounds(190, 130, 400, 30);
        contentPanel.add(t1);

        t2.setBounds(240, 180, 400, 30);
        contentPanel.add(t2);

        dateChooser.setBounds(250, 230, 200, 30);
        dateChooser.setForeground(Color.BLACK);
        contentPanel.add(dateChooser);

        r1.setBounds(200, 280, 100, 30);
        r1.setFocusable(false);
        contentPanel.add(r1);

        r2.setBounds(300, 280, 100, 30);
        r2.setFocusable(false);
        contentPanel.add(r2);

        t3.setBounds(250, 330, 400, 30);
        contentPanel.add(t3);

        r3.setBounds(250, 380, 100, 30);
        r3.setFocusable(false);
        contentPanel.add(r3);

        r4.setBounds(350, 380, 100, 30);
        r4.setFocusable(false);
        contentPanel.add(r4);

        r5.setBounds(450, 380, 100, 30);
        r5.setFocusable(false);
        contentPanel.add(r5);

        t4.setBounds(250, 430, 400, 30);
        contentPanel.add(t4);

        t5.setBounds(250, 480, 400, 30);
        contentPanel.add(t5);

        t6.setBounds(250, 530, 400, 30);
        contentPanel.add(t6);

        t7.setBounds(250, 580, 400, 30);
        contentPanel.add(t7);

        t8.setBounds(250, 630, 400, 30);
        contentPanel.add(t8);

        t9.setBounds(250, 680, 400, 30);
        contentPanel.add(t9);

        t10.setBounds(250, 730, 400, 30);
        contentPanel.add(t10);

        b = new JButton("Next");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Osward", Font.BOLD, 14));
        b.setBounds(530, 770, 100, 30);
        b.setFocusable(false);
        b.addActionListener(this);
        contentPanel.add(b);

        // this will scrolle the content as needed
        contentPanel.setPreferredSize(new Dimension(1500, 850));
        JScrollPane scrollPane = new JScrollPane(contentPanel);

        // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // increase the speed of scroll
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(16);

        this.setContentPane(scrollPane);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String formnm = first;
        String name = t1.getText();
        String middle_name = t2.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (r1.isSelected()) {
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        }

        String email = t3.getText();
        String maratial = null;
        if (r3.isSelected()) {
            maratial = "Married";
        } else if (r4.isSelected()) {
            maratial = "UnMarried";
        } else if (r5.isSelected()) {
            maratial = "Other";
        }

        String addres = t4.getText();
        String city = t5.getText();
        String pincode = t6.getText();
        String state = t7.getText();
        String date = t8.getText();
        String month = t9.getText();
        String year = t10.getText();

        Conn c1 = null;
        PreparedStatement pstmt = null;
        try {
            c1 = new Conn(); // Assuming this initializes the connection correctly
            String query = "INSERT INTO sign_up (formnm, name, middle_name, gender, email, maratial, addres, city, pincode, state, dob, date, month, year) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = c1.getConnection().prepareStatement(query);

            // Set parameters for the query
            pstmt.setString(1, formnm);
            pstmt.setString(2, name);
            pstmt.setString(3, middle_name);
            pstmt.setString(4, gender);
            pstmt.setString(5, email);
            pstmt.setString(6, maratial);
            pstmt.setString(7, addres);
            pstmt.setString(8, city);
            pstmt.setString(9, pincode);
            pstmt.setString(10, state);
            pstmt.setString(11, dob);
            pstmt.setString(12, date);
            pstmt.setString(13, month);
            pstmt.setString(14, year);

            // Execute the query
            pstmt.executeUpdate();
            // Hide the current frame
            JOptionPane.showMessageDialog(this, "Details submitted successfully!");
            new SignUpTwo(formnm).setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage());
        } finally {
            // Close resources
            try {
                if (pstmt != null) {
                    pstmt.close();
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
        new SignUpOne();
    }
}
// command for run to this file
// javac -cp ".;lib/*" SignUpOne.java
// java -cp ".;lib/*" SignUpOne
