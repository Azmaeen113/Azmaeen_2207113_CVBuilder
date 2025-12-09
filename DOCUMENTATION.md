# CV Builder Application

A professional JavaFX-based Curriculum Vitae (CV) Builder application that allows users to create, edit, and preview their CVs through an intuitive multi-screen interface.

## Features

### Application Screens
1. **Home Screen** - Welcome interface with option to create a new CV
2. **Data Entry Form** - Comprehensive form to input personal information, education, work experience, skills, and projects
3. **CV Preview Screen** - Professional CV preview ready for saving

### Data Input Fields
- **Personal Information**: Full Name, Email, Phone Number, Address
- **Education**: Multiple school entries with degree, field of study, and graduation year
- **Skills**: Tag-based skill entry system
- **Work Experience**: Multiple positions with company, role, dates, and description
- **Projects**: Multiple project entries with description and technologies

### Key Functionality
- ✅ Input validation (email format, phone number, required fields)
- ✅ Multiple entry support for education, work experience, and projects
- ✅ Dynamic form fields that can be added/removed
- ✅ Professional CV formatting and layout
- ✅ Easy navigation between screens
- ✅ Success notifications
- ✅ Error handling and user feedback

## Technology Stack
- **Language**: Java 17+
- **GUI Framework**: JavaFX 21.0.3
- **Build Tool**: Apache Maven 3.9.9
- **Architecture**: Model-View-Controller (MVC)

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── cvbuilder/
│   │           ├── Main.java                    # Main application entry point
│   │           ├── controllers/
│   │           │   ├── HomeController.java      # Home screen controller
│   │           │   ├── DataEntryController.java # Form entry controller
│   │           │   └── PreviewController.java   # CV preview controller
│   │           ├── models/
│   │           │   └── CVData.java              # CV data model with inner classes
│   │           └── utils/
│   │               └── ValidationUtils.java     # Form validation utilities
│   └── resources/
│       └── fxml/
│           ├── home.fxml                        # Home screen layout
│           ├── dataEntry.fxml                   # Data entry form layout
│           └── preview.fxml                     # CV preview layout
├── pom.xml                                     # Maven configuration
└── README.md                                   # This file
```

## Building and Running

### Prerequisites
- Java 17 or higher
- Apache Maven 3.9.9 (included in `tools/` directory)

### Build with Maven
```bash
mvn clean compile
```

### Run the Application
```bash
mvn javafx:run
```

Or use the provided batch file:
```bash
run.bat
```

## Code Architecture

### Main.java
- Singleton pattern implementation
- Manages screen transitions between Home, Data Entry, and Preview screens
- Handles scene creation and window management

### Controllers
- **HomeController**: Manages home screen interactions
- **DataEntryController**: Handles form input, validation, and data collection
- **PreviewController**: Displays formatted CV and handles saving

### Models
- **CVData**: Main data model with nested classes for Education, WorkExperience, and Project entries

### Utilities
- **ValidationUtils**: Email and phone number validation functions

## Form Validation Rules

- **Full Name**: Required field
- **Email Address**: Required, must be valid email format (pattern: `^[A-Za-z0-9+_.-]+@(.+)$`)
- **Phone Number**: Required, must contain at least 7 digits/characters (supports `+`, `-`, spaces, parentheses)
- **Education**: At least one entry can be added (optional fields)
- **Skills**: Can add multiple skills as tags
- **Work Experience**: Multiple entries supported with optional descriptions
- **Projects**: Multiple projects with optional technologies field

## UI Components

### Styling
- Professional blue and gray color scheme (#2c3e50, #3498db)
- Clean typography with Segoe UI font family
- Responsive layouts with proper spacing and padding
- Hover effects on buttons for better UX

### Layout Strategy
- BorderPane for main screen structure (header, content, footer)
- GridPane for form label/input alignment
- VBox/HBox for sectional organization
- ScrollPane for overflow handling in form and preview

## Data Flow

```
Home Screen → Create New CV
      ↓
Data Entry Form → Enter all information
      ↓
Validation Check → If valid, proceed; else show error
      ↓
CV Preview → Review formatted output
      ↓
Save CV → Success notification
```

## Usage Example

1. **Launch the application** - The home screen appears with "Create New CV" button
2. **Enter personal information** - Fill in name, email, phone, and address
3. **Add education entries** - Click "Add Education" and fill in school details
4. **Add skills** - Type skill and click "Add Skill"
5. **Add work experience** - Click "Add Work Experience" for each position
6. **Add projects** - Click "Add Project" for portfolio items
7. **Generate CV** - Click "Generate CV" to preview
8. **Review and save** - Review the formatted CV and click "Save CV"

## Future Enhancements
- Profile photo upload capability
- PDF export functionality
- Multiple CV templates
- Auto-save functionality
- Import/Export CV data
- Cloud storage integration

## Notes
- No animation effects are used to maintain professional appearance
- All validations are performed before CV generation
- The application maintains a clean, printable CV format
- Data persists during the session; implement persistent storage for saving between sessions

## Author
CV Builder Development Team

## License
This project is provided as-is for educational and professional use.
