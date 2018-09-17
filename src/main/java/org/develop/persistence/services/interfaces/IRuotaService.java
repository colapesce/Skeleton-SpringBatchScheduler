package org.develop.persistence.services.interfaces;

import java.util.List;

import org.develop.persistence.entities.business.Ruota;

public interface IRuotaService {

	public Ruota loadRuota(String chiave);
	
	public List<Ruota> loadAll();
	
	public void salvaRuota(Ruota ruota);
	
}
