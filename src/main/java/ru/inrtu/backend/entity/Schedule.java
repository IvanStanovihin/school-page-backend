package ru.inrtu.backend.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_activity_id", nullable = false)
    private StudyActivity activity;

    private String dateOfEvent;
    private String startTime;
    private String endTime;
    private String cabinetNumber;

    public Schedule(StudyActivity activity, String dateOfEvent,
                    String startTime, String endTime, String cabinetNumber) {
        this.activity = activity;
        this.dateOfEvent = dateOfEvent;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cabinetNumber = cabinetNumber;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", dateOfEvent='" + dateOfEvent + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", cabinetNumber='" + cabinetNumber + '\'' +
                '}';
    }
}
