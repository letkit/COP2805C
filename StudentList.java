package teststudent;
/*----------------------------------------------
    Group Members: Victor, Maurice, Alex

    Student IDs:   1001975600 , 1001200101 , 1001121385 

    COP2805C - Java Programing 2

    Spring Mini-Term - T Th 6:15PM - 9:30PM

    Project #1

    plagiarism StatementL I certify that this assignment is my own work and that I have not copied in
    part or whole or otherwise plagiarized the work of other students and/or persons.
--------------------------------------------------*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentList {
    private String inputFromFile;       //Variable to hold input
    private final int numOfParts = 4;   //Number of parts per Student Object
    private String[] parts;             //String array to hold separated parts
    List<Student> students;             //List of Student Objects
    
    public StudentList(){   //Default Constructor
        parts = new String[numOfParts];
        students = new ArrayList<Student>();
        parts[0] = parts[1] = parts[2] = parts[3] = ""; 
    }
    public void readStudents() throws IOException{  //Needs JFileChooser Implementation
        
        inputFromFile = readFile();
        
        
        String[] lines = new String[getSize()]; //Create String array to separate lines from input
        
        lines = inputFromFile.split("\n");  //Split lines into array
        
        for(int i = 0; i < getSize(); i++){ //Run function over every line
            parts[0] = parts[1] = parts[2] = parts[3] = ""; //Empty parts array
            int index = 0;  //Reset index
            
            for(int u = 0; u < lines[i].length(); u++){ //Demostration of .split() methodology
                if(lines[i].charAt(u) == '|')   //Separating each line into 4 usuable variables
                    index++;    //If delimiter is found, move index to next part
                else
                    parts[index] += lines[i].charAt(u); //Else add characters to String array
            }
            Student s = new Student(parts[0], Integer.parseInt(parts[1]),   //Assign variables using Student constructor
                 Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
            
            students.add(s);    //Add student object to List
        }
    }
    public void sortStudents(){ //BubbleSort method
        boolean flag = true;
        while(flag){
            flag = false;
            for(int u = 0; u < students.size()-1; u++){
                if(students.get(u).compareTo(students.get(u+1))){
                    Collections.swap(students, u, u+1);
                    flag = true;
                }
            }
        }
    }    
    public void writeStudents(){    //Simple display method
        System.out.println("Name\tGrade1\tGrade 2\tGrade 3\tAverage\tStatus");
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).toString()); //Applying own toString method
        }
    }
     private int getSize(){  //Method for determining number of lines in input file
        int length = 1;
        for(int i = 0; i < inputFromFile.length(); i++){
            if(inputFromFile.charAt(i) == '\n')
                length++;
        }
        return length;
    }
    private String readFile() throws IOException{   //Method returns String from local txt file
        Scanner in  = null;     
        String str = "";    
        String fileName = "";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter file name: [text.txt]");
        fileName = keyboard.next();
        
        try{
            in = new Scanner(new File(fileName));
        
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        while(in.hasNext()){    //While they are tokens left, append them to String
            str += in.next();
            if(in.hasNext())    //Adding new lines on all line except last
                str+="\n";
        }
        return str; //Return file as String
    }
}
