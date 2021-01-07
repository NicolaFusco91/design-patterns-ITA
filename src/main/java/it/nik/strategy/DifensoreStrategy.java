package it.nik.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DifensoreStrategy implements RuoloStrategy{

	private static final Logger LOGGER = LoggerFactory.getLogger(DifensoreStrategy.class);
	
	public void execute() {
		LOGGER.info("Giocatore si piazza al centro della difesa");
	}
	

}
