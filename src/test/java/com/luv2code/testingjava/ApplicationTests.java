package com.luv2code.testingjava;

import com.luv2code.testingjava.models.CollegeStudent;
import com.luv2code.testingjava.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ApplicationTests {

    @Value("${info.app.version}")
    String appVersion;
    private static int count = 0;
    @Value("${info.school.name}")
    String schoolName;

    @Value("${info.app.name}")
    String appName;

    @Value("${info.app.description}")
    String appDescription;

    @Autowired
    CollegeStudent student;

    @Autowired
    ApplicationContext context;

    @Autowired
    StudentGrades studentGrades;

    @BeforeEach
    void initParams(){
        count = count + 1;
        System.out.println("Testing: " + appDescription + " which is " + appDescription + " version: " + appVersion
        + ". Execution of the test method " + count);
        student.setFirstname("Eric");
        student.setLastname("Roberts");
        student.setEmailAddress("example@mail.com");
        studentGrades.setMathGradeResults(List.of(100.0, 85.0, 76.50, 91.75));
        student.setStudentGrades(studentGrades);
    }

    @Test
    void addGradeResultForStudentGrades(){
        assertEquals(353.25, studentGrades.addGradeResultsForSingleClass(student
                .getStudentGrades()
                .getMathGradeResults()));
    }

    @Test
    void addGradeResultsForStudentGradesNotEquals(){
        assertNotEquals(0, studentGrades.addGradeResultsForSingleClass(student
                .getStudentGrades()
                .getMathGradeResults()));
    }

    @Test
    void isGradeGreaterStudentGrades(){
        assertTrue(studentGrades.isGradeGreater(90, 75));
    }

    @Test
    void isGreaterFalse(){
        assertFalse(studentGrades.isGradeGreater(75, 90));
    }

    @Test
    void checkNullForStudentsGrades(){
        assertNotNull(studentGrades.checkNull(student.getStudentGrades().getMathGradeResults()));
    }

    @Test
    void createStudentWithoutGradesInit(){
        CollegeStudent collegeStudent = context.getBean("collegeStudent", CollegeStudent.class);
        collegeStudent.setFirstname("Chad");
        collegeStudent.setLastname("Lebowski");
        collegeStudent.setEmailAddress("chad@example.com");
        assertNotNull(collegeStudent.getFirstname());
        assertNotNull(collegeStudent.getLastname());
        assertNotNull(collegeStudent.getEmailAddress());
        assertNotNull(studentGrades.checkNull(collegeStudent.getStudentGrades()));
    }

    @Test
    void findGradesPointAverage(){
        assertAll("Testing all assertEquals", () -> assertEquals(353.25,
                studentGrades.addGradeResultsForSingleClass(student.getStudentGrades().getMathGradeResults())),
                ()-> assertEquals(88.31, studentGrades.findGradePointAverage(
                        student.getStudentGrades().getMathGradeResults()))
        );
    }

}
