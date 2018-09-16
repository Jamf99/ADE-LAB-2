package com.javafx.ade.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.ade.exceptions.EmptyFieldException;
import com.ade.model.Fortnite;
import com.ade.model.Player;

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
	
	@FXML
    private Label txtPlatform;

	@FXML
    private CheckBox isPlatformMode;
	
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
		fortnite = new Fortnite(false);
		ObservableList<String> states = FXCollections.observableArrayList("PlayStation", "Xbox", "PC", "Smarthphone", "Nintendo Switch");
		platforms.setItems(states);
		platforms.getSelectionModel().select(0);
	}
	
}