package MyFirstTestNGPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;


public class GetDataFromDb {
	
	String url="jdbc:sqlserver://localhost:1433;"+ "databaseName=SubodhDb; integratedSecurity=true;";

	String username ="Subodh-PC\\Subodh";
	String password="";
	Connection conn;
	ResultSet result;
	
	@Test
	public void getData() throws SQLException, ClassNotFoundException {
	
	//Initialize Sqldriver instance 
	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	 // Creating the connection providing URL and username password
	   conn = DriverManager.getConnection(url);

	 //Checking for the connection( returns boolean false if connected)
	   System.out.println(conn.isClosed());
	   
	   String query = "SELECT * from Emp_Details";
	   // Providing the query under prepareStatement parameter 
	      PreparedStatement pst=conn.prepareStatement(query);

	   //Command to execute query and capturing all the result under Result set 
	      result=pst.executeQuery();
	       while(result.next()) {

	    //Printing the 1 column 2 column and 6 column of the table
	       System.out.println(result.getString(1)+ "   "+ result.getString(2) +"   " +result.getString(6));

}
}
}