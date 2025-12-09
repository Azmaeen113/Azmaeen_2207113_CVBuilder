package com.cvbuilder.controllers;

import com.cvbuilder.Main;
import com.cvbuilder.models.CVData;
import com.cvbuilder.utils.ValidationUtils;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * Controller for the Data Entry Form screen
 */
public class DataEntryController {
    
    @FXML
    private TextField fullNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextArea addressArea;
    
    @FXML
    private VBox educationContainer;
    @FXML
    private VBox workExperienceContainer;
    @FXML
    private VBox projectsContainer;
    @FXML
    private VBox skillsContainer;
    
    @FXML
    private TextField skillInput;
    
    @FXML
    private Button addEducationBtn;
    @FXML
    private Button addWorkExpBtn;
    @FXML
    private Button addProjectBtn;
    @FXML
    private Button addSkillBtn;
    
    @FXML
    private Button backButton;
    @FXML
    private Button generateButton;
    
    private CVData cvData;
    private int educationCount = 0;
    private int workExpCount = 0;
    private int projectCount = 0;
    
    @FXML
    public void initialize() {
        cvData = new CVData();
        // Add default education field
        addEducationField();
    }
    
    @FXML
    private void onAddEducation() {
        addEducationField();
    }
    
    @FXML
    private void onAddWorkExperience() {
        addWorkExperienceField();
    }
    
    @FXML
    private void onAddProject() {
        addProjectField();
    }
    
    @FXML
    private void onAddSkill() {
        String skill = skillInput.getText().trim();
        if (!skill.isEmpty()) {
            cvData.addSkill(skill);
            skillInput.clear();
            updateSkillsDisplay();
        } else {
            showAlert("Warning", "Please enter a skill");
        }
    }
    
