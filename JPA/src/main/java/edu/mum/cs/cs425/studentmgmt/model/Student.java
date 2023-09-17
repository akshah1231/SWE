package edu.mum.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long StudentId;
    @Column(nullable = false, unique = true)
    private String Studentnumber;
    @Column(nullable = false)
    private String firstName;
    private String middleName;
    @Column(nullable = false)
    private String lastName;
    private Double cgpa;
    @Temporal(TemporalType.DATE)
    private Date dateOfEnrollment;
    @ManyToOne
    @JoinColumn(name="classroomId")
    private Classroom classroom;
    @OneToOne
    private Transcript transcript;
}
