package com.mycompany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int studId;
    private String name;

    public int getStudId () {
        return studId;
    }
    public void setStudId (int studId) {
        this.studId = studId;
    }
    public String getName () {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }

    @Override
	public String toString () {
          return "Student = " + "{studId: " + studId + ", name: " + name + "}";

	} 

}  