# CV Builder - Developer Reference Guide

## Quick Start for Developers

### Environment Setup
```bash
# Navigate to project directory
cd "path/to/Javafx Gui application (1)"

# Build the project
mvn clean compile

# Run the application
mvn javafx:run
```

### Project Dependencies
```xml
<!-- JavaFX Controls (UI components) -->
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>21.0.3</version>
</dependency>

<!-- JavaFX FXML (XML-based UI definitions) -->
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-fxml</artifactId>
    <version>21.0.3</version>
</dependency>
```

---

## Architecture Overview

### MVC Pattern
```
Model (CVData.java)
  ↓
View (FXML files)
  ↓
Controller (Controller classes)
```

### Singleton Pattern
Main.java uses singleton to manage:
- Scene management
- Screen transitions
- Window state

---

## Key Classes Reference

### Main.java
**Purpose**: Application entry point and scene manager

**Key Methods**:
```java
getInstance()              // Get singleton instance
showHomeScreen()          // Display home screen
showDataEntryScreen()     // Display data entry form
showPreviewScreen(cvData) // Display CV preview with data
```

**Screens Managed**:
- Home (home.fxml)
- Data Entry (dataEntry.fxml)
- Preview (preview.fxml)

### CVData.java
**Purpose**: Main data model for CV information

**Structure**:
```
CVData (main container)
├── Personal Info
│   ├── fullName
│   ├── email
│   ├── phoneNumber
│   ├── address
│   └── profilePhotoPath
│
├── Collections
│   ├── educationList (List<EducationEntry>)
│   ├── skills (List<String>)
│   ├── workExperienceList (List<WorkExperienceEntry>)
│   └── projectsList (List<ProjectEntry>)
│
└── Inner Classes
    ├── EducationEntry
    ├── WorkExperienceEntry
    └── ProjectEntry
```

**Key Methods**:
```java
// Personal information setters/getters
setFullName(String), getFullName()
setEmail(String), getEmail()
setPhoneNumber(String), getPhoneNumber()
setAddress(String), getAddress()

// Collection operations
addEducation(EducationEntry), removeEducation(int)
addSkill(String), removeSkill(int)
addWorkExperience(WorkExperienceEntry), removeWorkExperience(int)
addProject(ProjectEntry), removeProject(int)

// Getters
getEducationList(), getSkills(), getWorkExperienceList(), getProjectsList()
```

### HomeController.java
**Purpose**: Manage home screen interactions

**Key Methods**:
```java
onCreateNewCV()  // Navigate to data entry on button click
```

**FXML Elements**:
- titleLabel: Main heading
- createButton: "Create New CV" button
- headerPane: Top blue header section
- welcomeLabel: Welcome text
- descriptionLabel: Description text

### DataEntryController.java
**Purpose**: Handle form input, validation, and data collection

**Key Responsibilities**:
1. Form initialization
2. Dynamic field generation
3. Data validation
4. Data collection from fields
5. Navigation between screens

**Key Methods**:
```java
// Initialization
initialize()  // Set up initial form state

// Field operations
addEducationField()         // Add new education entry
addWorkExperienceField()    // Add new work experience
addProjectField()           // Add new project
addSkillField()            // Add skill UI element
updateSkillsDisplay()      // Refresh skills display

// Validation
validateForm()             // Validate all required fields
isValidEmail()            // Email format validation
isValidPhone()            // Phone format validation

// Data handling
collectFormData()         // Gather all form values into CVData
onGenerateCV()           // Validate and generate preview

// Navigation
onBackToHome()           // Return to home screen
```

**FXML Elements** (injected with @FXML):
```
Personal Information:
- fullNameField: TextField
- emailField: TextField
- phoneField: TextField
- addressArea: TextArea

Containers:
- educationContainer: VBox
- workExperienceContainer: VBox
- projectsContainer: VBox
- skillsContainer: VBox

Input Fields:
- skillInput: TextField

Buttons:
- addEducationBtn: Button
- addWorkExpBtn: Button
- addProjectBtn: Button
- addSkillBtn: Button
- backButton: Button
- generateButton: Button
```

**Dynamic Field Creation**:
Each entry type is created as a VBox containing:
- Title label (e.g., "Education #1")
- GridPane with input fields
- Remove button
- UserData object storing field references

