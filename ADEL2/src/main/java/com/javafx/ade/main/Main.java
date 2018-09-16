package com.javafx.ade.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage window;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Algorithms and Data Estructures -- Laboratoy 2");
		window.setResizable(false);
		Parent root = FXMLLoader.load(getClass().getResource("/view/view.fxml"));
		Scene scene = new Scene(root);
		
		window.setScene(scene);
		window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
