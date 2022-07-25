package ru.inrtu.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @Override
    public String toString() {
        return "Schoolchild{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", educationalOrganization='" + educationalOrganization + '\'' +
                ", educationalClass='" + educationalClass + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
