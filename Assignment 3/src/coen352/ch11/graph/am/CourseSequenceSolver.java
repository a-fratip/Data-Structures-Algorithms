package coen352.ch11.graph.am;

import coen352.ch4.queue.ADTQueue;
import coen352.ch4.queue.AQueue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static coen352.ch11.graph.am.GraphTest.createGraph;

import java.io.*;
import java.util.*;

public class CourseSequenceSolver {

    private static Graph courses; // graph of all the courses
    private  String[] courseCodes; // array to store course codes of all courses in the graph

    static final int UNVISITED = 0;
    static final int VISITED = 1;

    // constructors
    public CourseSequenceSolver() {
        courses = new Graphm(); // adjacency matrix representation
//        courseCodes = new String[100];
    }
    public CourseSequenceSolver(int n) {
        courses = new Graphm(n);
        courseCodes = new String[n];
    }

    // Initialize the graph based on the file core_course.gph
    public void initCourseGraph() throws IOException {
        BufferedReader f;
        f = new BufferedReader(new InputStreamReader(new FileInputStream("core_course.gph")));
        createGraph(f, courses);

        // initialize string array of course codes with corresponding vertex index
        courseCodes = new String[courses.n()];
        courseCodes[0] = "MATH204";
        courseCodes[1] = "COEN212";
        courseCodes[2] = "COEN231";
        courseCodes[3] = "COEN243";
        courseCodes[4] = "COEN244";
        courseCodes[5] = "COEN311";
        courseCodes[6] = "COEN313";
        courseCodes[7] = "ELEC273";
        courseCodes[8] = "COEN314";
        courseCodes[9] = "COEN316";
        courseCodes[10] = "COEN317";
        courseCodes[11] = "COEN346";
        courseCodes[12] = "COEN320";
        courseCodes[13] = "COEN352";
        courseCodes[14] = "COEN366";
        courseCodes[15] = "ELEC242";
        courseCodes[16] = "ENGR213";
        courseCodes[17] = "ELEC342";
        courseCodes[18] = "ELEC372";
        courseCodes[19] = "SOEN341";
        courseCodes[20] = "ENGR290";
        courseCodes[21] = "ENGR233";
        courseCodes[22] = "ENCS282";
        courseCodes[23] = "COEN390";
        courseCodes[24] = "ENGR301";
        courseCodes[25] = "COEN490";
        courseCodes[26] = "ENGR371";
        courseCodes[27] = "PHYS205";
        courseCodes[28] = "MATH205";
        courseCodes[29] = "ENGR391";
        courseCodes[30] = "ENGR392";
        courseCodes[31] = "ENGR201";
        courseCodes[32] = "ENGR202";
    }

    // Returns the direct prerequisites given a specific course code
    public String[] getPrerequisite(String CourseCode) throws Exception {
        int v = getNodeIndex(CourseCode);
        Integer[] fanInNodes = courses.getFanIn(v); // get fan in nodes of v

        if (fanInNodes != null) {
            // get course code of each fan in node and add to string array
            String[] prereq = new String[fanInNodes.length];
            for (int i = 0; i < fanInNodes.length; i++) {
                prereq[i] = courseCodes[fanInNodes[i]];
            }
            return prereq;
        }

        return null; // no prerequisites
    }

    // Returns the course sequence of a given course (prerequisite path)
    public String[] getCourseSequence(String courseCode) throws Exception {
        int startIndex = getNodeIndex(courseCode);
        ADTQueue<String> sequenceQueue = new AQueue<>(courses.n()); // use a queue to keep track of prerequisites
        this.clearMarks(); // clear mark array

        // Perform DFS traversal starting from the specified course
        dfs(startIndex, sequenceQueue);

        // Convert the sequenceQueue to an array and leave the given course on the queue
        String[] sequenceArray = new String[sequenceQueue.length()-1];
        int i = 0;
        while (sequenceQueue.length() != 1) {
            sequenceArray[i] = sequenceQueue.dequeue();
            i++;
        }
        return sequenceArray;
    }

