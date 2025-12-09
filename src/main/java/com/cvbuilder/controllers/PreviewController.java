package com.cvbuilder.controllers;

import com.cvbuilder.Main;
import com.cvbuilder.models.CVData;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * Controller for the CV Preview screen
 */
public class PreviewController {
    
    @FXML
    private VBox cvContent;
    
    @FXML
    private Button backButton;
    
    @FXML
    private Button saveButton;
    
    private CVData cvData;
    
    public void setCVData(CVData cvData) {
        this.cvData = cvData;
        generatePreview();
    }
    
    private void generatePreview() {
        cvContent.getChildren().clear();
        cvContent.setStyle("-fx-font-family: 'Segoe UI', Arial, sans-serif;");
        
        // Header with name and contact info
        Label nameLabel = new Label(cvData.getFullName());
        nameLabel.setStyle("-fx-font-size: 28; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        nameLabel.setPadding(new Insets(0, 0, 10, 0));
        cvContent.getChildren().add(nameLabel);
        
        // Contact Information
        VBox contactBox = createContactInfo();
        cvContent.getChildren().add(contactBox);
        
        addSeparator();
        
        // Address Section
        if (cvData.getAddress() != null && !cvData.getAddress().isEmpty()) {
            addSection("ADDRESS", cvData.getAddress());
            addSeparator();
        }
        
        // Education Section
        if (!cvData.getEducationList().isEmpty()) {
            addSection("EDUCATION");
            for (CVData.EducationEntry edu : cvData.getEducationList()) {
                if (edu.getSchoolName() != null && !edu.getSchoolName().isEmpty()) {
                    addEducationEntry(edu);
                }
            }
            addSeparator();
        }
        
        // Skills Section
        if (!cvData.getSkills().isEmpty()) {
            addSection("SKILLS");
            VBox skillsBox = new VBox(5);
            for (String skill : cvData.getSkills()) {
                Label skillLabel = new Label("• " + skill);
                skillLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #333;");
                skillsBox.getChildren().add(skillLabel);
            }
            cvContent.getChildren().add(skillsBox);
            addSeparator();
        }
        
        // Work Experience Section
        if (!cvData.getWorkExperienceList().isEmpty()) {
            addSection("WORK EXPERIENCE");
            for (CVData.WorkExperienceEntry exp : cvData.getWorkExperienceList()) {
                if (exp.getCompanyName() != null && !exp.getCompanyName().isEmpty()) {
                    addWorkExperienceEntry(exp);
                }
            }
            addSeparator();
        }
        
        // Projects Section
        if (!cvData.getProjectsList().isEmpty()) {
            addSection("PROJECTS");
            for (CVData.ProjectEntry project : cvData.getProjectsList()) {
                if (project.getProjectName() != null && !project.getProjectName().isEmpty()) {
                    addProjectEntry(project);
                }
            }
        }
    }
    
    private VBox createContactInfo() {
        VBox contactBox = new VBox(3);
        
        String contact = cvData.getEmail();
        if (cvData.getPhoneNumber() != null && !cvData.getPhoneNumber().isEmpty()) {
            contact += " | " + cvData.getPhoneNumber();
        }
        
        Label contactLabel = new Label(contact);
        contactLabel.setStyle("-fx-font-size: 11; -fx-text-fill: #555;");
        contactBox.getChildren().add(contactLabel);
        
        return contactBox;
    }
    
    private void addSection(String title) {
        Label sectionLabel = new Label(title);
        sectionLabel.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: #2c3e50; -fx-padding: 10 0 5 0;");
        cvContent.getChildren().add(sectionLabel);
    }
    
    private void addSection(String title, String content) {
        addSection(title);
        Label contentLabel = new Label(content);
        contentLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #333; -fx-wrap-text: true;");
        contentLabel.setWrapText(true);
        contentLabel.setPadding(new Insets(0, 0, 10, 0));
        cvContent.getChildren().add(contentLabel);
    }
    
    private void addSeparator() {
        Region separator = new Region();
        separator.setPrefHeight(10);
        cvContent.getChildren().add(separator);
    }
    
    private void addEducationEntry(CVData.EducationEntry edu) {
        VBox entryBox = new VBox(2);
        entryBox.setPadding(new Insets(5, 0, 10, 0));
        
        StringBuilder titleBuilder = new StringBuilder();
        if (edu.getDegree() != null && !edu.getDegree().isEmpty()) {
            titleBuilder.append(edu.getDegree());
        }
        if (edu.getFieldOfStudy() != null && !edu.getFieldOfStudy().isEmpty()) {
            if (titleBuilder.length() > 0) titleBuilder.append(" in ");
            titleBuilder.append(edu.getFieldOfStudy());
        }
        
        if (titleBuilder.length() > 0) {
            Label titleLabel = new Label(titleBuilder.toString());
            titleLabel.setStyle("-fx-font-size: 12; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
            entryBox.getChildren().add(titleLabel);
        }
        
        StringBuilder detailsBuilder = new StringBuilder();
        if (edu.getSchoolName() != null && !edu.getSchoolName().isEmpty()) {
            detailsBuilder.append(edu.getSchoolName());
        }
        if (edu.getGraduationYear() != null && !edu.getGraduationYear().isEmpty()) {
            if (detailsBuilder.length() > 0) detailsBuilder.append(" | ");
            detailsBuilder.append(edu.getGraduationYear());
        }
        
        if (detailsBuilder.length() > 0) {
            Label detailsLabel = new Label(detailsBuilder.toString());
            detailsLabel.setStyle("-fx-font-size: 11; -fx-text-fill: #666;");
            entryBox.getChildren().add(detailsLabel);
        }
        
        cvContent.getChildren().add(entryBox);
    }
    
    private void addWorkExperienceEntry(CVData.WorkExperienceEntry exp) {
        VBox entryBox = new VBox(2);
        entryBox.setPadding(new Insets(5, 0, 10, 0));
        
        // Position and Company
        StringBuilder titleBuilder = new StringBuilder();
        if (exp.getPosition() != null && !exp.getPosition().isEmpty()) {
            titleBuilder.append(exp.getPosition());
        }
        if (exp.getCompanyName() != null && !exp.getCompanyName().isEmpty()) {
            if (titleBuilder.length() > 0) titleBuilder.append(" at ");
            titleBuilder.append(exp.getCompanyName());
        }
        
        if (titleBuilder.length() > 0) {
            Label titleLabel = new Label(titleBuilder.toString());
            titleLabel.setStyle("-fx-font-size: 12; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
            entryBox.getChildren().add(titleLabel);
        }
        
        // Duration
        StringBuilder durationBuilder = new StringBuilder();
        if (exp.getStartDate() != null && !exp.getStartDate().isEmpty()) {
            durationBuilder.append(exp.getStartDate());
        }
        if (exp.getEndDate() != null && !exp.getEndDate().isEmpty()) {
            if (durationBuilder.length() > 0) durationBuilder.append(" - ");
            durationBuilder.append(exp.getEndDate());
        }
        
        if (durationBuilder.length() > 0) {
            Label durationLabel = new Label(durationBuilder.toString());
            durationLabel.setStyle("-fx-font-size: 11; -fx-text-fill: #666;");
            entryBox.getChildren().add(durationLabel);
        }
        
        // Description
        if (exp.getDescription() != null && !exp.getDescription().isEmpty()) {
            Label descLabel = new Label(exp.getDescription());
            descLabel.setStyle("-fx-font-size: 11; -fx-text-fill: #555; -fx-wrap-text: true;");
            descLabel.setWrapText(true);
            entryBox.getChildren().add(descLabel);
        }
        
        cvContent.getChildren().add(entryBox);
    }
    
    private void addProjectEntry(CVData.ProjectEntry project) {
        VBox entryBox = new VBox(2);
        entryBox.setPadding(new Insets(5, 0, 10, 0));
        
        // Project Name
        Label nameLabel = new Label(project.getProjectName());
        nameLabel.setStyle("-fx-font-size: 12; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        entryBox.getChildren().add(nameLabel);
        
        // Description
        if (project.getDescription() != null && !project.getDescription().isEmpty()) {
            Label descLabel = new Label(project.getDescription());
            descLabel.setStyle("-fx-font-size: 11; -fx-text-fill: #555; -fx-wrap-text: true;");
            descLabel.setWrapText(true);
            entryBox.getChildren().add(descLabel);
        }
        
        // Technologies
        if (project.getTechnologies() != null && !project.getTechnologies().isEmpty()) {
            Label techLabel = new Label("Technologies: " + project.getTechnologies());
            techLabel.setStyle("-fx-font-size: 11; -fx-text-fill: #666; -fx-italic: true;");
            entryBox.getChildren().add(techLabel);
        }
        
        cvContent.getChildren().add(entryBox);
    }
    
    @FXML
    private void onBackToEdit() {
        Main.getInstance().showDataEntryScreen();
    }
    
    @FXML
    private void onSaveCV() {
        showAlert("Success", "CV has been saved successfully!");
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
