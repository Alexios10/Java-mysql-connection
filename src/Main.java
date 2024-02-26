
import java.sql.*;

public class Main {
  // JDBC URL, username, and password of MySQL server
  private static final String JDBC_URL = "jdbc:mysql://localhost:3306/brettspill?characterEncoding=UTF-8";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "sattar";

  public static void main(String[] args) {
    try {
      // Load the MySQL JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      // Establish a connection to MySQL database
      Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

      if (connection != null) {
        // Create a SQL statement
        Statement statement = connection.createStatement();

        // Execute a query
        ResultSet resultSet = statement.executeQuery("SELECT * FROM spiller");

        // Process the result set
        while (resultSet.next()) {

          int id = resultSet.getInt("spiller_id");
          String name = resultSet.getString("navn");
          // Retrieve other columns as needed
          System.out.println("ID: " + id + ", Navn: " + name);
          
        }
        resultSet.close();
        statement.close();
        connection.close();
      }
    } catch (ClassNotFoundException e) {
      System.err.println("MySQL JDBC driver not found!");
      e.printStackTrace();
    } catch (SQLException e) {
      System.err.println("Failed to connect to MySQL!");
      e.printStackTrace();
    }
  }
}
