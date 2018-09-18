package com.javafx.ade.main;

import java.io.FileInputStream;
import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Main extends Application {

	private Stage window;
	public static boolean reproductor;
	
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
	
	public static void main(String[] args) throws Exception {

		if(reproductor == false){			
			musica();
			launch(args);
		}
	}
    public static void musica()  throws Exception        
    {
        
        String sonido = "./data/sonido/Fortnite wav.wav";
        
        InputStream in = new FileInputStream(sonido);
        
        AudioStream audio = new AudioStream(in);
       
        AudioPlayer.player.start(audio);
    }

	
}
