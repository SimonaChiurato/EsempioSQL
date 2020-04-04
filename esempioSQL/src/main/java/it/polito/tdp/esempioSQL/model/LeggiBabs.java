package it.polito.tdp.esempioSQL.model;

import java.util.List;

import it.polito.tdp.esempioSQL.db.BabsDAO;

;

public class LeggiBabs {

	public void run() {
		
		BabsDAO dao= new BabsDAO();
		
		List<Station> tutte= dao.listStation();
		for(Station s: tutte) {
			System.out.println(s.getName());
		}
		System.out.println("-------------------------------");
		List<Station> paloAlto= dao.listStationByLandmark("Palo Alto");
		for(Station s: paloAlto) {
			System.out.println(s.getName());
		}
		
		
		
		//1
	/*	String jdbcURL ="jdbc:mariadb://localhost/babs?user=root&password=root";
		
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
		INUTILE AVERE LE COSE NEL MAIN!!!!!!1
		*/ 
	}
	public static void main(String args[]) {
		LeggiBabs babs= new LeggiBabs();
		babs.run();
	}
}
