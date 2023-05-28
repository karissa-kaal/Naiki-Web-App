package Admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import Admin.bean.AdminBean;


public class AdminDao {

    public int registerAdmin(AdminBean User) throws ClassNotFoundException {
        String INSERT_ADMIN_SQL = "INSERT INTO NaikiAdmin" +
            "  (username, pass, firstname, lastname) VALUES  " +
            " (?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL)) {
        	
            preparedStatement.setString(1, User.getUsername());
            preparedStatement.setString(2, User.getPasscode());
            preparedStatement.setString(3, User.getFName());
            preparedStatement.setString(4, User.getLName());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    
    public boolean validateUser(AdminBean CurrentAdmin) throws ClassNotFoundException {
       // boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from naikiAdmin where username = ? and pass = ? ")) {
            preparedStatement.setString(1, CurrentAdmin.getUsername());
            preparedStatement.setString(2, CurrentAdmin.getPasscode());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return false;
    }
    
    public int deleteAdmin(AdminBean User) throws ClassNotFoundException {
		int Result = 0;
		Class.forName("com.mysql.jdbc.Driver");
		String DELETE_ADMIN_SQL = "delete from admin where username = ?;";
		 try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADMIN_SQL);) {
			preparedStatement.setString(1, User.getUsername());
			Result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Result;
	}

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}