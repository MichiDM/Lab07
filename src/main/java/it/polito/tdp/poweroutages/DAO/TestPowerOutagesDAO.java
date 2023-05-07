package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;

import it.polito.tdp.poweroutages.model.Nerc;

public class TestPowerOutagesDAO {

	public static void main(String[] args) {
		
//		try {
//			Connection connection = ConnectDB.getConnection();
//			connection.close();
//			System.out.println("Connection Test PASSED");
//			
//			PowerOutageDAO dao = new PowerOutageDAO() ;
//			
//			System.out.println(dao.getNercList()) ;
//
//		} catch (Exception e) {
//			System.err.println("Test FAILED");
//		}
		
		try {
			Connection connection = ConnectDB.getConnection();
			connection.close();
			System.out.println("Connection Test PASSED");
			
			PowerOutageDAO dao = new PowerOutageDAO() ;
			Nerc ne = new Nerc (3, "MAAC");
			
//			System.out.println(dao.getPowerOutagesNercAndYearSpecified(ne,2006)) ;
			System.out.println(dao.getPowerOutagesNercSpecified(ne));
			//System.out.println(dao.getYearOfFirstPowerOutageNercSpecified(ne));
			//System.out.println(dao.getYearOfLastPowerOutageNercSpecified(ne));

		} catch (Exception e) {
			System.err.println("Test FAILED");
		}


	}

}
