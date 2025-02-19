import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SignUpTwo extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    JButton b;
    JRadioButton r1, r2, r3, r4;
    JTextField t1, t2, t3;
    JComboBox<String> c1, c2, c3, c4, c5;
    String formnm;

    public SignUpTwo(String formnm) {
        this.formnm = formnm;
        this.formnm = formnm;
        this.setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2 ");
        this.setSize(new Dimension(700, 700));
        this.setLocation(200, 10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        l1 = new JLabel("Page 2: Additional Details");
        l1.setFont(new Font("Releway", Font.BOLD, 22));

        l2 = new JLabel("Religion:");
        l2.setFont(new Font("Releway", Font.BOLD, 22));

        l3 = new JLabel("Catogary:");
        l3.setFont(new Font("Releway", Font.BOLD, 22));

        l4 = new JLabel("Income:");
        l4.setFont(new Font("Releway", Font.BOLD, 22));

        l5 = new JLabel("Educational");
        l5.setFont(new Font("Releway", Font.BOLD, 22));

        l6 = new JLabel("Qualification:");
        l6.setFont(new Font("Releway", Font.BOLD, 22));

        l7 = new JLabel("Occupation:");
        l7.setFont(new Font("Releway", Font.BOLD, 22));

        l8 = new JLabel("Pan Number:");
        l8.setFont(new Font("Releway", Font.BOLD, 22));

        l9 = new JLabel("Addhar Number:");
        l9.setFont(new Font("Releway", Font.BOLD, 22));

        l10 = new JLabel("Senior Citizen:");
        l10.setFont(new Font("Releway", Font.BOLD, 22));

        l11 = new JLabel("Existing Account");
        l11.setFont(new Font("Releway", Font.BOLD, 22));

        l12 = new JLabel("Form No:");
        l12.setFont(new Font("Releway", Font.BOLD, 22));

        l13 = new JLabel(formnm);
        l13.setFont(new Font("Releway", Font.BOLD, 22));

        b = new JButton("Next");
        b.setFont(new Font("Releway", Font.BOLD, 14));
        b.setFocusable(false);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Releway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Releway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        ButtonGroup sGroup = new ButtonGroup();
        sGroup.add(r1);
        sGroup.add(r2);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Releway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Releway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);

        ButtonGroup existing = new ButtonGroup();
        existing.add(r3);
        existing.add(r4);

        String[] religion = { "Hindu", "Muslim", "Sikh", "Christian", "Other" };
        c1 = new JComboBox<>(religion);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Releway", Font.BOLD, 14));

        String[] category = { "General", "OBC", "SC", "ST", "Other" };
        c2 = new JComboBox<>(category);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Releway", Font.BOLD, 14));

        String[] income = { "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000" };
        c3 = new JComboBox<>(income);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Releway", Font.BOLD, 14));

        String[] education = { "Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others" };
        c4 = new JComboBox<>(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Releway", Font.BOLD, 14));

        String[] occupation = { "Salaried", "Self-Employmed", "Business", "Student", "Retired", "Others" };
        c5 = new JComboBox<>(occupation);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Releway", Font.BOLD, 14));

        l1.setBounds(170, 30, 600, 40);
        this.add(l1);

        l2.setBounds(120, 80, 600, 30);
        this.add(l2);

        l3.setBounds(120, 130, 600, 30);
        this.add(l3);

        l4.setBounds(120, 180, 600, 30);
        this.add(l4);

        l5.setBounds(120, 230, 600, 30);
        this.add(l5);

        l6.setBounds(120, 260, 600, 30);
        this.add(l6);

        l7.setBounds(120, 330, 600, 30);
        this.add(l7);

        l8.setBounds(120, 380, 600, 30);
        this.add(l8);

        l9.setBounds(120, 430, 600, 30);
        this.add(l9);

        l10.setBounds(120, 480, 600, 30);
        this.add(l10);

        l11.setBounds(120, 530, 600, 30);
        this.add(l11);

        l12.setBounds(500, 10, 100, 40);
        this.add(l12);

        l13.setBounds(600, 10, 100, 40);
        this.add(l13);

        c1.setBounds(350, 85, 200, 30);
        this.add(c1);

        c2.setBounds(350, 135, 200, 30);
        this.add(c2);

        c3.setBounds(350, 185, 300, 30);
        this.add(c3);

        c4.setBounds(350, 240, 300, 30);
        this.add(c4);

        c5.setBounds(350, 330, 300, 30);
        this.add(c5);

        t1.setBounds(350, 380, 300, 30);
        this.add(t1);

        t2.setBounds(350, 430, 300, 30);
        this.add(t2);

        r1.setBounds(350, 480, 50, 30);
        r1.setFocusable(false);
        this.add(r1);

        r2.setBounds(450, 480, 50, 30);
        r2.setFocusable(false);
        this.add(r2);

        r3.setBounds(350, 535, 50, 30);
        r3.setFocusable(false);
        this.add(r3);

        r4.setBounds(450, 535, 50, 30);
        r4.setFocusable(false);
        this.add(r4);

        b.setBounds(550, 600, 100, 30);
        this.add(b);

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String formnm = (String) l13.getText();
        String religion = (String) c1.getSelectedItem();
        String category = (String) c2.getSelectedItem();
        String income = (String) c3.getSelectedItem();
        String education = (String) c4.getSelectedItem();
        String occupation = (String) c5.getSelectedItem();

        String pan = t1.getText();
        String aadhar = t2.getText();

        String scitizen = "";
        if (r1.isSelected()) {
            scitizen = "Yes";
        } else if (r2.isSelected()) {
            scitizen = "No";
        }

        String eaccount = "";
        if (r3.isSelected()) {
            eaccount = "Yes";
        } else if (r4.isSelected()) {
            eaccount = "No";
        }

        Conn c1 = null;
        PreparedStatement pstmt = null;
        try {
            c1 = new Conn(); // Assuming this initializes the connection correctly
            String query = "INSERT INTO sign_up2 (formnm,religion, category, income, education, occupation, pan, aadhar, scitizen, eaccount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            pstmt = c1.getConnection().prepareStatement(query);

            // Set parameters for the query
            pstmt.setString(1, formnm);
            pstmt.setString(2, religion);
            pstmt.setString(3, category);
            pstmt.setString(4, income);
            pstmt.setString(5, education);
            pstmt.setString(6, occupation);
            pstmt.setString(7, pan);
            pstmt.setString(8, aadhar);
            pstmt.setString(9, scitizen);
            pstmt.setString(10, eaccount);

            // Execute the query
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Details submitted successfully!");
            new SIgnUpThree(formnm).setVisible(true);
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
        new SignUpTwo("");
    }
}
