package lms;
import java.sql.*;


public class Connectionclass {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=(Connection)DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","System","123456789");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from login");
			while(rs.next());
		}catch(Exception e) {
			e.printStackTrace();
		}
          return con;
	}

}
