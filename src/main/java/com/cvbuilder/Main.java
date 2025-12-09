package com.cvbuilder;

import com.cvbuilder.controllers.PreviewController;
import com.cvbuilder.models.CVData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    
    private static Main instance;
    private Stage primaryStage;
    private Scene homeScene;
    private Scene dataEntryScene;
    private Scene previewScene;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        instance = this;
        
        primaryStage.setTitle("CV Builder");
        primaryStage.setWidth(900);
        primaryStage.setHeight(700);
        
        showHomeScreen();
        primaryStage.show();
    }
    
    public void showHomeScreen() {
        try {
            if (homeScene == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
                Parent root = loader.load();
                homeScene = new Scene(root);
            }
            primaryStage.setScene(homeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showDataEntryScreen() {
        try {
            if (dataEntryScene == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dataEntry.fxml"));
                Parent root = loader.load();
                dataEntryScene = new Scene(root);
            }
            primaryStage.setScene(dataEntryScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showPreviewScreen(CVData cvData) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/preview.fxml"));
            Parent root = loader.load();
            PreviewController controller = loader.getController();
            controller.setCVData(cvData);
            
            previewScene = new Scene(root);
            primaryStage.setScene(previewScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Main getInstance() {
        return instance;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}


