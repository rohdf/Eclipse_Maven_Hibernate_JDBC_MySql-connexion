package myConnection.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import nsis.util.ConfigurationService;
import nsis.util.JDBCManager;

public class HelloWorldApp {

	public static void main(String[] args) {
		System.out.println("Hello world !! ");
		
		try {
			ConfigurationService confService = new ConfigurationService("/home/rfrimat/Documents/JAVA/myConnection/src/main/java/nsis/property/config.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection cnt =null;
		PreparedStatement stm = null;
		
		try {
			cnt = JDBCManager.getConnection();
			stm = cnt.prepareStatement("SELECT * FROM person");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCManager.closeConnectionAndStatement(cnt, stm);
		}
		
		

	}

	
}
