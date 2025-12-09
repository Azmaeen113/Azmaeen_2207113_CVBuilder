# CV Builder - User Guide

## Getting Started

### Starting the Application

1. **Using Maven**:
   ```bash
   mvn javafx:run
   ```

2. **Using the batch file** (Windows):
   ```bash
   run.bat
   ```

The application window will open (900x700 pixels) with the home screen.

---

## Screen-by-Screen Walkthrough

### 1. Home Screen

**What You See:**
- CV Builder header in dark blue
- Welcome message
- "Create New CV" button

**What You Do:**
- Click the "Create New CV" button to proceed to the data entry form

---

### 2. Data Entry Form Screen

This is where you input all your CV information. The form is organized into sections:

#### **Personal Information Section**
Required fields marked with asterisk (*):

- **Full Name*** - Enter your complete name
  - Example: "John Michael Smith"
  - **Required**: Yes
  
- **Email Address*** - Enter your email
  - Example: "john.smith@example.com"
  - **Required**: Yes
  - **Validation**: Must be a valid email format

- **Phone Number*** - Enter your contact number
  - Example: "+1 (555) 123-4567" or "555-123-4567"
  - **Required**: Yes
  - **Validation**: Must contain at least 7 digits

- **Address** - Your residential address
  - Example: "123 Main Street, New York, NY 10001"
  - **Required**: No
  - **Type**: Text area (multi-line)

#### **Educational Qualifications Section**

The form starts with one education field. You can add more by clicking "+ Add Education".

**For Each Education Entry:**
- **School Name** - Name of educational institution
  - Example: "University of Technology"
  
- **Degree** - Your degree type
  - Example: "Bachelor of Science"
  
- **Field of Study** - Your major/specialization
  - Example: "Computer Science"
  
- **Graduation Year** - Year you graduated/will graduate
  - Example: "2023" or "May 2023"

**Actions:**
- Click "+ Add Education" to add more entries
- Click "Remove" button on any education box to delete it

#### **Skills Section**

This section uses a tag-based system.

**How to Add Skills:**
1. Type a skill name in the text field
   - Example: "Java"
2. Click "Add Skill" button
3. The skill appears as a tag below the input field
4. Each skill tag has a "×" button to remove it

**Example Skills:**
- Programming: Java, Python, JavaScript, C++
- Tools: Git, Maven, Docker, Jenkins
- Concepts: Object-Oriented Programming, Design Patterns, Agile
- Soft Skills: Leadership, Communication, Problem Solving

#### **Work Experience Section**

Click "+ Add Work Experience" to add entries.

**For Each Work Experience Entry:**
- **Company Name** - Your employer
  - Example: "Tech Solutions Inc."
  
- **Position** - Your job title
  - Example: "Senior Software Engineer"
  
- **Start Date** - When you started
  - Format: "MM/YYYY"
  - Example: "01/2020"
  
- **End Date** - When you left (or write "Present" if current)
  - Format: "MM/YYYY" or "Present"
  - Example: "12/2023" or "Present"
  
- **Description** - Your responsibilities and achievements
  - Example: "Led development of microservices architecture, mentored junior developers, improved system performance by 40%"

**Actions:**
- Click "+ Add Work Experience" to add more positions
- Click "Remove" button to delete an entry

#### **Projects Section**

Click "+ Add Project" to add your portfolio items.

**For Each Project Entry:**
- **Project Name** - Title of your project
  - Example: "E-commerce Platform"
  
- **Description** - What the project does
  - Example: "Developed a full-stack e-commerce platform with real-time inventory management and payment processing integration"
  
- **Technologies** - Tools and languages used
  - Format: Comma-separated list
  - Example: "Java, JavaFX, Spring Boot, MySQL, Apache Maven"

**Actions:**
- Click "+ Add Project" to add more projects
- Click "Remove" button to delete a project

---

### Generating Your CV

**Before You Generate:**
- Make sure all required fields are filled:
  - ✓ Full Name
  - ✓ Email Address
  - ✓ Phone Number
- The form will validate your entries

**Common Validation Errors:**

| Error | Solution |
|-------|----------|
| "Full Name is required" | Enter your name in the Full Name field |
| "Email Address is required" | Enter your email address |
| "Please enter a valid email address" | Use format: `example@domain.com` |
| "Phone Number is required" | Enter your phone number |
| "Please enter a valid phone number" | Must have at least 7 digits |

**Generating:**
1. Ensure all required fields are filled
2. Scroll to the bottom of the form
3. Click the green "Generate CV →" button
4. If validation passes, you'll see your CV preview
5. If validation fails, an error message will appear

---

### 3. CV Preview Screen

**What You See:**
- Your CV formatted professionally
- All sections neatly organized:
  - Header with your name
  - Contact information
  - Address (if provided)
  - Education
  - Skills (as bullet points)
  - Work experience with dates
  - Projects with technologies