Example structure:
```java
VBox educationBox
├── Label ("Education #1")
├── GridPane
│   ├── Labels + TextFields for input
└── Button (Remove)

// Stored in educationBox.setUserData(Object[] fields)
// for later retrieval
```

### PreviewController.java
**Purpose**: Display formatted CV and manage preview interactions

**Key Methods**:
```java
setCVData(CVData)        // Set the data to display
generatePreview()        // Format and display CV

// Helper methods for formatting
createContactInfo()      // Format contact line
addSection(String)       // Add section header
addSeparator()          // Add visual separator
addEducationEntry()     // Format education entry
addWorkExperienceEntry()// Format work experience
addProjectEntry()       // Format project entry

// Navigation
onBackToEdit()          // Return to data entry form
onSaveCV()             // Save action (shows notification)
```

### ValidationUtils.java
**Purpose**: Provide validation utilities

**Static Methods**:
```java
isValidEmail(String)          // Check email format
isValidPhoneNumber(String)    // Check phone format (7+ digits)
isEmpty(String)              // Check if string is empty/null
isValidRequired(String)       // Check required field
```

**Regex Patterns**:
```java
EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$"
PHONE_PATTERN = "^[0-9+\\-\\s()]{7,}$"
```

---

## FXML Binding and Controller Mapping

### home.fxml
```xml
<BorderPane fx:controller="com.cvbuilder.controllers.HomeController">
    <!-- Controller automatically injects elements with fx:id -->
    <Button fx:id="createButton" onAction="#onCreateNewCV"/>
</BorderPane>
```

### dataEntry.fxml
```xml
<BorderPane fx:controller="com.cvbuilder.controllers.DataEntryController">
    <TextField fx:id="fullNameField"/>
    <VBox fx:id="educationContainer"/>
    <!-- All elements with fx:id are injected into controller -->
</BorderPane>
```

### preview.fxml
```xml
<BorderPane fx:controller="com.cvbuilder.controllers.PreviewController">
    <VBox fx:id="cvContent"/>
    <!-- Content is populated programmatically -->
</BorderPane>
```

---

## Data Flow Diagram

```
Home Screen
    ↓ Click "Create New CV"
Data Entry Form
    ↓ User fills form
Form Fields (TextFields, TextAreas, VBoxes)
    ↓ Click "Generate CV"
Validation Check
    ├─ If Invalid → Show Error Alert
    └─ If Valid → Collect Data
            ↓
        CVData Object (populated from form)
            ↓
        Show Preview Screen
            ↓
        PreviewController.setCVData()
            ↓
        generatePreview()
            ↓
        Format and Display CV
            ↓
        User clicks "Save" or "Edit"
```

---

## Adding New Features

### Add a New Form Field

1. **Update CVData.java**:
   ```java
   private String newField;
   
   public String getNewField() { return newField; }
   public void setNewField(String newField) { this.newField = newField; }
   ```

2. **Update dataEntry.fxml**:
   ```xml
   <Label text="New Field:" styleClass="form-label"/>
   <TextField fx:id="newFieldInput"/>
   ```

3. **Update DataEntryController.java**:
   ```java
   @FXML
   private TextField newFieldInput;
   
   // In validateForm() if required:
   if (ValidationUtils.isEmpty(newFieldInput.getText())) {
       showAlert("Validation Error", "New Field is required");
       return false;
   }
   
   // In collectFormData():
   cvData.setNewField(newFieldInput.getText().trim());
   ```

4. **Update PreviewController.java**:
   ```java
   // In generatePreview():
   if (cvData.getNewField() != null && !cvData.getNewField().isEmpty()) {
       addSection("NEW FIELD", cvData.getNewField());
   }
   ```

### Add a New Section Type (Like Education)

1. Create inner class in CVData:
   ```java
   public static class NewSectionEntry {
       private String field1;
       private String field2;
       // getters/setters
   }
   ```

2. Add collection in CVData:
   ```java
   private List<NewSectionEntry> newSectionList = new ArrayList<>();
   
   public void addNewSection(NewSectionEntry entry) {
       newSectionList.add(entry);
   }
   // etc.
   ```

3. Create UI generation method in DataEntryController:
   ```java
   @FXML
   private void onAddNewSection() {
       addNewSectionField();
   }
   
   private void addNewSectionField() {
       // Create VBox with fields similar to education/work experience
   }
   ```

