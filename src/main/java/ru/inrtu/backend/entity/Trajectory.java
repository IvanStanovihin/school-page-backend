package ru.inrtu.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    public Trajectory(String name, String description, Set<StudyActivity> activities) {
        this.name = name;
        this.description = description;
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Trajectory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
