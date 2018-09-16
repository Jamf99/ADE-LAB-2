package com.ade.model;

import com.ade.estructures.LinkedList;
import com.ade.estructures.Queue;

public class Fortnite {
	
	private Plataform[] plataforms;
	
	private LinkedList<Player> players;
	private Queue<Player> noobLow, noobMid, noobHigh, mediumLow, mediumMid, mediumHigh, 
		proLow, proMid, proHigh;
	
	public Fortnite(boolean havePlatform) {
		if(havePlatform == true) {
			plataforms = new Plataform[5];
			plataforms[0] = new Plataform("PlayStation");
			plataforms[1] = new Plataform("Xbox");
			plataforms[2] = new Plataform("Nintendo Switch");
			plataforms[3] = new Plataform("Smartphone");
			plataforms[4] = new Plataform("PC");
		}else {
			players = new LinkedList<Player>();
			noobLow = new Queue<Player>();noobMid = new Queue<Player>();noobHigh = new Queue<Player>();
			mediumLow = new Queue<Player>();mediumMid = new Queue<Player>();mediumHigh = new Queue<Player>();
			proLow = new Queue<Player>();proMid = new Queue<Player>();proHigh = new Queue<Player>();
		}
	}
	
	public void addPlayer(Player p, boolean havePlatform) {
		if(havePlatform) {
			matchPlayersWithPlataformMode(p);
		} else {
			players.addLast(p);
			clasifyByGameProwessWithoutPlataform();	
		}
	}
	
	public Plataform[] getPlataforms() {
		return plataforms;
	}
	
	public void clasifyByGameProwessWithoutPlataform() {
		Player aux = players.getFirstElement().getElement();
		while(aux!=null) {
			if(aux.getGamesPlayed() > aux.getKills()) {
				if(aux.getAveragePing() >= 0 && aux.getAveragePing() <=150) {
					noobLow.enqueue(aux);
				}else if(aux.getAveragePing() > 150 && aux.getAveragePing() <= 400) {
					noobMid.enqueue(aux);
				}else {
					noobHigh.enqueue(aux);
				}
			}else if(aux.getGamesPlayed() == aux.getKills()) {
				if(aux.getAveragePing() >= 0 && aux.getAveragePing() <=150) {
					mediumLow.enqueue(aux);
				}else if(aux.getAveragePing() > 150 && aux.getAveragePing() <= 400) {
					mediumMid.enqueue(aux);
				}else {
					mediumHigh.enqueue(aux);
				}
			}else {
				if(aux.getAveragePing() >= 0 && aux.getAveragePing() <=150) {
					proLow.enqueue(aux);
				}else if(aux.getAveragePing() > 150 && aux.getAveragePing() <= 400) {
					proMid.enqueue(aux);
				}else {
					proHigh.enqueue(aux);
				}
			}
			aux = aux.getNext();
		}
	}
	
	public void matchPlayersWithPlataformMode(Player p) {
		if(p.getPlataform() == Plataform.PLAYSTATION) {
			plataforms[0].getPlayers().addLast(p);
			plataforms[0].clasifyByGameProwessWithPlataform();
		}else if(p.getPlataform() == Plataform.XBOX) {
			plataforms[1].getPlayers().addLast(p);
			plataforms[1].clasifyByGameProwessWithPlataform();
		}else if(p.getPlataform() == Plataform.NINTENDO_SWITCH) {
			plataforms[2].getPlayers().addLast(p);
			plataforms[2].clasifyByGameProwessWithPlataform();
		}else if(p.getPlataform() == Plataform.SMARTPHONE) {
			plataforms[3].getPlayers().addLast(p);
			plataforms[3].clasifyByGameProwessWithPlataform();
		}else if(p.getPlataform() == Plataform.PC) {
			plataforms[4].getPlayers().addLast(p);
			plataforms[4].clasifyByGameProwessWithPlataform();
		}
	}
	
	public Queue<Player> getNoobLow(){
		return noobLow;
	}

	public Queue<Player> getNoobMid() {
		return noobMid;
	}

	public Queue<Player> getNoobHigh() {
		return noobHigh;
	}

	public Queue<Player> getMediumLow() {
		return mediumLow;
	}

	public Queue<Player> getMediumMid() {
		return mediumMid;
	}

	public Queue<Player> getMediumHigh() {
		return mediumHigh;
	}

	public Queue<Player> getProLow() {
		return proLow;
	}

	public Queue<Player> getProMid() {
		return proMid;
	}

	public Queue<Player> getProHigh() {
		return proHigh;
	}

}