package org.develop.batch.step.components.processors;


import java.util.HashMap;

import org.codehaus.jettison.json.JSONObject;
import org.develop.batch.dto.EstrazioneDto;
import org.develop.batch.dto.interfaces.Dto;
import org.develop.batch.step.components.interfaces.ProcessorsInterface;
import org.develop.persistence.entities.business.Estrazione;
import org.develop.persistence.entities.interfaces.Entita;
import org.springframework.batch.item.ItemProcessor;


public class EstrazioneItemProcessorBuilder implements ProcessorsInterface<Dto, Entita> {

	@Override
	public ItemProcessor<Dto, Entita> build(JSONObject json) {		
		return new EstrazioneItemProcessor();
	}
	


	private class EstrazioneItemProcessor implements ItemProcessor<Dto, Entita> {
	
		private HashMap<String,Long> mapRuotaId = new HashMap<>();
		
		{
			mapRuotaId.put("BA",1L);
		    mapRuotaId.put("FI",2L);
		    mapRuotaId.put("MI",3L);
		    mapRuotaId.put("NA",4L);
		    mapRuotaId.put("PA",5L);
		    mapRuotaId.put("RM",6L);
		    mapRuotaId.put("TO",7L);
		    mapRuotaId.put("VE",8L);
		    mapRuotaId.put("CA",9L);
		    mapRuotaId.put("GE",10L);
		    mapRuotaId.put("RN",11L);
		}
		
		@Override
		public Estrazione process(Dto in) throws Exception {
	
			EstrazioneDto item = (EstrazioneDto) in;
			
			System.out.println("Processing..." + item);
			
			Estrazione estrazione = new Estrazione(); 
			estrazione.setDate(item.getDate());
			estrazione.setColumn1(item.getColumn1());
			estrazione.setColumn2(item.getColumn2());
			estrazione.setColumn3(item.getColumn3());
			estrazione.setColumn4(item.getColumn4());
			estrazione.setColumn5(item.getColumn5());
			estrazione.setIdRuota(mapRuotaId.get(item.getRuota()));		
			
			return estrazione;
		}
	}
}