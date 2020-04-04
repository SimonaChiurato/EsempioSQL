package it.polito.tdp.esempioSQL.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.esempioSQL.model.Station;

public class BabsDAO {

	public List<Station> listStation() {
		String sql = "SELECT station_id, NAME, dockcount, landmark FROM station ORDER BY name";
		List<Station> result = new ArrayList<>();
	
		//String jdbcURL = "jdbc:mariadb://localhost/babs?user=root&password=root";

		try {
	
		//	Connection conn = DriverManager.getConnection(jdbcURL);

			Connection conn= DBConnect.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet res = statement.executeQuery();
			while (res.next()) {
				Station s = new Station(res.getInt("station_id"), res.getString("name"), res.getInt("dockcount"),
						res.getString("landmark"));
				result.add(s);
			}

			conn.close();
			return result;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public List<Station> listStationByLandmark(String landmark) {
		String sql = "SELECT station_id, NAME, dockcount, landmark FROM station" + " WHERE landmark=? ORDER BY name";
		List<Station> result = new ArrayList<>();


		try {
			Connection conn= DBConnect.getConnection();
			

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, landmark);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				Station s = new Station(res.getInt("station_id"), res.getString("name"), res.getInt("dockcount"),
						res.getString("landmark"));
				result.add(s);
			}

			conn.close();
			return result;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

}
