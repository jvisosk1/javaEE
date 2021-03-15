package com.mycompany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Courses {
    @Id
    private String course_id;
    private String course_title;

    public String getCourseID () 
        {return course_id;}
    public void setCourseID (String course_id) 
        {this.course_id = course_id;}

    public String getCourseTitle () 
        {return course_title;}
    public void setCourseTitle (String course_title) 
        {this.course_title = course_title;}

}  