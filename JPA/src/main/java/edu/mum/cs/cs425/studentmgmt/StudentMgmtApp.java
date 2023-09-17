package edu.mum.cs.cs425.studentmgmt;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(StudentMgmtApp.class, args);
    }

    @Override
    public void run(String... args) throws ParseException {
        // Create a new Transcript
        Transcript transcript = new Transcript();
        transcript.setDegreeTitle("BS Computer Science");

        // Create a new Classroom
        Classroom classroom = new Classroom();
        classroom.setBuildingName("McLaughlin building");
        classroom.setRoomNumber("M105");

        // Create a new Student
        Student student = new Student();
        student.setStudentnumber("000-61-0001");
        student.setFirstName("Anna");
        student.setMiddleName("Lynn");
        student.setLastName("Smith");
        student.setCgpa(3.45);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date enrollmentDate = dateFormat.parse("2019/05/24");
        student.setDateOfEnrollment(enrollmentDate);
        student.setTranscript(transcript);
        student.setClassroom(classroom);

        // Save the student, transcript, and classroom to the database
        studentService.saveStudent(student);

        System.out.println("Student saved to the database.");
    }
}
