package com.example.eregistrar.controller;

import com.example.eregistrar.model.Student;
import com.example.eregistrar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/eregistrar")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "list";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return "redirect:/eregistrar/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));
        model.addAttribute("student", student);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student updatedStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

        // Update student's data
        student.setStudentNumber(updatedStudent.getStudentNumber());
        student.setFirstName(updatedStudent.getFirstName());
        student.setMiddleName(updatedStudent.getMiddleName());
        student.setLastName(updatedStudent.getLastName());
        student.setCgpa(updatedStudent.getCgpa());
        student.setEnrollmentDate(updatedStudent.getEnrollmentDate());
        student.setIsInternational(updatedStudent.getIsInternational());

        studentRepository.save(student);
        return "redirect:/eregistrar/students";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));
        model.addAttribute("student", student);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentRepository.deleteById(id);
        return "redirect:/eregistrar/students";
    }
}
