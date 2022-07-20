package ru.inrtu.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.inrtu.backend.enums.ActivityType;

import javax.persistence.*;
import java.util.Locale;
import java.util.Set;

@Entity
@Table(name = "study_activity")
@Data
@NoArgsConstructor
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
    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "activity", cascade = CascadeType.ALL)
    private Set<Schedule> schedule;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "activity")
    private Set<ActivityHistory>historyRecords;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "activities")
    private Set<Trajectory>trajectories;


}
