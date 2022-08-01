package ru.inrtu.backend.entity.logic;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "study_activity_id", nullable = false)
    private StudyActivity activity;

    private String startEventDate;
    private String endEventDate;
    private String startTime;
    private String endTime;
    private String cabinetNumber;

    public Schedule(StudyActivity activity, String startEventDate, String endEventDate,
                    String startTime, String endTime, String cabinetNumber) {
        this.activity = activity;
        this.startEventDate = startEventDate;
        this.endEventDate = endEventDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cabinetNumber = cabinetNumber;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", startEventDate='" + startEventDate + '\'' +
                ", endEventDate='" + endEventDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", cabinetNumber='" + cabinetNumber + '\'' +
                '}';
    }
}
