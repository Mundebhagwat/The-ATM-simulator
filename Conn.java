
import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM_Simulator", "root", "Bhagwat@900");

            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() {

        return c;

    }

    public void close() {

        try {

            if (c != null && !c.isClosed()) {

                c.close();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
}