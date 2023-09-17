package edu.mum.cs.cs425.studentmgmt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Transcript {
    @Id
    private int transcriptId;
    private String degreeTitle;
    @OneToOne(mappedBy = "transcript")
    private Student student;
}
