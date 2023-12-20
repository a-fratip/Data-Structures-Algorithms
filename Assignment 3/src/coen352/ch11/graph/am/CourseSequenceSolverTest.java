package coen352.ch11.graph.am;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CourseSequenceSolverTest {
    static CourseSequenceSolver G;

    @BeforeEach
    public void setUp()
    {
        G = new CourseSequenceSolver();
    }

    @Test
    public void testGetPrerequisite() throws Exception {
        G.initCourseGraph();
        String[] actual = G.getPrerequisite("ENGR290");
        String[] expected = new String[]{"ENGR213","ENGR233","ENCS282"};
        assertArrayEquals(expected,actual);
        assertNull(G.getPrerequisite("ENGR201"));
    }

    @Test
    public void testGetCourseSequence() throws Exception {
        G.initCourseGraph();
		String[] actual = G.getCourseSequence("COEN244");
        String[] expected = new String[]{"MATH204","COEN243"};
        for (String s : actual) {
            System.out.print(s + ", ");
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void testIsPrerequisite() throws Exception {
        G.initCourseGraph();
        assertTrue(G.isPrerequisite("COEN243","COEN390"));
        assertFalse(G.isPrerequisite("ELEC273","COEN390"));
    }

    @Test
    public void testGetCourseSequenceBool() throws Exception {
        G.initCourseGraph();
        String[] validCourseSequence = G.getCourseSequence("COEN320");
        // Print valid course sequence
        for (String s : validCourseSequence) {
            System.out.print(s + ", ");
        }

        // Remove COEN244 from prerequisite path of COEN320
        String[] invalidCourseSequence1 = new String[]{"MATH204", "COEN212", "COEN243", "COEN311", "COEN231", "COEN352", "COEN346" };
        // Try to take COEN352 before COEN244
        String[] invalidCourseSequence2 = new String[]{"MATH204", "COEN212", "COEN243", "COEN311", "COEN231", "COEN352", "COEN244", "COEN346" };

        assertTrue(G.getCourseSequence(validCourseSequence));
        assertFalse(G.getCourseSequence(invalidCourseSequence1));
        assertFalse(G.getCourseSequence(invalidCourseSequence2));

    }

}
