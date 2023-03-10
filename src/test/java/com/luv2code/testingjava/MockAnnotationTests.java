package com.luv2code.testingjava;

import com.luv2code.testingjava.dao.ApplicationDao;
import com.luv2code.testingjava.models.CollegeStudent;
import com.luv2code.testingjava.models.StudentGrades;
import com.luv2code.testingjava.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MockAnnotationTests {

    CollegeStudent studentOne;

    StudentGrades studentGrades;

    @Mock
    private ApplicationDao applicationDao;

    @InjectMocks
    private ApplicationService applicationService;

    @BeforeEach
    void setUp(){
        studentOne = new CollegeStudent("John", "Doe", "example@mail.com");
        studentGrades = new StudentGrades(List.of(88.31, 88.31));
        studentOne.setStudentGrades(studentGrades);
    }

    @Test
    void assertEqualsTestAddGrades(){
        //set up
        when(applicationDao.addGradeResultsForSingleClass(studentGrades.getMathGradeResults()))
                .thenReturn(100.0);

        assertEquals(100, applicationService
                .addGradeResultsForSingleClass(studentOne.getStudentGrades().getMathGradeResults()));
        verify(applicationDao, times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
    }

    @Test
    void assertEqualsTestFindGpa(){
        when(applicationDao.findGradePointAverage(studentGrades.getMathGradeResults()))
                .thenReturn(88.31);
        assertEquals(88.31, applicationService
                .findGradePointAverage(studentOne.getStudentGrades().getMathGradeResults()));
    }

    @Test
    void testAssertNotNull(){
        when(applicationDao.checkNull(studentOne.getStudentGrades()))
                .thenReturn(studentGrades);
        assertNotNull(applicationService.checkNull(studentGrades));
    }

    @Test
    void throwRuntimeError(){
        CollegeStudent nullStudent = null;
        doThrow(new RuntimeException()).when(applicationDao).checkNull(nullStudent);
        assertThrows(RuntimeException.class, () -> {
            applicationService.checkNull(nullStudent);
        });
        verify(applicationDao, times(1)).checkNull(nullStudent);
    }

    @Test
    void stubbingConsecutiveCalls() {
        CollegeStudent nullStudent = new CollegeStudent();
        when(applicationDao.checkNull(nullStudent))
                .thenThrow(new RuntimeException())
                .thenReturn("Do not throw exception second time");

        assertThrows(RuntimeException.class, () -> {
            applicationService.checkNull(nullStudent);
        });

        assertEquals("Do not throw exception second time",
                applicationService.checkNull(nullStudent));

        verify(applicationDao, times(2)).checkNull(nullStudent);
    }

    @Test
    void studentBeforeEach(){
        ReflectionTestUtils.setField(studentOne, "id", 1);
        assertEquals(1, ReflectionTestUtils.getField(studentOne, "id"));
    }

    @Test
    void invokePrivateMethod(){
        ReflectionTestUtils.setField(studentOne, "id", 1);
        assertEquals("John 1", ReflectionTestUtils.invokeMethod(studentOne, "getFirstnameAndId"));
    }

}
