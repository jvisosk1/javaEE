package com.mycompany;

import javax.persistence.*;

@Entity
public class Van extends Car {
 
 	private int numPass;
 
	public int getNumPassengers() {
		return numPass;
	}
 
	public void setNumPassengers(int numPass) {
		this.numPass = numPass;
	}
 
}