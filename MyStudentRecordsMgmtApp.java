package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
        Student[] students = new Student[5]; // Create an array of Student objects

        students[0] = new Student(110001, "Dave", LocalDate.of(1951, 11, 18));
        students[1] = new Student(110002, "Anna", LocalDate.of(1990, 12, 7));
        students[2] = new Student(110003, "Erica", LocalDate.of(1974, 1, 31));
        students[3] = new Student(110004, "Carlos", LocalDate.of(2009, 8, 22));
        students[4] = new Student(110005, "Bob", LocalDate.of(1990, 3, 5));
        
        List<Student> platinumAlumniStudents = getListOfPlatinumAlumniStudents(students);
        for (Student student : platinumAlumniStudents) {
            System.out.println(student);
        }
        printStudents(students);
        
    }
    public static void printStudents(Student students[]) {
        Arrays.sort(students, Comparator.comparing(Student::getName));
    	for (Student student : students) {
            System.out.println(student);
        }
    }
    
    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        List<Student> platinumAlumniStudents = new ArrayList<>();

        // Calculate the cutoff year for PlatinumAlumni students (30 years ago)
        LocalDate cutoffDate = LocalDate.now().minusYears(30);

        // Filter students who meet the PlatinumAlumni criteria
        for (Student student : students) {
            if (student.getDateOfAdmission().isBefore(cutoffDate)) {
                platinumAlumniStudents.add(student);
            }
        }

        // Sort the list of PlatinumAlumni students by dates of admission in descending order
        platinumAlumniStudents.sort(Comparator.comparing(Student::getDateOfAdmission).reversed());
        

        return platinumAlumniStudents;
    }
}






