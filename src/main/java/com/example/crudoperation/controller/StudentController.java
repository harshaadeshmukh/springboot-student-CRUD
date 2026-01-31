package com.example.crudoperation.controller;

import com.example.crudoperation.entity.StudentData;
import com.example.crudoperation.exception.ResourceNotFound;
import com.example.crudoperation.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.StubNotFoundException;
import java.util.Iterator;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/getStudent")
    public List<StudentData> getStudent()
    {
        return studentRepository.findAll();
    }

    @RequestMapping(path = "/getStudent/{id}" ,method=RequestMethod.GET)
    public String getStudentBydId(@PathVariable int id)
    {
        for(StudentData s: studentRepository.findAll())
        {
            if(s.getId() ==id)
            {
                return "Student Details\n "+s.getName() + " " + s.getId();
            }
        }

        return "Student id "+id+" not found";
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody StudentData student)
    {
        for(StudentData s : studentRepository.findAll())
        {
            if(s.getId()==student.getId())
            {
                return "Student Id "+ student.getId() + " exists in databases, Use Another Id";
            }
        }
        studentRepository.save(student);
        return "Student Data Added";
    }

//    We can apply both logic PatchMapping as per below
    @PatchMapping("/updateStudent/{id}")
    @Transactional
    public String updateStudent(@RequestBody StudentData s, @PathVariable int id)
    {
        //        StudentData old = studentRepository.findById(id)
//                .orElseThrow(()-> new RuntimeException("Student data not found"));
//
//        old.setName(s.getName());
//
//        return studentRepository.save(old);

        List<StudentData> list = studentRepository.findAll();

        for (StudentData s1 : list) {
            if (s1.getId() == id) {
                s1.setName(s.getName());
                return "Student ID " + id + " has been updated";
            }
        }
        throw new ResourceNotFound("Student ID not found");
    }


//    @PatchMapping("/updateStudent/{id}")
//    @Transactional
//    public String updateStudent(@RequestBody StudentData s, @PathVariable int id) {
//
//        StudentData old = studentRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFound("Student data not found"));
//
//        old.setName(s.getName());
//
//        return "Student ID " + id + " has been updated";
//    }


    @DeleteMapping("/delStudent/{id}")
    public String DeleteStudent(@PathVariable int id)
    {
        List<StudentData> list = studentRepository.findAll();

        Iterator<StudentData> it = list.iterator();

        while(it.hasNext())
        {
            StudentData s1 = it.next();
            if(id == s1.getId())
            {
                studentRepository.delete(s1);
                return "Student id "+id + " is deleted";
            }
        }
        throw new ResourceNotFound("Student with id " + id + " not found");
    }


}