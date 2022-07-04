package ru.inrtu.backend.entity;

import ru.inrtu.backend.enums.ActivityType;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Schoolchild {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String fatherName;
    private String educationalOrganization;
    private String educationalClass;
    private String email;
    private String phoneNumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "schoolchild")
    private Set<ActivityHistory> activityHistory;

    public Schoolchild(Long id, String name, String surname, String fatherName, String educationalOrganization,
                       String educationalClass, String email, String phoneNumber, Set<ActivityHistory> activityHistory) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.educationalOrganization = educationalOrganization;
        this.educationalClass = educationalClass;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.activityHistory = activityHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getEducationalOrganization() {
        return educationalOrganization;
    }

    public void setEducationalOrganization(String educationalOrganization) {
        this.educationalOrganization = educationalOrganization;
    }

    public String getEducationalClass() {
        return educationalClass;
    }

    public void setEducationalClass(String educationalClass) {
        this.educationalClass = educationalClass;
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

    public Set<ActivityHistory> getActivityHistory() {
        return activityHistory;
    }

    public void setActivityHistory(Set<ActivityHistory> activityHistory) {
        this.activityHistory = activityHistory;
    }
}
