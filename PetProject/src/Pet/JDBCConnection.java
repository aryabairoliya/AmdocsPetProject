package Pet;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	Connection con;
	public Connection getConnection() {
		
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver"); //registration
			 con=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:orcl","scott","tiger"); //connection
		 }catch(Exception e) {
			 System.out.println("error in connection");
		 }
		 return con;
	 }
	
}
