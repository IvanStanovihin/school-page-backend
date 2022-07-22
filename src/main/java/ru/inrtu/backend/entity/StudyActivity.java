package ru.inrtu.backend.entity;

import lombok.*;
import ru.inrtu.backend.enums.ActivityType;

import javax.persistence.*;
import java.util.Locale;
import java.util.Set;

@Entity
@Table(name = "study_activity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    //Enum ActivityType
    private String activityType;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "activity")
    private Set<Schedule> schedule;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "activity")
    private Set<ActivityHistory>historyRecords;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "activities")
    private Set<Trajectory>trajectories;

    public void addSchedule(Schedule newSchedule){
        schedule.add(newSchedule);
    }

    @Override
    public String toString(){
        return "StudyActivity{ id= " + id +
                ", name= " + name +
                ", description= " + description +
                ", startDate= " + startDate +
                ", endDate= " + endDate +
                ", participationPoint= " + participationPoint +
                ", maxParticipants= " + maxParticipants +
                ", activityType= " + activityType +
                ", schedule= " + schedule +
                ", trajectories= " + trajectories +
                "}";
    }

}
