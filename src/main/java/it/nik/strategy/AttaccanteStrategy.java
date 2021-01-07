package it.nik.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AttaccanteStrategy implements RuoloStrategy{

	private static final Logger LOGGER = LoggerFactory.getLogger(AttaccanteStrategy.class);
	
	public void execute() {
		LOGGER.info("Giocatore sale di posizione pronto per fare goal");
	}
	

}
