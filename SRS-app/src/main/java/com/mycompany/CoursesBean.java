package com.mycompany;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ApplicationScoped;

import com.mycompany.TestBean;

@SuppressWarnings("unused")
@ManagedBean
@SessionScoped

public class CoursesBean implements Serializable{

    public String courseTitle;
    public int course_capacity = 4;
    
    public String getcourseTitle() {
        return courseTitle;
    }
    public void setcourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    public String enrollCourse() {

    	TestBean testobj = new TestBean();
		DBConnection db = new DBConnection();
		int students_enrolled = db.increaseEnrolledNum(course_capacity, this.courseTitle.substring(0,7));
		String course_id = "";
		
		if(students_enrolled == -1) {
			return("Sorry, registration to this course {" + this.courseTitle + "} has been closed based on " +
					"availability. " + course_capacity + " out of " + course_capacity + " class seats filled.");
		}
    	
    	return("You are registered to the following course: {" + this.courseTitle + "}.\n" +
    			students_enrolled + " out of " + course_capacity + " class seats filled.");
    }

    private static Map<String, Object> courseTitleValue;
    static
    {
    	// EXECUTE DB INSERT QUERY AND RENDER LOGIN PAGE
    	TestBean testobj = new TestBean();
		DBConnection db = new DBConnection();
		ResultSet res = db.getCourses();  
		@SuppressWarnings("unused")
		Boolean loginVerified = false;
		String course_id, course_title;
		
		String[] courses = new String[8];
		int i=0;
	   	try {
			while(res.next()) { 
				course_id = res.getString(1);
				course_title = res.getString(2);
				courses[i] = course_id + " " + course_title;
				@SuppressWarnings("unused")
				String jeff = null;
				i++;
			}
		} catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
    	   	   	
        courseTitleValue = new LinkedHashMap<String, Object>();
        
        for(int j=0; j < i; j++) {
        	courseTitleValue.put(courses[j], courses[j]);
        }
    }
    
    public Map<String, Object> getcourseTitleValue()
    {
        return courseTitleValue;
    }
    
    public static class Course
    {
        public String courseLabel;
        public String courseValue;
        
        public Course(String courseLabel, String courseValue)
        {
            this.courseLabel = courseLabel;
            this.courseValue = courseValue;
        }
        
        public String getCourseLabel()
        {
            return courseLabel;
        }
        
        public String getCourseValue()
        {
            return courseValue;
        }
    }    

}