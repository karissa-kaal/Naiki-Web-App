package Ride.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import Ride.Ride;

public class RideDao {
	public int generateRide(Ride ride) throws ClassNotFoundException {
        String INSERT_RIDE_SQL = "INSERT INTO Ride" +
            "  (rideID, pickup, donor, statusOfRide) VALUES  " +
            " (?, ?, ?, ?);";
        String GET_ID_SQL = "SELECT rideid FROM ride ORDER BY rideid DESC LIMIT 1;";

        int result = 0;
        int maxid = 0;

        Class.forName("com.mysql.jdbc.Driver");
        
        System.out.println("CHECK-1");
        
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");

                // Step 2:Create a statement using connection object
                PreparedStatement getid = connection.prepareStatement(GET_ID_SQL)) {
        		ResultSet rs = getid.executeQuery();
        		maxid = rs.getInt("rideid");

                System.out.println(maxid);
        		
		 } catch (SQLException e) {
	         // process sql exception
	         printSQLException(e);
	     }

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RIDE_SQL)) {
        	maxid = maxid + 1;
        	ride.setId(maxid);
            preparedStatement.setInt(1, maxid);
  
            preparedStatement.setString(2, ride.getPickupLocation());
            //preparedStatement.setDate(3, ride.getDate());
            preparedStatement.setString(3, ride.get_donor().getUsername());
            preparedStatement.setString(4, ride.getStatus().toString());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
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
