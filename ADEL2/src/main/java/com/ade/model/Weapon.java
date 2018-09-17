package com.ade.model;

public class Weapon {
	
	private int ammo;
	private String name;
	private String color;
	
	public Weapon(int ammo, String name, String color) {
		this.ammo = ammo;
		this.name = name;
		this.color = color;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}
}
