package com.cvbuilder.controllers;

import com.cvbuilder.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controller for the Home screen
 */
public class HomeController {
    
    @FXML
    private Button createButton;
    
    @FXML
    public void onCreateNewCV() {
        Main.getInstance().showDataEntryScreen();
    }
}
