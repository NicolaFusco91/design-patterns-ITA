package it.nik.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CentrocampistaStrategy implements RuoloStrategy{

	private static final Logger LOGGER = LoggerFactory.getLogger(CentrocampistaStrategy.class);
	
	public void execute() {
		LOGGER.info("Giocatore va ad occupare il centrocampo");
	}
	

}
