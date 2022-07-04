package ru.inrtu.backend.entity;

import ru.inrtu.backend.enums.ActivityType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "study_activity")
public class StudyActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private Integer participationPoint;
    private Integer maxParticipants;
    private ActivityType activityType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "activity")
    private Set<Schedule> schedule;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "activity")
    private Set<ActivityHistory>historyRecords;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "activities")
    private Set<Trajectory>trajectories;

    public StudyActivity(Long id, String name, String description, String startDate, String endDate,
                         Integer participationPoint, Integer maxParticipants, ActivityType activityType,
                         Set<ActivityHistory> historyRecords, Set<Trajectory> trajectories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.participationPoint = participationPoint;
        this.maxParticipants = maxParticipants;
        this.activityType = activityType;
        this.historyRecords = historyRecords;
        this.trajectories = trajectories;
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

    public Integer getParticipationPoint() {
        return participationPoint;
    }

    public void setParticipationPoint(Integer participationPoint) {
        this.participationPoint = participationPoint;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public Set<ActivityHistory> getHistoryRecords() {
        return historyRecords;
    }

    public void setHistoryRecords(Set<ActivityHistory> historyRecords) {
        this.historyRecords = historyRecords;
    }

    public Set<Trajectory> getTrajectories() {
        return trajectories;
    }

    public void setTrajectories(Set<Trajectory> trajectories) {
        this.trajectories = trajectories;
    }
}
