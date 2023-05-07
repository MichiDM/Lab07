package it.polito.tdp.poweroutages.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		//System.out.println(model.getNercList());
		
		Nerc nerc = new Nerc(3, "MAAC");
//		
//		for ( PowerOutages p : model.getPowerOutage().getPowerOutagesNercAndYearSpecified( nerc, 2003)) {
//			
//			long hour = (p.durationPowerOutage());
//			System.out.println(hour);
//			
//		}

		
		Ricorsione ric = new Ricorsione();
//		Ricorsione0 ric0 = new Ricorsione0();
		
		List<PowerOutages> lista = ric.findPowerOutages(4, 200, nerc);
//		List<List<PowerOutages>> lista = ric0.findPowerOutages(4, 200, nerc);
//		System.out.println(lista.size());
		
		for (PowerOutages p : lista) {
			System.out.println(p.toString());
		}
		
	}

}
