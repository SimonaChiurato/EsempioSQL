package it.polito.tdp.esempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeggiBabs {

	public void run() {
		//1
		String jdbcURL ="jdbc:mariadb://localhost/babs?user=root&password=root";
		
		try {
			//2
			Connection conn= DriverManager.getConnection(jdbcURL);
			//Statement statement= conn.createStatement();
			
			String SQL= "SELECT name FROM  station WHERE landmark= ? ";
		//	ResultSet res= statement.executeQuery(SQL); MODI SBAGLIATI
			PreparedStatement statement= conn.prepareStatement(SQL);
			statement.setString(1, "Palo Alto");
			ResultSet res=statement.executeQuery();
			while(res.next()) {
				String nomeStazione= res.getString("name");
				System.out.println(nomeStazione);
			}
			statement.close();
			Statement st2= conn.createStatement();
			//.....
			
			
			
			//6 --> farlo subito dopo 2!!!!!!!
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public static void main(String args[]) {
		LeggiBabs babs= new LeggiBabs();
		babs.run();
	}
}
