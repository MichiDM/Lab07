package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.PowerOutages;

public class PowerOutageDAO {
	
	public List<Nerc> getNercList() {

		String sql = "SELECT id, value FROM nerc";
		List<Nerc> nercList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Nerc n = new Nerc(res.getInt("id"), res.getString("value"));
				nercList.add(n);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return nercList;
	}
	
	/**
	 Output
	 nerc_id=3, customers_affected=303795,
	 date_event_began=2005-10-24 20:00:00.0, date_event_finished=2005-11-02 16:30:00.0
	 */
	
	
	
//	public Map<Integer, Nerc> getPowerOutagesNercAndYearSpecified(Nerc nerc, int anno) {
//
//		String sql = "SELECT nerc_id, customers_affected,  date_event_began,  date_event_finished "
//					+ "FROM poweroutages "
//					+ "WHERE nerc_id = ? "
//		            + "AND YEAR(date_event_began) = ? "
//		            + "AND YEAR(date_event_finished) = ? ";
//		
//		Map<Integer, Nerc> PowerOutagesMap = new HashMap<>();
//		List<PowerOutages> PowerOutagesList = new ArrayList<PowerOutages>();
//
//		try {
//			Connection conn = ConnectDB.getConnection();
//			PreparedStatement st = conn.prepareStatement(sql);
//			st.setInt(1, nerc.getId());
//			st.setInt(2, anno);
//			st.setInt(3, anno);
//			ResultSet res = st.executeQuery();
//
//			while (res.next()) {
//				
//				PowerOutages p = new PowerOutages(res.getInt("nerc_id"), res.getInt("customers_affected"),
//						res.getTimestamp("date_event_began").toLocalDateTime(),
//						res.getTimestamp("date_event_finished").toLocalDateTime());
//				PowerOutagesList.add(p);		
//			}
//			
//			nerc.setRilevamenti(PowerOutagesList);
//			PowerOutagesMap.put(anno, nerc);
//			
//
//			conn.close();
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		
//
//		return PowerOutagesMap;
//	}
	
	public List<PowerOutages> getPowerOutagesNercSpecified(Nerc nerc) {

		String sql = "SELECT id, nerc_id, customers_affected,  date_event_began,  date_event_finished "
					+ "FROM poweroutages "
					+ "WHERE nerc_id = ? ";
		
		List<PowerOutages> PowerOutagesList = new ArrayList<PowerOutages>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, nerc.getId());
			ResultSet res = st.executeQuery();

			while (res.next()) {
				
				PowerOutages p = new PowerOutages(res.getInt("id"), res.getInt("nerc_id"), res.getInt("customers_affected"),
						res.getTimestamp("date_event_began").toLocalDateTime(),
						res.getTimestamp("date_event_finished").toLocalDateTime());
				PowerOutagesList.add(p);
			}
			

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return PowerOutagesList;
	}
	
	public int getYearOfFirstPowerOutageNercSpecified(Nerc nerc) {

		String sql = "SELECT YEAR(date_event_began) "
					+ "FROM poweroutages "
					+ "WHERE nerc_id = ? "
					+ "ORDER BY date_event_began ";
		            

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, nerc.getId());
			ResultSet res = st.executeQuery();

			res.first();
			
			int year = res.getInt("YEAR(date_event_began)");
				
			conn.close();
			
			return year;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	public int getYearOfLastPowerOutageNercSpecified(Nerc nerc) {

		String sql = "SELECT YEAR(date_event_began) "
					+ "FROM poweroutages "
					+ "WHERE nerc_id = ? "
					+ "ORDER BY date_event_began DESC ";
		            

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, nerc.getId());
			ResultSet res = st.executeQuery();

			res.first();
			
			int year = res.getInt("YEAR(date_event_began)");
				
			conn.close();
			
			return year;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	

}
