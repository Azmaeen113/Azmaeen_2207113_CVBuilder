package com.cvbuilder.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class to store all CV data
 */
public class CVData {
    // Personal Information
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String profilePhotoPath;

    // Collections for multiple entries
    private List<EducationEntry> educationList;
    private List<String> skills;
    private List<WorkExperienceEntry> workExperienceList;
    private List<ProjectEntry> projectsList;

    public CVData() {
        this.educationList = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.workExperienceList = new ArrayList<>();
        this.projectsList = new ArrayList<>();
    }

    // Getters and Setters for personal information
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }

    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }

    // Getters and Setters for collections
    public List<EducationEntry> getEducationList() {
        return educationList;
    }

    public void addEducation(EducationEntry education) {
        educationList.add(education);
    }

    public void removeEducation(int index) {
        if (index >= 0 && index < educationList.size()) {
            educationList.remove(index);
        }
    }

    public List<String> getSkills() {
        return skills;
    }

    public void addSkill(String skill) {
        if (!skill.isEmpty()) {
            skills.add(skill);
        }
    }

    public void removeSkill(int index) {
        if (index >= 0 && index < skills.size()) {
            skills.remove(index);
        }
    }

    public List<WorkExperienceEntry> getWorkExperienceList() {
        return workExperienceList;
    }

    public void addWorkExperience(WorkExperienceEntry experience) {
        workExperienceList.add(experience);
    }

    public void removeWorkExperience(int index) {
        if (index >= 0 && index < workExperienceList.size()) {
            workExperienceList.remove(index);
        }
    }

    public List<ProjectEntry> getProjectsList() {
        return projectsList;
    }

    public void addProject(ProjectEntry project) {
        projectsList.add(project);
    }

    public void removeProject(int index) {
        if (index >= 0 && index < projectsList.size()) {
            projectsList.remove(index);
        }
    }

    /**
     * Inner class for Education entries
     */
    public static class EducationEntry {
        private String schoolName;
        private String degree;
        private String fieldOfStudy;
        private String graduationYear;

        public EducationEntry() {
        }

        public EducationEntry(String schoolName, String degree, String fieldOfStudy, String graduationYear) {
            this.schoolName = schoolName;
            this.degree = degree;
            this.fieldOfStudy = fieldOfStudy;
            this.graduationYear = graduationYear;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public String getDegree() {
            return degree;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public String getFieldOfStudy() {
            return fieldOfStudy;
        }

        public void setFieldOfStudy(String fieldOfStudy) {
            this.fieldOfStudy = fieldOfStudy;
        }

        public String getGraduationYear() {
            return graduationYear;
        }

        public void setGraduationYear(String graduationYear) {
            this.graduationYear = graduationYear;
        }
    }

    /**
     * Inner class for Work Experience entries
     */
    public static class WorkExperienceEntry {
        private String companyName;
        private String position;
        private String startDate;
        private String endDate;
        private String description;

        public WorkExperienceEntry() {
        }

        public WorkExperienceEntry(String companyName, String position, String startDate, String endDate, String description) {
            this.companyName = companyName;
            this.position = position;
            this.startDate = startDate;
            this.endDate = endDate;
            this.description = description;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    /**
     * Inner class for Project entries
     */
    public static class ProjectEntry {
        private String projectName;
        private String description;
        private String technologies;

        public ProjectEntry() {
        }

        public ProjectEntry(String projectName, String description, String technologies) {
            this.projectName = projectName;
            this.description = description;
            this.technologies = technologies;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTechnologies() {
            return technologies;
        }

        public void setTechnologies(String technologies) {
            this.technologies = technologies;
        }
    }
}