4. Collect in collectFormData():
   ```java
   cvData.getNewSectionList().clear();
   for (javafx.scene.Node node : newSectionContainer.getChildren()) {
       // Extract and add entries
   }
   ```

5. Display in PreviewController:
   ```java
   if (!cvData.getNewSectionList().isEmpty()) {
       addSection("NEW SECTION");
       for (CVData.NewSectionEntry entry : cvData.getNewSectionList()) {
           addNewSectionEntry(entry);
       }
   }
   ```

---

## Styling Reference

### Color Scheme
```
Primary Dark Blue: #2c3e50
Bright Blue: #3498db
Light Gray: #ecf0f1
Dark Gray: #95a5a6
Green (Success): #27ae60
Red (Error): #e74c3c
Text Dark: #333333
Text Light: #555555
```

### Font Hierarchy
```
Name: 28px, bold
Section titles: 14px, bold
Content: 12px, regular
Details: 11px, regular
Form labels: 12px, bold
Form input: 11px, regular
```

### Layout Spacing
```
Header padding: 20px
Content padding: 15-20px
Section spacing: 15px
Field spacing: 10px
Button padding: 10-12px
```

---

## Testing Checklist

- [ ] Home screen displays correctly
- [ ] "Create New CV" button navigates to form
- [ ] All form fields are visible and functional
- [ ] Can add/remove education entries
- [ ] Can add/remove skills
- [ ] Can add/remove work experience entries
- [ ] Can add/remove projects
- [ ] Form validation works:
  - [ ] Required field check
  - [ ] Email format validation
  - [ ] Phone format validation
- [ ] Error alerts display correctly
- [ ] CV preview shows all data
- [ ] "Edit CV" goes back to form
- [ ] Can navigate between screens smoothly

---

## Debugging Tips

### Check FXMLLoader Issues
```java
FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/file.fxml"));
Parent root = loader.load(); // Throws IOException if issues
```

### Inspect Scene Graph
Use JavaFX Scene Builder for visual debugging of FXML.

### Log Data Collection
```java
System.out.println("CVData fullName: " + cvData.getFullName());
System.out.println("Education count: " + cvData.getEducationList().size());
```

### Validation Debugging
```java
if (!ValidationUtils.isValidEmail(email)) {
    System.out.println("Invalid email: " + email);
    showAlert("Error", "Email invalid");
}
```

---

## Common Issues and Solutions

| Issue | Cause | Solution |
|-------|-------|----------|
| FXML not loading | Wrong path in getResource() | Check `/fxml/` directory |
| Controller not injecting fields | Missing fx:id or wrong controller name | Verify FXML and class names |
| Data not persisting | Not collecting form data | Check collectFormData() is called |
| Validation bypassed | Condition logic error | Review validateForm() logic |
| UI elements not updating | Not calling updateDisplay() | Ensure refresh methods are called |
| Window too small | Window size hardcoded | Modify in Main.java: `setWidth()`, `setHeight()` |

---

## Performance Considerations

1. **Scene Caching**: HomeScene and DataEntryScene are cached in Main.java
2. **Preview Scene**: Recreated each time to reflect latest data
3. **Dynamic UI**: VBox children are cleared and repopulated when needed
4. **No Animations**: Application focuses on functionality, not visual effects

---

## Future Enhancement Ideas

1. **File I/O**: Save/load CV data to JSON or XML
2. **PDF Export**: Generate PDF from CV preview
3. **Templates**: Multiple CV templates/themes
4. **Cloud Sync**: Store CVs in cloud storage
5. **Auto-save**: Periodic saving of form data
6. **Undo/Redo**: Track form changes
7. **Image Upload**: Profile photo handling
8. **Multiple CVs**: Save and manage multiple CV versions

---

## Code Style Guidelines

- Use camelCase for variables and methods
- Use UPPER_SNAKE_CASE for constants
- Use PascalCase for class names
- Keep methods focused and single-responsibility
- Use meaningful variable names (not x, y, temp)
- Comment complex logic
- Follow JavaFX naming conventions

---

## Resources

- [JavaFX Documentation](https://openjfx.io/)
- [JavaFX Scene Builder](https://gluonhq.com/products/scene-builder/)
- [Maven Documentation](https://maven.apache.org/)
- [Java Language Specification](https://docs.oracle.com/javase/specs/)

---

**Last Updated**: December 2025
**Version**: 1.0
**Status**: Production Ready
