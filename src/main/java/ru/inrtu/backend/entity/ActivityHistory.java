package ru.inrtu.backend.entity;

import ru.inrtu.backend.enums.ActivityProgress;

import javax.persistence.*;

@Entity
public class ActivityHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schoolchild_id", nullable = false)
    private Schoolchild schoolchild;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "study_activity_id", nullable = false)
    private StudyActivity activity;

    private ActivityProgress historyRecordType;
    private String recordCreateDate;

    public ActivityHistory(Long id, Schoolchild schoolchild, StudyActivity activity,
                           ActivityProgress historyRecordType, String recordCreateDate) {
        this.id = id;
        this.schoolchild = schoolchild;
        this.activity = activity;
        this.historyRecordType = historyRecordType;
        this.recordCreateDate = recordCreateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Schoolchild getSchoolchild() {
        return schoolchild;
    }

    public void setSchoolchild(Schoolchild schoolchild) {
        this.schoolchild = schoolchild;
    }

    public StudyActivity getActivity() {
        return activity;
    }

    public void setActivity(StudyActivity activity) {
        this.activity = activity;
    }

    public ActivityProgress getHistoryRecordType() {
        return historyRecordType;
    }

    public void setHistoryRecordType(ActivityProgress historyRecordType) {
        this.historyRecordType = historyRecordType;
    }

    public String getRecordCreateDate() {
        return recordCreateDate;
    }

    public void setRecordCreateDate(String recordCreateDate) {
        this.recordCreateDate = recordCreateDate;
    }
}
