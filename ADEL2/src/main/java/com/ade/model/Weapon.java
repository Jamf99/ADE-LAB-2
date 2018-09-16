package com.ade.model;

public class Weapon {
	
	private int ammo;
	private int name;
	private String color;
	
	public Weapon(int ammo, int name, String color) {
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

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
