package edu.mum.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classroomId;
    private String buildingName;
    private String roomNumber;
    @OneToMany(mappedBy = "classroom")
    private List<Student> students;
}