    private void addEducationField() {
        int index = educationCount;
        
        VBox educationBox = new VBox(8);
        educationBox.setStyle("-fx-border-color: #ddd; -fx-border-radius: 5; -fx-padding: 10; -fx-background-color: #f9f9f9;");
        educationBox.setPadding(new Insets(10));
        
        Label titleLabel = new Label("Education #" + (index + 1));
        titleLabel.setStyle("-fx-font-size: 12; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        
        Label schoolLabel = new Label("School Name:");
        schoolLabel.setStyle("-fx-font-size: 11; -fx-font-weight: bold;");
        TextField schoolField = new TextField();
        schoolField.setStyle("-fx-padding: 6;");
        
        Label degreeLabel = new Label("Degree:");
        degreeLabel.setStyle("-fx-font-size: 11; -fx-font-weight: bold;");
        TextField degreeField = new TextField();
        degreeField.setStyle("-fx-padding: 6;");
        
        Label fieldLabel = new Label("Field of Study:");
        fieldLabel.setStyle("-fx-font-size: 11; -fx-font-weight: bold;");
        TextField fieldField = new TextField();
        fieldField.setStyle("-fx-padding: 6;");
        
        Label yearLabel = new Label("Graduation Year:");
        yearLabel.setStyle("-fx-font-size: 11; -fx-font-weight: bold;");
        TextField yearField = new TextField();
        yearField.setStyle("-fx-padding: 6;");
        
        grid.add(schoolLabel, 0, 0);
        grid.add(schoolField, 1, 0);
        grid.add(degreeLabel, 0, 1);
        grid.add(degreeField, 1, 1);
        grid.add(fieldLabel, 0, 2);
        grid.add(fieldField, 1, 2);
        grid.add(yearLabel, 0, 3);
        grid.add(yearField, 1, 3);
        
        ColumnConstraints col1 = new ColumnConstraints(120);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(javafx.scene.layout.Priority.ALWAYS);
        grid.getColumnConstraints().addAll(col1, col2);
        
        Button removeBtn = new Button("Remove");
        removeBtn.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-padding: 6 15 6 15; -fx-cursor: hand;");
        removeBtn.setOnAction(e -> {
            educationContainer.getChildren().remove(educationBox);
        });
        
        educationBox.getChildren().addAll(titleLabel, grid, removeBtn);
        educationContainer.getChildren().add(educationBox);
        
        // Store reference for data collection
        educationBox.setUserData(new Object[]{schoolField, degreeField, fieldField, yearField});
        educationCount++;
    }
    
    private void addWorkExperienceField() {
        int index = workExpCount;
        
        VBox expBox = new VBox(8);
        expBox.setStyle("-fx-border-color: #ddd; -fx-border-radius: 5; -fx-padding: 10; -fx-background-color: #f9f9f9;");
        expBox.setPadding(new Insets(10));
        
        Label titleLabel = new Label("Work Experience #" + (index + 1));
        titleLabel.setStyle("-fx-font-size: 12; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        
        Label companyLabel = new Label("Company Name:");
        companyLabel.setStyle("-fx-font-size: 11; -fx-font-weight: bold;");
        TextField companyField = new TextField();
        companyField.setStyle("-fx-padding: 6;");
        
        Label positionLabel = new Label("Position:");
        positionLabel.setStyle("-fx-font-size: 11; -fx-font-weight: bold;");
        TextField positionField = new TextField();
        positionField.setStyle("-fx-padding: 6;");
        
        Label startLabel = new Label("Start Date:");
        startLabel.setStyle("-fx-font-size: 11; -fx-font-weight: bold;");
        TextField startField = new TextField();
        startField.setStyle("-fx-padding: 6;");
        startField.setPromptText("MM/YYYY");
        
        Label endLabel = new Label("End Date:");
        endLabel.setStyle("-fx-font-size: 11; -fx-font-weight: bold;");
        TextField endField = new TextField();
        endField.setStyle("-fx-padding: 6;");
        endField.setPromptText("MM/YYYY or Present");
        
        Label descLabel = new Label("Description:");
        descLabel.setStyle("-fx-font-size: 11; -fx-font-weight: bold;");
        TextArea descArea = new TextArea();
        descArea.setWrapText(true);
        descArea.setPrefRowCount(3);
        descArea.setStyle("-fx-padding: 6;");
        
        grid.add(companyLabel, 0, 0);
        grid.add(companyField, 1, 0);
        grid.add(positionLabel, 0, 1);
        grid.add(positionField, 1, 1);
        grid.add(startLabel, 0, 2);
        grid.add(startField, 1, 2);
        grid.add(endLabel, 0, 3);
        grid.add(endField, 1, 3);
        grid.add(descLabel, 0, 4);
        grid.add(descArea, 1, 4);
        
        ColumnConstraints col1 = new ColumnConstraints(120);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(javafx.scene.layout.Priority.ALWAYS);
        grid.getColumnConstraints().addAll(col1, col2);
        
        Button removeBtn = new Button("Remove");
        removeBtn.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-padding: 6 15 6 15; -fx-cursor: hand;");
        removeBtn.setOnAction(e -> {
            workExperienceContainer.getChildren().remove(expBox);
        });
        
        expBox.getChildren().addAll(titleLabel, grid, removeBtn);
        workExperienceContainer.getChildren().add(expBox);
        
        expBox.setUserData(new Object[]{companyField, positionField, startField, endField, descArea});
        workExpCount++;
    }
    
    private void addProjectField() {
        int index = projectCount;
        
        VBox projectBox = new VBox(8);
        projectBox.setStyle("-fx-border-color: #ddd; -fx-border-radius: 5; -fx-padding: 10; -fx-background-color: #f9f9f9;");
        projectBox.setPadding(new Insets(10));
        
        Label titleLabel = new Label("Project #" + (index + 1));
        titleLabel.setStyle("-fx-font-size: 12; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        
        Label projectNameLabel = new Label("Project Name:");
        projectNameLabel.setStyle("-fx-font-size: 11; -fx-font-weight: bold;");
        TextField projectNameField = new TextField();
        projectNameField.setStyle("-fx-padding: 6;");
        
        Label descLabel = new Label("Description:");
        descLabel.setStyle("-fx-font-size: 11; -fx-font-weight: bold;");
        TextArea descArea = new TextArea();
        descArea.setWrapText(true);
        descArea.setPrefRowCount(3);
        descArea.setStyle("-fx-padding: 6;");
        
        Label techLabel = new Label("Technologies:");
        techLabel.setStyle("-fx-font-size: 11; -fx-font-weight: bold;");
        TextField techField = new TextField();
        techField.setStyle("-fx-padding: 6;");
        techField.setPromptText("e.g., Java, JavaFX, Maven");
        
        grid.add(projectNameLabel, 0, 0);
        grid.add(projectNameField, 1, 0);
        grid.add(descLabel, 0, 1);
        grid.add(descArea, 1, 1);
        grid.add(techLabel, 0, 2);
        grid.add(techField, 1, 2);
        
        ColumnConstraints col1 = new ColumnConstraints(120);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(javafx.scene.layout.Priority.ALWAYS);
        grid.getColumnConstraints().addAll(col1, col2);
        
        Button removeBtn = new Button("Remove");
        removeBtn.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-padding: 6 15 6 15; -fx-cursor: hand;");
        removeBtn.setOnAction(e -> {
            projectsContainer.getChildren().remove(projectBox);
        });
        
        projectBox.getChildren().addAll(titleLabel, grid, removeBtn);
        projectsContainer.getChildren().add(projectBox);
        
        projectBox.setUserData(new Object[]{projectNameField, descArea, techField});
        projectCount++;
    }
    
    private void updateSkillsDisplay() {
        skillsContainer.getChildren().clear();
        for (int i = 0; i < cvData.getSkills().size(); i++) {
            String skill = cvData.getSkills().get(i);
            HBox skillBox = new HBox(10);
            skillBox.setStyle("-fx-padding: 8; -fx-background-color: #ecf0f1; -fx-border-radius: 3;");
            skillBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
            
            Label skillLabel = new Label(skill);
            skillLabel.setStyle("-fx-font-size: 12;");
            
            Button removeSkillBtn = new Button("×");
            removeSkillBtn.setStyle("-fx-padding: 2 8 2 8; -fx-font-size: 14; -fx-background-color: #e74c3c; -fx-text-fill: white; -fx-cursor: hand;");
            final int index = i;
            removeSkillBtn.setOnAction(e -> {
                cvData.removeSkill(index);
                updateSkillsDisplay();
            });
            
            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);
            skillBox.getChildren().addAll(skillLabel, spacer, removeSkillBtn);
            skillsContainer.getChildren().add(skillBox);
        }
    }
    
    @FXML
    private void onBackToHome() {
        Main.getInstance().showHomeScreen();
    }
    
    @FXML
    private void onGenerateCV() {
        if (validateForm()) {
            collectFormData();
            Main.getInstance().showPreviewScreen(cvData);
        }
    }
    
    private boolean validateForm() {
        String fullName = fullNameField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();
        
        if (ValidationUtils.isEmpty(fullName)) {
            showAlert("Validation Error", "Full Name is required");
            return false;
        }
        
        if (ValidationUtils.isEmpty(email)) {
            showAlert("Validation Error", "Email Address is required");
            return false;
        }
        
        if (!ValidationUtils.isValidEmail(email)) {
            showAlert("Validation Error", "Please enter a valid email address (e.g., example@domain.com)");
            return false;
        }
        
        if (ValidationUtils.isEmpty(phone)) {
            showAlert("Validation Error", "Phone Number is required");
            return false;
        }
        
        if (!ValidationUtils.isValidPhoneNumber(phone)) {
            showAlert("Validation Error", "Please enter a valid phone number (at least 7 digits)");
            return false;
        }
        
        return true;
    }
    
    private void collectFormData() {
        cvData.setFullName(fullNameField.getText().trim());
        cvData.setEmail(emailField.getText().trim());
        cvData.setPhoneNumber(phoneField.getText().trim());
        cvData.setAddress(addressArea.getText().trim());
        
        // Collect education entries
        cvData.getEducationList().clear();
        for (javafx.scene.Node node : educationContainer.getChildren()) {
            if (node instanceof VBox) {
                Object[] fields = (Object[]) node.getUserData();
                if (fields != null) {
                    String school = ((TextField) fields[0]).getText().trim();
                    String degree = ((TextField) fields[1]).getText().trim();
                    String field = ((TextField) fields[2]).getText().trim();
                    String year = ((TextField) fields[3]).getText().trim();
                    
                    if (!school.isEmpty() || !degree.isEmpty() || !field.isEmpty() || !year.isEmpty()) {
                        cvData.addEducation(new CVData.EducationEntry(school, degree, field, year));
                    }
                }
            }
        }
        
        // Collect work experience entries
        cvData.getWorkExperienceList().clear();
        for (javafx.scene.Node node : workExperienceContainer.getChildren()) {
            if (node instanceof VBox) {
                Object[] fields = (Object[]) node.getUserData();
                if (fields != null) {
                    String company = ((TextField) fields[0]).getText().trim();
                    String position = ((TextField) fields[1]).getText().trim();
                    String start = ((TextField) fields[2]).getText().trim();
                    String end = ((TextField) fields[3]).getText().trim();
                    String desc = ((TextArea) fields[4]).getText().trim();
                    
                    if (!company.isEmpty() || !position.isEmpty() || !start.isEmpty() || !end.isEmpty()) {
                        cvData.addWorkExperience(new CVData.WorkExperienceEntry(company, position, start, end, desc));
                    }
                }
            }
        }
        
        // Collect project entries
        cvData.getProjectsList().clear();
        for (javafx.scene.Node node : projectsContainer.getChildren()) {
            if (node instanceof VBox) {
                Object[] fields = (Object[]) node.getUserData();
                if (fields != null) {
                    String projectName = ((TextField) fields[0]).getText().trim();
                    String desc = ((TextArea) fields[1]).getText().trim();
                    String tech = ((TextField) fields[2]).getText().trim();
                    
                    if (!projectName.isEmpty() || !desc.isEmpty()) {
                        cvData.addProject(new CVData.ProjectEntry(projectName, desc, tech));
                    }
                }
            }
        }
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
