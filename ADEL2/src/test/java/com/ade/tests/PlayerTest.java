package com.ade.tests;

import junit.framework.TestCase;

import org.junit.Test;

import com.ade.model.Player;
import com.ade.model.Weapon;

public class PlayerTest extends TestCase {
	
	private Player player;
	
	private void stage1() {
		player = new Player("PewDiepie", 50, 50, 50, 50, 0);
	}
	@Test
	public void testGetWeapons() {
		stage1();
		assertNotNull(player.getWeapons());
	}
	
	private void stage2() {
		player = new Player("PewDiepie", 50, 50, 50, 50, 0);
	}
	@Test
	public void testPickWeapon() {
		stage2();
		player.pickWeapon(new Weapon(5, "Scar", "Gold"));
		assertEquals("Gold", player.getWeapons().getTop().getColor());
	}
	
	private void stage3() {
		player = new Player("PewDiepie", 50, 50, 50, 50, 0);
	}
	@Test
	public void testShoot() {
		stage3();
		player.pickWeapon(new Weapon(5, "Scar", "Gold"));
		player.shoot();
		assertEquals(4, player.getWeapons().getTop().getAmmo());
	}
	
	private void stage4() {
		player = new Player("PewDiepie", 50, 50, 50, 50, 0);
	}
	@Test
	public void testShoot2() {
		stage4();
		player.pickWeapon(new Weapon(5, "Scar", "Gold"));
		while(player.getWeapons().getTop().getAmmo() != 0) {
			player.shoot();
		}
		assertEquals(0, player.getWeapons().getTop().getAmmo());
	}
	
	private void stage5() {
		player = new Player("PewDiepie", 50, 50, 50, 50, 0);
	}
	@Test
	public void testSetNext() {
		stage5();
		player.setNext(new Player("Goku", 1000, 10000, 10000, 0, 0));
		assertNotNull(player.getNext());
	}
	
	private void stage6() {
		player = new Player("PewDiepie", 50, 50, 50, 50, 0);
	}
	@Test
	public void testGetNext() {
		stage6();
		player.setNext(new Player("Goku", 1000, 10000, 10000, 0, 0));
		assertEquals("Goku", player.getNext().getName());
	}
	
	private void stage7() {
		player = new Player("PewDiepie", 50, 50, 50, 50, 0);
	}
	@Test
	public void testDisconectNext() {
		stage7();
		player.setNext(new Player("Goku", 1000, 10000, 10000, 0, 0));
		player.disconectNext();
		assertNull(player.getNext());
	}
	
	private void stage8() {
		player = new Player("PewDiepie", 50, 50, 50, 50, 0);
	}
	@Test
	public void testGetName() {
		stage8();
		assertEquals("PewDiepie", player.getName());
	}
	
	private void stage9() {
		player = new Player("PewDiepie", 50, 50, 50, 50, 0);
	}
	@Test
	public void testGetKills() {
		stage9();
		assertEquals(50.0, player.getKills());
	}
	
	private void stage10() {
		player = new Player("PewDiepie", 50, 50, 50, 50, 0);
	}
	@Test
	public void testGetAveragePing() {
		stage10();
		assertEquals(50.0, player.getAveragePing());
	}
	
	private void stage11() {
		player = new Player("PewDiepie", 50, 50, 50, 50, 0);
	}
	@Test
	public void testGetPlataform() {
		stage11();
		assertEquals(0, player.getPlataform());
	}
	
	private void stage12() {
		player = new Player("PewDiepie", 50, 50, 50, 50, 0);
	}
	@Test
	public void testGetVictories() {
		stage12();
		assertEquals(50.0, player.getVictories());
	}
	
	private void stage13() {
		player = new Player("PewDiepie", 50, 50, 50, 50, 0);
	}
	@Test
	public void testGetGamesPlayed() {
		stage13();
		assertEquals(50.0, player.getGamesPlayed());
	}
	
}