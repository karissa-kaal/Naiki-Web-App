package DisplayDonorsList.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Donor.bean.DonorBean;

public class DonorsListDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/Naiki?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "12345678";
	
	private static final String SELECT_ALL_DONORS = "select * from Donor";
	
	public DonorsListDao() {
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

	
	public List<DonorBean> selectAllDonors() {

		List<DonorBean> donors = new ArrayList<>();
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DONORS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("username");
				String pass = rs.getString("pass");
				String firstN = rs.getString("firstName");
				String LastN = rs.getString("lastName");
				String phone = rs.getString("phoneNo");
				String address = rs.getString("address");
				
				
				donors.add(new DonorBean(name, pass , firstN, LastN, phone, address));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return donors;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
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
