package it.polito.tdp.poweroutages.model;

import java.util.List;


import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;


public class Model {
	
	PowerOutageDAO podao;
	
	// MODI PER PASSARE DALL'ID DI UN OGGETTO ALL'OGGETTO COMPLETO
	// Per avere dalla tabella 'poweroutages' il nome del NercId ho due modi:
	// - si fa una join tra la tabella 'poweroutages' e la tabella 'nerc';
	// - si sfrutta l'identityMap, come in questo caso: al DAO passo una mappa
	//   che dall'NercId arrivo all'oggetto PowerOutages
	
	// private Map<Integer, Nerc> nercIdMap;
	
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	public List<Nerc> getNercList() {
		
//		for (Nerc n : podao.getNercList())
//			this.nercIdMap.put(n.getId(), n);
		
		return podao.getNercList();
	}
	
	public List<PowerOutages> getPowerOutagesNercSpecified(Nerc nerc) {
		return this.podao.getPowerOutagesNercSpecified(nerc);
	}
	
	public int getYearOfFirstPowerOutageNercSpecified(Nerc nerc) {
		return this.podao.getYearOfFirstPowerOutageNercSpecified(nerc);
	}
	
	public int getYearOfLastPowerOutageNercSpecified(Nerc nerc) {
		return this.podao.getYearOfLastPowerOutageNercSpecified(nerc);
	}
	
//	public Map<Integer, Nerc> getPowerOutagesNercAndYearSpecified(Nerc nerc, int anno) {
//		return this.podao.getPowerOutagesNercAndYearSpecified(nerc, anno);
//	}
	
	

}
