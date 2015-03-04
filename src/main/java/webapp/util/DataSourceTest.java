package webapp.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataSourceTest {
	
	
	public static void main(String[] args) throws SQLException {
		String className = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		
		EmployeeDataSource ds = new EmployeeDataSource();
		ds.setClassName(className);
		ds.setUrl(url);
		ds.setUser(user);
		ds.setPassword(password);
		
		Connection con = ds.getConnection();
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select 1+1 from dual");
		
		rs.next();
		
		Integer sum = rs.getInt(1);
		System.out.println(sum);
		
	}
	
}
