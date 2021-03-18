package com.mycompany;

import javax.persistence.*;

@Entity
@AttributeOverrides({
	@AttributeOverride(
		name="name",column=@Column(name="SUV_NAME"))})
public class Suv extends Car{

	private int numDoors;

	public int getNoOfDoors()
		{return numDoors;}

	public void setNoOfDoors(int numDoors)
		{this.numDoors = numDoors;}

}



