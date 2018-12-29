package tests;

import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TranscriptTest {

    private Transcript testTranscript1;
    private Transcript testTranscript2;
    private Transcript testTranscript3;

    @Before
    public void setUp() {
        testTranscript1 = new Transcript("Alexey Filatov", 15);
        testTranscript2 = new Transcript("John Smith Jr.", 23);
        testTranscript3 = new Transcript("Mary Jane", 184);
    }

    @Test
    public void testGetStudentName() {
        assertEquals(testTranscript1.getStudentName(), "Alexey Filatov");
        assertEquals(testTranscript2.getStudentName(), "John Smith Jr.");
        assertEquals(testTranscript3.getStudentName(), "Mary Jane");
    }

    @Test
    public void testAddGrade() {
        String courseName1 = "UBCx Micromasters";
        String courseName2 = "Some stuff";

        assertNull(testTranscript1.getCourseAndGrade(courseName1));
        testTranscript1.addGrade(courseName1, 3.8);
        assertEquals(testTranscript1.getCourseAndGrade(courseName1), courseName1 + ": 3.8");

        assertNull(testTranscript1.getCourseAndGrade(courseName2));
        testTranscript1.addGrade(courseName2, 2.7);
        assertEquals(testTranscript1.getCourseAndGrade(courseName2), courseName2 + ": 2.7");
    }
}
