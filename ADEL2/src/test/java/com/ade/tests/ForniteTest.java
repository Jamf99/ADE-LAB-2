package com.ade.tests;

import org.junit.Test;

import com.ade.model.Fornite;
import com.ade.model.Plataform;
import com.ade.model.Player;

import junit.framework.TestCase;

public class ForniteTest extends TestCase{
	
	private Player player;
//	private Plataform plataform;
//	private Plataform plataformP;
//	private Plataform plataformX;
//	private Plataform plataformN;
//	private Plataform plataformS;
//	private Plataform plataformPC;
	private Fornite fornite;
	
	private void stage1() {
		fornite = new Fornite(false);
		
	}
	
	@Test
	public void testAddPlayer() {
		stage1();
		player = new Player("Ninja", 60, 20, 20, 50, 0);
		fornite.addPlayer(player, false);
		assertNotNull(fornite.getProLow().getFront());
	}
	
	private void stage2() {
		fornite = new Fornite(true);
		
	}
	
	@Test
	public void testGetPlataform() {
		stage2();
		Plataform plataformPlay = new Plataform("PlayStation");
		Plataform plataformXbox = new Plataform("Xbox");
		Plataform plataformNintendo = new Plataform("Nintendo Switch");
		Plataform plataformSmartphone = new Plataform("Smartphone");
		Plataform plataformPC = new Plataform("PC");
		boolean test = false;
		test = plataformPlay.getName().equals(fornite.getPlataforms()[0].getName());
		test = plataformXbox.getName().equals(fornite.getPlataforms()[1].getName());
		test = plataformNintendo.getName().equals(fornite.getPlataforms()[2].getName());
		test = plataformSmartphone.getName().equals(fornite.getPlataforms()[3].getName());
		test = plataformPC.getName().equals(fornite.getPlataforms()[4].getName());
		assertTrue(test);
	}
	
	private void stage3() {
		fornite = new Fornite(false);
		player = new Player("Sarna", 0, 0, 1, 0, -1);
		fornite.addPlayer(player, false);
	}
	@Test
	public void testclasifyByGameProwessWithoutPlataform1() {
		stage3();
		assertNotNull(fornite.getNoobLow().getFront());
	}
	
	private void stage4() {
		fornite = new Fornite(false);
		player = new Player("Gamarra", 0, 0, 1, 200, -1);
		fornite.addPlayer(player, false);
	}
	@Test
	public void testclasifyByGameProwessWithoutPlataform2() {
		stage4();
		assertNotNull(fornite.getNoobMid().getFront());
	}
	
	private void stage5() {
		fornite = new Fornite(false);
		player = new Player("Camilo Barrios", 0, 0, 1, 500, -1);
		fornite.addPlayer(player, false);
	}
	@Test
	public void testclasifyByGameProwessWithoutPlataform3() {
		stage5();
		assertNotNull(fornite.getNoobHigh().getFront());
	}
	
	private void stage6() {
		fornite = new Fornite(false);
		player = new Player("Reyes", 60, 20, 20, 50, 0);
		fornite.addPlayer(player, false);
	}
	@Test
	public void testclasifyByGameProwessWithoutPlataform4() {
		stage6();
		assertNotNull(fornite.getProLow().getFront());
	}
	
}