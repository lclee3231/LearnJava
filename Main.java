import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn = null;

		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost/gyro?" +
		                                   "user=root&password=admin");

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		 PreparedStatement ps;
		try {
			ps = conn.prepareStatement("UPDATE locater_status SET status = ?, time=NOW() WHERE id = ? ");
			ps.setInt(1,2); // status 0=尚未連線,1=已連線,2=timeout
			ps.setInt(2,1); // locator id
			
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
