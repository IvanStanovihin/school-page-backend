package ru.inrtu.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"activityHistory"})
public class Schoolchild {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String fatherName;
    private String educationalOrganization;
    private String educationalClass;
    private String email;
    private String phoneNumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "schoolchild")
    private Set<ActivityHistory> activityHistory;

}
