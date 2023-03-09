package com.luv2code.testingjava.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeStudent {
    private String firstname;
    private String lastname;
    private String emailAddress;
    private StudentGrades studentGrades;
}
