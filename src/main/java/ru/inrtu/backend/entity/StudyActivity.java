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
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "activities_trajectories", joinColumns = {@JoinColumn(name = "study_activity_id")},
                inverseJoinColumns = {@JoinColumn(name = "trajectory_id")}
                )
    private Set<Trajectory>trajectories;


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
                ", trajectories= " + trajectories +
                "}";
    }

    public void addTrajectory(Trajectory trajectory){
        trajectories.add(trajectory);
    }

}
