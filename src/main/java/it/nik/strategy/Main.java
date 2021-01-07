package it.nik.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Con l'utilizzo di questo pattern si ha la possibilità di cambiare il comportamento di un algoritmo
 * a runtime.
 * 
 * In questo esempio, proviamo a far cambiare il modo di giocare ad un giocatore in base alla fase della partita.
 * Le parti fondamentali sono il context (in questo caso i giocatori che possono avere diverse strategie di gioco)
 * e l'interfaccia in cui si imposta il gioco da fare (RuoloStrategy).
 * Inizialmente il giocatore1 assume una strategia di gioco difensiva, poi viene portati un pò più avanti
 * quindi facciamo cambiare la sua strategia in una da centrocampista, infine, vedendo che la squadra sta perdendo,
 * avanza ancora di posizione e cambia la sua stragia in offensiva.
 * 
 * Per farlo quindi, gli passiamo la stragia al giocatore, attraverso il costruttore, e poi eseguiamo la strategia
 *  giocatore1.cambiaPosione(). 
 * 
 * Ci sono diversi modi per implementare questo pattern:
 * Nel primo caso vengono usate le classi che hanno implementato le diverse strategie (DifensoreStrategy,
 *	CentrocampistaStrategy, AttaccanteStrategy).
 * Nel secondo caso vengono passate al metodo che permette di cambiare la strategia classi anonime attraverso 
 * l'utilizzo della funzione lambda, dato che è una functional interface, possiamo implementare l'unico metodo, 
 * che appunto contraddistingue questo tipo di interfaccia da quelle generiche, in moodo semplice.
 *  
 */

public class Main {
	 private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	 public static void main(String[] args) {
	    // Metodo Classico
	    LOGGER.info("Comincia la partita i giocatori scendono in campo");
	    Giocatore giocatore1 = new Giocatore(new DifensoreStrategy());
	    giocatore1.cambiaPosione();
	    LOGGER.info("C'è bisogno di passare al 3-5-2");
	    giocatore1 = new Giocatore(new CentrocampistaStrategy());
	    giocatore1.cambiaPosione();
	    LOGGER.info("Siamo in svantaggio");
	    giocatore1 = new Giocatore(new AttaccanteStrategy());
	    giocatore1.cambiaPosione();

	    // Il Pattern implementato con l'utilizzo del lambda
	    LOGGER.info("Comincia la partita i giocatori scendono in campo");
	    giocatore1 = new Giocatore(
	        () -> LOGGER.info("Giocatore si piazza al centro della difesa"));
	    giocatore1.cambiaPosione();
	    LOGGER.info("C'è bisogno di passare al 3-5-2");
	    giocatore1.cambioRuolo(() -> LOGGER.info(
	        "Giocatore va ad occupare il centrocampo"));
	    giocatore1.cambiaPosione();
	    LOGGER.info("Siamo in svantaggio");
	    giocatore1.cambioRuolo(() -> LOGGER.info(
	        "Giocatore sale di posizione pronto per fare goal"));
	    giocatore1.cambiaPosione();

	}

}
