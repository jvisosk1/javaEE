package com.mycompany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Registrar {
    @Id
    private String course_id;
    private int num_registered;

    public String getCourseID () 
        {return course_id;}
    public void setCourseID (String course_id) 
        {this.course_id = course_id;}

    public int getNumberRegistered () 
        {return num_registered;}
    public void addStudentRegistered () 
        {this.num_registered++;}
        
}
