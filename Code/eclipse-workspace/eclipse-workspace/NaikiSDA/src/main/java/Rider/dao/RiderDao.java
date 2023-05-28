package Rider.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import LoginManagement.bean.LoginManagement;
import Ride.Ride;

import java.sql.ResultSet;

import Rider.bean.RiderBean;


public class RiderDao {

    public int registerRider(RiderBean User) throws ClassNotFoundException {
        String INSERT_RIDER_SQL = "INSERT INTO Rider" +
            "  (username, pass, firstname, lastname, phoneNo) VALUES  " +
            " (?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RIDER_SQL)) {
        	
            preparedStatement.setString(1, User.getUsername());
            preparedStatement.setString(2, User.getPasscode());
            preparedStatement.setString(3, User.getFName());
            preparedStatement.setString(4, User.getLName());
            preparedStatement.setString(5, User.getphone());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    
    public void editRider(RiderBean User) throws ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
		String EDIT_RIDER_SQL = "update rider set pass= ?, firstname =?, lastname =?, phoneNo =? where username = ?;";
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");
			PreparedStatement preparedStatement = connection.prepareStatement(EDIT_RIDER_SQL);) {
            preparedStatement.setString(1, User.getPasscode());
            preparedStatement.setString(2, User.getFName());
            preparedStatement.setString(3, User.getLName());
            preparedStatement.setString(4, User.getphone());
			preparedStatement.setString(5, User.getUsername());

			preparedStatement.executeUpdate();
		}catch (SQLException e) {
            printSQLException(e);
        }
	}
    
    public int deleteRider(RiderBean User) throws ClassNotFoundException {
		int Result = 0;
		Class.forName("com.mysql.jdbc.Driver");
		String DELETE_RIDER_SQL = "delete from rider where username = ?;";
		 try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RIDER_SQL);) {
			preparedStatement.setString(1, User.getUsername());
			Result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Result;
	}
    
    protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
    
    private String jdbcURL = "jdbc:mysql://localhost:3306/Naiki?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "12345678";
	
	private static final String SELECT_ALL_RIDERS = "select * from Rider";
    
    public List<RiderBean> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<RiderBean> riders = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RIDERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("username");
				String pass = rs.getString("pass");
				String firstN = rs.getString("firstName");
				String LastN = rs.getString("lastName");
				String phone = rs.getString("phoneNo");
				
				
				riders.add(new RiderBean(name, pass , firstN, LastN, phone));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return riders;
	}
    
    public RiderBean selectRider() {
		RiderBean rider = null;
		// Step 1: Establishing a Connection
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("Select * from rider where username = ?");) {
			preparedStatement.setString(1, LoginManagement.getCurrentRider().getUsername());
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
				
				rider = new RiderBean(uname, password, fname, lname, phone);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rider;
	}
    
    public boolean validateUser(RiderBean CurrentRider) throws ClassNotFoundException {
        //boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from Rider where username = ? and pass = ? ")) {
            preparedStatement.setString(1, CurrentRider.getUsername());
            preparedStatement.setString(2, CurrentRider.getPasscode());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return false;
    }
    
    public RiderBean findRider(Ride ride) throws ClassNotFoundException {
        //boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");
        RiderBean riderfound = null;
        
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");

            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from Rider where currentride is NULL")) {

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                riderfound = new RiderBean(rs.getString("username"), rs.getString("pass"));
                riderfound.setFName(rs.getString(3));
                riderfound.setLName(rs.getString(4));
                riderfound.setPhone(rs.getString(5));
                riderfound.setCurrentride(ride);
            }

            try (Connection connection2 = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/Naiki?useSSL=false", "root", "123456");

                    PreparedStatement preparedStatement2 = connection2
                    .prepareStatement("Update rider set currentride = ? where username = ?")) {
            		preparedStatement2.setInt(1, ride.getId());
            		preparedStatement2.setString(2, riderfound.getUsername());
                    System.out.println(preparedStatement2);
                    preparedStatement2.executeQuery();

                } catch (SQLException e) {
                    printSQLException(e);
                }
        } catch (SQLException e) {
            printSQLException(e);
        }
        
        return riderfound;
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