**The CV Format:**
```
JOHN MICHAEL SMITH
john.smith@example.com | +1 (555) 123-4567

ADDRESS
123 Main Street, New York, NY 10001

EDUCATION
Bachelor of Science in Computer Science
University of Technology | 2023

SKILLS
• Java
• Python
• Spring Boot
• ...

WORK EXPERIENCE
Senior Software Engineer at Tech Solutions Inc.
01/2020 - Present
Led development of microservices architecture...

PROJECTS
E-commerce Platform
Developed a full-stack e-commerce platform...
Technologies: Java, JavaFX, Spring Boot, MySQL
```

**Actions Available:**
- **← Edit CV** - Go back to the form to make changes
- **Save CV** - Shows a success message

---

## Tips for Creating a Great CV

### Personal Information
- Use your professional email address
- Include your current phone number
- Keep the address brief (city, state is usually enough)

### Education
- List education in reverse chronological order (most recent first)
- Include GPA if it's 3.5 or higher
- Add relevant coursework if just graduated

### Skills
- List 8-15 relevant skills
- Include technical skills AND soft skills
- Prioritize skills mentioned in job descriptions
- Organize by category (languages, tools, concepts)

### Work Experience
- List jobs in reverse chronological order
- Use action verbs: "Led", "Developed", "Designed", "Implemented"
- Quantify achievements: "increased sales by 30%", "reduced load time by 50%"
- Include 2-5 bullet points per position
- Make it clear what you accomplished

### Projects
- Include academic projects, personal projects, or open-source contributions
- Add description of your role and contribution
- List all relevant technologies used
- Can include GitHub links or project websites in description

---

## Workflow Example

### Step-by-Step Example Session:

**1. Home Screen**
   - Click "Create New CV"

**2. Data Entry**
   - Full Name: `Jane Davis`
   - Email: `jane.davis@email.com`
   - Phone: `+1-555-987-6543`
   - Address: `San Francisco, CA 94105`

**3. Add Education**
   - School: `Stanford University`
   - Degree: `Master of Science`
   - Field: `Computer Science`
   - Year: `2022`

**4. Add Skills**
   - Click "Add Skill" for: Python, Java, Machine Learning, TensorFlow, Data Analysis
   
**5. Add Work Experience**
   - Company: `Tech Giants Inc.`
   - Position: `ML Engineer`
   - Start: `06/2022`
   - End: `Present`
   - Description: `Developed and deployed machine learning models for recommendation systems. Achieved 35% improvement in prediction accuracy.`

**6. Add Project**
   - Name: `Predictive Analytics Platform`
   - Description: `Built a real-time analytics dashboard for forecasting customer behavior`
   - Technologies: `Python, TensorFlow, FastAPI, PostgreSQL, React`

**7. Generate CV**
   - Click "Generate CV →"
   - Review the formatted CV

**8. Save**
   - Click "Save CV"
   - See success notification

---

## Keyboard Shortcuts

| Action | Shortcut |
|--------|----------|
| Focus next field | `Tab` |
| Focus previous field | `Shift + Tab` |
| Submit form | Not applicable (use button) |

---

## Troubleshooting

### Application won't start
- Ensure Java 17+ is installed
- Check Maven is working: `mvn --version`
- Try: `mvn clean compile` first

### Validation errors
- Check all required fields (marked with *)
- Email must have @ symbol and domain
- Phone must have at least 7 digits
- Can include +, -, spaces, parentheses in phone

### CV not displaying correctly
- Scroll down to see all content
- Make sure you added the content before generating
- Try editing and generating again

### Fields not saving
- Data is temporary - only persists in current session
- Once you navigate away from the form, changes are lost
- Save/export feature is for notification only in this version

---

## Data Limits

- Full Name: No specific limit (keep professional, 100 chars recommended)
- Email: Standard email length (320 chars max)
- Phone: Any reasonable format (50 chars recommended)
- Address: Use text area, can be multi-line
- Education entries: Unlimited add/remove
- Skills: Can add as many as needed (10-20 recommended)
- Work experience: Unlimited add/remove
- Projects: Unlimited add/remove
- Text areas: No specific limit (keep reasonable, 1000 chars recommended)

---

## Professional Tips

✅ **DO:**
- Keep it clean and organized
- Use professional language
- Quantify achievements
- List items in reverse chronological order
- Proofread before saving
- Tailor to job descriptions

❌ **DON'T:**
- Use unprofessional email addresses
- Include irrelevant information
- Exceed 2 pages (keep it concise)
- Use slang or informal language
- Include salary expectations
- Add photo (unless specifically requested)

---

## Getting the Most from Your CV

1. **Customize for each job**: Edit the CV for different applications
2. **Update regularly**: Add new skills and experiences
3. **Export as PDF**: Use your browser or PDF printer when needed
4. **Share professionally**: Use your CV on LinkedIn
5. **Get feedback**: Have others review before submitting

---

For technical support or feature requests, refer to the DOCUMENTATION.md file or contact the development team.
