package com.ade.model;

import com.ade.estructures.LinkedList;
import com.ade.estructures.Queue;

public class Plataform {
	
	public static final int PLAYSTATION = 0;
	public static final int XBOX = 1;
	public static final int NINTENDO_SWITCH = 2;
	public static final int SMARTPHONE = 3;
	public static final int PC = 4;
	
	private LinkedList<Player> players;
	private Queue<Player> noobLow, noobMid, noobHigh, mediumLow, mediumMid, mediumHigh, 
		proLow, proMid, proHigh;
	
	private String name;
		
	public Plataform(String name) {
		this.name = name;
		players = new LinkedList<Player>();
		players = new LinkedList<Player>();
		noobLow = new Queue<Player>();noobMid = new Queue<Player>();noobHigh = new Queue<Player>();
		mediumLow = new Queue<Player>();mediumMid = new Queue<Player>();mediumHigh = new Queue<Player>();
		proLow = new Queue<Player>();proMid = new Queue<Player>();proHigh = new Queue<Player>();
	}
	
	public String getName() {
		return name;
	}
	
	public LinkedList<Player> getPlayers(){
		return players;
	}
	
	public void clasifyByGameProwessWithPlataform() {
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