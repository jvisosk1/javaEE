package com.mycompany;

import javax.persistence.*;

@Entity
public class Sedan extends Car {

	private int engine;
 
	public int getEngine() {
		return engine;
	}
 
	public void setEngine(int engine) {
		this.engine = engine;
	}
 
}