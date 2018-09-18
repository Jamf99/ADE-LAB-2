package com.javafx.ade.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.ade.exceptions.EmptyFieldException;
import com.ade.model.Fortnite;
import com.ade.model.Plataform;
import com.ade.model.Player;
import com.ade.model.Weapon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StartController implements Initializable{
	
	private Fortnite fortnite;
	private Player player;
	
	@FXML
	private Button addPlayer;

	@FXML
	private TextField name;

	@FXML
	private TextField kills;

	@FXML
	private TextField averagePing;

	@FXML
	private TextField gamesPlayed;

	@FXML
	private TextField victories;

	@FXML
	private ComboBox<String> platforms;

	@FXML
	private Label proHigh;
	 
	@FXML
	private Label proMid;

	@FXML
	private Label mediumHigh;

	@FXML
	private Label noobHigh;

	@FXML
	private Label mediumLow;

	@FXML
	private Label proLow;

	@FXML
	private Label mediumMid;

	@FXML
	private Label noobLow;

	@FXML
	private Label noobMid;
	
	@FXML
    private Button pickWeapon;

    @FXML
    private Button shoot;

    @FXML
    private TextField actuallyWeapon;
    
    @FXML
    private TextField ammo;
	
	@FXML
    private Label txtPlatform;

	@FXML
    private CheckBox isPlatformMode;

	public String getName() throws EmptyFieldException{
		if(name.getText().equals("")) {
			throw new EmptyFieldException();
		}
		return name.getText();
	}

	public double getKills() throws ArithmeticException{
		return Double.parseDouble(kills.getText());
	}

	public double getAveragePing() throws ArithmeticException {
		return Double.parseDouble(averagePing.getText());
	}

	public int getGamesPlayed() throws ArithmeticException{
		return Integer.parseInt(gamesPlayed.getText());
	}

	public int getVictories() throws ArithmeticException {
		return Integer.parseInt(victories.getText());
	}

	public int getPlatform() {
		return platforms.getSelectionModel().getSelectedIndex();
	}
	
	public boolean havePlatform() {
		if(platforms.getSelectionModel().getSelectedIndex() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public String generateRandomWeapons() {
		String[] names = {"Subfusil", "Minigun", "Scar", "M16", "Rifle", "Gun", "Sniper", "Shotgun"};
		String randomWeapons = names[(int)(Math.floor(Math.random()*((names.length-1)-0+1)+0))];
		return randomWeapons;
	}
	
	public String generateRandomColors() {
		String[] colors = {"Gray", "Green", "Blue", "Purple", "Orange", "Golden"};
		String randomColors = colors[(int)(Math.floor(Math.random()*((colors.length-1)-0+1)+0))];
		return randomColors;
	}
	
	@FXML
	void pickWeapon(ActionEvent event) {
		player.pickWeapon(new Weapon(36, generateRandomWeapons(), generateRandomColors()));
		actuallyWeapon.setText(player.getWeapons().getTop().getName()+" "+player.getWeapons().getTop().getColor());
		ammo.setText(player.getWeapons().getTop().getAmmo()+"");
	}

	@FXML
	void shoot(ActionEvent event) {
		if(!player.getWeapons().isEmpty()) {
			player.shoot();
			if(player.getWeapons().isEmpty()) {
				actuallyWeapon.setText("Pickaxe");
				ammo.setText("");
			}else {
				actuallyWeapon.setText(player.getWeapons().getTop().getName()+" "+player.getWeapons().getTop().getColor());
				ammo.setText(player.getWeapons().getTop().getAmmo()+"");
			
			}
		}else {
			Alert message = new Alert(Alert.AlertType.ERROR);
			message.setTitle("Oops!");
			message.setContentText("Please pick a weapon and try it again");
			message.setHeaderText("You don't have any weapon to shoot");
			message.show();
		}
	}
	
	@FXML
	void isPlatformMode(ActionEvent event) {
		if(isPlatformMode.isSelected()) {
			platforms.setDisable(false);
			fortnite = new Fortnite(true);
		}
		if(!isPlatformMode.isSelected()) {
			platforms.setDisable(true);
			fortnite = new Fortnite(false);
		}
	}
	
	@FXML
	void addPlayer(ActionEvent event) {
		try {
			Player p = null;
			if(!isPlatformMode.isSelected()) {
				p = new Player(getName(), getKills(), getVictories(), getGamesPlayed(), getAveragePing(), -1);
				fortnite.addPlayer(p, false);
				noobLow.setText(fortnite.getNoobLow().size()+"");
				noobMid.setText(fortnite.getNoobMid().size()+"");
				noobHigh.setText(fortnite.getNoobHigh().size()+"");
				mediumLow.setText(fortnite.getMediumLow().size()+"");
				mediumMid.setText(fortnite.getMediumMid().size()+"");
				mediumHigh.setText(fortnite.getMediumHigh().size()+"");
				proLow.setText(fortnite.getProLow().size()+"");
				proMid.setText(fortnite.getProMid().size()+"");
				proHigh.setText(fortnite.getProHigh().size()+"");
				txtPlatform.setText("Whithout Platform");	
			}else {
				p = new Player(getName(), getKills(), getVictories(), getGamesPlayed(), getAveragePing(), getPlatform());
				int posPlatform = platforms.getSelectionModel().getSelectedIndex();
				fortnite.addPlayer(p, true);
				noobLow.setText(fortnite.getPlataforms()[posPlatform].getNoobLow().size()+"");
				noobMid.setText(fortnite.getPlataforms()[posPlatform].getNoobMid().size()+"");
				noobHigh.setText(fortnite.getPlataforms()[posPlatform].getNoobHigh().size()+"");
				mediumLow.setText(fortnite.getPlataforms()[posPlatform].getMediumLow().size()+"");
				mediumMid.setText(fortnite.getPlataforms()[posPlatform].getMediumMid().size()+"");
				mediumHigh.setText(fortnite.getPlataforms()[posPlatform].getMediumHigh().size()+"");
				proLow.setText(fortnite.getPlataforms()[posPlatform].getProLow().size()+"");
				proMid.setText(fortnite.getPlataforms()[posPlatform].getProMid().size()+"");
				proHigh.setText(fortnite.getPlataforms()[posPlatform].getProHigh().size()+"");
				txtPlatform.setText(platforms.getSelectionModel().getSelectedItem());	
			}
			name.setText("");
			kills.setText("");
			averagePing.setText("");
			victories.setText("");
			gamesPlayed.setText("");
		}catch(ArithmeticException s) {
			Alert message = new Alert(Alert.AlertType.ERROR);
			message.setTitle("Error");
			message.setContentText("Please check that you put a valid data");
			message.setHeaderText("Some fields are invalid");
			message.show();
		}catch(EmptyFieldException e) {
			Alert message = new Alert(Alert.AlertType.ERROR);
			message.setTitle("Error");
			message.setContentText(e.getMessage());
			message.setHeaderText("Fail");
			message.show();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		player = new Player("Ninja", 20, 9, 10, 120, Plataform.PLAYSTATION);
		fortnite = new Fortnite(false);
		ObservableList<String> states = FXCollections.observableArrayList("PlayStation", "Xbox", "PC", "Smarthphone", "Nintendo Switch");
		platforms.setItems(states);
		platforms.getSelectionModel().select(0);
		actuallyWeapon.setText("Pickaxe");
		ammo.setText("");
	}
	
}