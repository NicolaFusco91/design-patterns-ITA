package it.nik.strategy;

/*
 * Un giocatore può assumere diversi ruoli.
 */

public class Giocatore {

	private RuoloStrategy ruolo;
	
	public Giocatore(RuoloStrategy ruolo) {
		this.ruolo = ruolo;
	}
	
	public void cambioRuolo(RuoloStrategy ruolo) {
		this.ruolo = ruolo;
	}
	
	public void cambiaPosione() {
		ruolo.execute();
	}
}
