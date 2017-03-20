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

import java.text.DecimalFormat;


public class Student implements Comparable{
    private String name;
    private String status;
    private int grade1;
    private int grade2;
    private int grade3;
    private double average;
      //Constructors
    public Student(String name, int grade1, int grade2, int grade3){
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }
    public Student(){   //Default Constructor
        name = "";
        status = "";
        grade1 = 0;
        grade2 = 0;
        grade3 = 0;
        average = 0;
    }
    public boolean compareTo(Student a){
        if(this.average < a.getAverage())
            return true;
        else
            return false;
    }

    public void computeAverage(){
        average = (grade1+grade2+grade3)/3.0;
    }
    public void computeStatus(){
        if(average >=70)
            status = "Passing";
        else
            status = "Failing";
    }
        //Mutator Methods
    public void setGrade1(int grade1){
        this.grade1 = grade1;
    }
    public void setGrade2(int grade2){
        this.grade2 = grade2;
    }
    public void setGrade3(int grade3){
        this.grade3 = grade3;
    }
    public void setName(String name){
        this.name = name;
    }
        //Accessor Methods
    public int getGrade1(){
        return grade1;
    }
    public int getGrade2(){
        return grade2;
    }
    public int getGrade3(){
        return grade3;
    }
    public String getName(){
        return name;
    }
    public double getAverage(){
        computeAverage();
        return average;
    }
    public String getStatus(){
        computeStatus();
        return status;
    }
    @Override
    public String toString(){
        DecimalFormat f = new DecimalFormat("###.##");  
        f.setMinimumFractionDigits(2);
        
        return(name+"\t"+f.format(grade1)+"\t"+f.format(grade2)+"\t"+f.format(grade3)+
                "\t"+f.format(getAverage())+"\t"+getStatus());
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
