/*----------------------------------------------
    Group Members: Victor, Maurice, Alex

    Student IDs:   1001975600 , 1001200101 , 1001121385 

    COP2805C - Java Programing 2

    Spring Mini-Term - T Th 6:15PM - 9:30PM

    Project #1

    plagiarism StatementL I certify that this assignment is my own work and that I have not copied in
    part or whole or otherwise plagiarized the work of other students and/or persons.
--------------------------------------------------*/

package teststudent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TestStudent {

    public static void main(String[] args) throws IOException {
        StudentList studentList = new StudentList();
        
        studentList.readStudents();
        studentList.writeStudents();
        studentList.sortStudents();
        studentList.writeStudents();
    }
    
}