    // Checks if a source course is a prerequisite of the destination course
    public boolean isPrerequisite(String sourceCourse, String destinationCourse) throws Exception {
        // get the prerequisite path of the destination course
        String[] prereq = this.getCourseSequence(destinationCourse);

        // check if the source course is on the prerequisite path
        for (String course : prereq) {
            if (course.equals(sourceCourse)) return true;
        }
        return false;
    }

    public boolean getCourseSequence(String[] courseSequence) throws Exception {
        Set<String> visitedCourses = new HashSet<>(); // use a hash set to keep track of visited courses with efficient look-up time

        // Verify if the sequence respects the prerequisite order
        for (String course : courseSequence) {
            // check if every course in the given course sequence is valid
            if(!isCourseValid(course, visitedCourses)) {
                return false;
            }
            visitedCourses.add(course); // course is valid but has not been visited yet
        }

        return true;
    }

    // Helper function to check if a course is valid
    // A course is valid if all its prerequisites have been visited
    private boolean isCourseValid(String course, Set<String> visitedCourses) throws Exception {
        if (visitedCourses.contains(course)) {
            return true; // course has already been visited
        }

        // get direct prerequisites of current course
        String[] prerequisites = getPrerequisite(course);

        if (prerequisites == null) {
            return true; // course has no prerequisites
        }

        // Check if all prerequisites are visited before the current course
        for (String prereq : prerequisites) {
            if (!visitedCourses.contains(prereq)) {
                return false;
            }
        }

        return true;
    }

    // dfs helper function
    private void dfs(int v, ADTQueue<String> sequenceQueue) {
        courses.setMark(v,VISITED); // mark v as visited

        // Get prerequisites of the current course
        Integer[] prerequisites = courses.getFanIn(v);

        // Visit all prerequisites if not visited
        if (prerequisites != null) {
            for (int prereq : prerequisites) {
                if (courses.getMark(prereq) == 0) {
                    dfs(prereq, sequenceQueue);
                }
            }
        }

        // Add the current course to the sequence after visiting prerequisites
        sequenceQueue.enqueue(courseCodes[v]);
    }

    // Function to get the index of a vertex from its course code
    public static int getNodeIndex(String CourseCode) throws Exception {
        // convert course codes to encoded node index
        int index;
        switch (CourseCode)
        {
            case "MATH204":
                index = 0;
                break;

            case "COEN212":
                index = 1;
                break;

            case "COEN231":
                index = 2;
                break;

            case "COEN243":
                index = 3;
                break;

            case "COEN244":
                index = 4;
                break;

            case "COEN311":
                index = 5;
                break;

            case "COEN313":
                index = 6;
                break;

            case "ELEC273":
                index = 7;
                break;

            case "COEN314":
                index = 8;
                break;

            case "COEN316":
                index = 9;
                break;

            case "COEN317":
                index = 10;
                break;

            case "COEN346":
                index = 11;
                break;

            case "COEN320":
                index = 12;
                break;

            case "COEN352":
                index = 13;
                break;

            case "COEN366":
                index = 14;
                break;

            case "ELEC242":
                index = 15;
                break;

            case "ENGR213":
                index = 16;
                break;

            case "ELEC342":
                index = 17;
                break;

            case "ELEC372":
                index = 18;
                break;

            case "SOEN341":
                index = 19;
                break;

            case "ENGR290":
                index = 20;
                break;

            case "ENGR233":
                index = 21;
                break;

            case "ENCS282":
                index = 22;
                break;

            case "COEN390":
                index = 23;
                break;

            case "ENGR301":
                index = 24;
                break;

            case "COEN490":
                index = 25;
                break;

            case "ENGR371":
                index = 26;
                break;

            case "PHYS205":
                index = 27;
                break;

            case "MATH205":
                index = 28;
                break;

            case "ENGR391":
                index = 29;
                break;

            case "ENGR392":
                index = 30;
                break;

            case "ENGR201":
                index = 31;
                break;

            case "ENGR202":
                index = 32;
                break;

            default:
                throw new Exception(CourseCode + " is not a valid course");
        }
        return index;
    }

    // Function to clear mark array
    public void clearMarks() {
        // mark all vertices as unvisited
        for (int i = 0; i < courses.n(); i++) {
            courses.setMark(i,UNVISITED);
        }
    }


}
