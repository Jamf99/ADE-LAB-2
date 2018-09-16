package com.ade.model;

import com.ade.estructures.Stack;

public class Player {
	
	private Player next;
	private Stack<Weapon> weapons;
	
	private String name;
	private double kills;
	private double averagePing;
	private int plataform;
	private double victories;
	private double gamesPlayed;
	
	public Player(String name, double kills, int victories, int gamesPlayed, double averagePing, int plataform) {
		super();
		this.name = name;
		this.kills = kills;
		this.victories = victories;
		this.gamesPlayed = gamesPlayed;
		this.averagePing = averagePing;
		this.plataform = plataform;
		this.next = null;
		weapons = new Stack<Weapon>();
	}
	
	public Stack<Weapon> getWeapons() {
		return weapons;
	}

	public void shoot() {
		if(weapons.getTop().getAmmo() > 0) {
			weapons.getTop().setAmmo(weapons.getTop().getAmmo()-1);
		}else {
			weapons.pop();
		}
		
	}
	
	public void pickWeapon(Weapon weapon) {
		weapons.push(weapon);
	}
	
	public Player getNext() {
		return next;
	}
	
	public void setNext(Player next) {
		this.next = next;	
	}
	
	public void disconectNext() {
		this.next = next.next;
	}

	public String getName() {
		return name;
	}
	
	public double getKills() {
		return kills;
	}

	public double getAveragePing() {
		return averagePing;
	}

	public int getPlataform() {
		return plataform;
	}

	public double getVictories() {
		return victories;
	}

	public double getGamesPlayed() {
		return gamesPlayed;
	}
	
}
