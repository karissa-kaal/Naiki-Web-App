package Donor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import Donor.bean.DonorBean;
import LoginManagement.bean.LoginManagement;
import Rider.bean.RiderBean;


public class DonorDao {

    public int registerDonor(DonorBean User) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO Donor" +
            "  (username, pass, firstname, lastname, phoneNo, address) VALUES  " +
            " (?, ?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
        	
            preparedStatement.setString(1, User.getUsername());
            preparedStatement.setString(2, User.getPasscode());
            preparedStatement.setString(3, User.getFName());
            preparedStatement.setString(4, User.getLName());
            preparedStatement.setString(5, User.getphone());
            preparedStatement.setString(6, User.getAddress());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    
    public DonorBean selectDonor() {
    	DonorBean Donor = null;
		// Step 1: Establishing a Connection
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("Select * from Donor where username = ?");) {
			preparedStatement.setString(1, LoginManagement.getCurrentDonor().getUsername());
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String uname = rs.getString("username");
				String password = rs.getString("pass");
				String fname = rs.getString("firstName");
				String lname = rs.getString("lastName");
				String phone = rs.getString("phoneNo");
				String address = rs.getString("address");
				
				Donor = new DonorBean(uname, password, fname, lname, phone, address);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Donor;
	}
    
    public void editDonor(DonorBean User) throws ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
		String EDIT_DONOR_SQL = "update donor set pass= ?, firstname =?, lastname =?, phoneNo =?, address =? where username = ?;";
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");
			PreparedStatement preparedStatement = connection.prepareStatement(EDIT_DONOR_SQL);) {
            preparedStatement.setString(1, User.getPasscode());
            preparedStatement.setString(2, User.getFName());
            preparedStatement.setString(3, User.getLName());
            preparedStatement.setString(4, User.getphone());
			preparedStatement.setString(5, User.getAddress());
			preparedStatement.setString(6, User.getUsername());

			preparedStatement.executeUpdate();
		}catch (SQLException e) {
            printSQLException(e);
        }
	}
    
    public boolean validateUser(DonorBean CurrentDonor) throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from Donor where username = ? and pass = ? ")) {
            preparedStatement.setString(1, CurrentDonor.getUsername());
            preparedStatement.setString(2, CurrentDonor.getPasscode());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            return rs.next();


        } catch (SQLException e) {
            printSQLException(e);
        }
        return false;
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