package ru.inrtu.backend.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Trajectory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(name = "activity_trajectory",
                joinColumns = @JoinColumn(name = "trajectory_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "study_activity_id", referencedColumnName = "id")
                )
    private Set<StudyActivity> activities;

    public Trajectory(Long id, String name, String description, Set<StudyActivity> activities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.activities = activities;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<StudyActivity> getActivities() {
        return activities;
    }

    public void setActivities(Set<StudyActivity> activities) {
        this.activities = activities;
    }
}
