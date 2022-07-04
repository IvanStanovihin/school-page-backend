package ru.inrtu.backend.entity;

import javax.persistence.*;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "study_activity_id", nullable = false)
    private StudyActivity activity;

    private String dateOfEvent;
    private String startTime;
    private String endTime;
    private String cabinetNumber;

    public Schedule(Long id, StudyActivity activity, String dateOfEvent,
                    String startTime, String endTime, String cabinetNumber) {
        this.id = id;
        this.activity = activity;
        this.dateOfEvent = dateOfEvent;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cabinetNumber = cabinetNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudyActivity getActivity() {
        return activity;
    }

    public void setActivity(StudyActivity activity) {
        this.activity = activity;
    }

    public String getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(String cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }
}
