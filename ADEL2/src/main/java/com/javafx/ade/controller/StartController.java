package com.javafx.ade.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.ade.exceptions.EmptyFieldException;
import com.ade.model.Fornite;
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
	
	private Fornite fornite;
	
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
			fornite = new Fornite(true);
		}
		if(!isPlatformMode.isSelected()) {
			platforms.setDisable(true);
			fornite = new Fornite(false);
		}
	}
	
	@FXML
	void addPlayer(ActionEvent event) {
		try {
			Player p = null;
			if(!isPlatformMode.isSelected()) {
				p = new Player(getName(), getKills(), getVictories(), getGamesPlayed(), getAveragePing(), -1);
				fornite.addPlayer(p, false);
				noobLow.setText(fornite.getNoobLow().size()+"");
				noobMid.setText(fornite.getNoobMid().size()+"");
				noobHigh.setText(fornite.getNoobHigh().size()+"");
				mediumLow.setText(fornite.getMediumLow().size()+"");
				mediumMid.setText(fornite.getMediumMid().size()+"");
				mediumHigh.setText(fornite.getMediumHigh().size()+"");
				proLow.setText(fornite.getProLow().size()+"");
				proMid.setText(fornite.getProMid().size()+"");
				proHigh.setText(fornite.getProHigh().size()+"");
				txtPlatform.setText("Whithout Platform");	
			}else {
				p = new Player(getName(), getKills(), getVictories(), getGamesPlayed(), getAveragePing(), getPlatform());
				int posPlatform = platforms.getSelectionModel().getSelectedIndex();
				fornite.addPlayer(p, true);
				noobLow.setText(fornite.getPlataforms()[posPlatform].getNoobLow().size()+"");
				noobMid.setText(fornite.getPlataforms()[posPlatform].getNoobMid().size()+"");
				noobHigh.setText(fornite.getPlataforms()[posPlatform].getNoobHigh().size()+"");
				mediumLow.setText(fornite.getPlataforms()[posPlatform].getMediumLow().size()+"");
				mediumMid.setText(fornite.getPlataforms()[posPlatform].getMediumMid().size()+"");
				mediumHigh.setText(fornite.getPlataforms()[posPlatform].getMediumHigh().size()+"");
				proLow.setText(fornite.getPlataforms()[posPlatform].getProLow().size()+"");
				proMid.setText(fornite.getPlataforms()[posPlatform].getProMid().size()+"");
				proHigh.setText(fornite.getPlataforms()[posPlatform].getProHigh().size()+"");
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
		fornite = new Fornite(false);
		ObservableList<String> states = FXCollections.observableArrayList("PlayStation", "Xbox", "PC", "Smarthphone", "Nintendo Switch");
		platforms.setItems(states);
		platforms.getSelectionModel().select(0);
	}
	
}