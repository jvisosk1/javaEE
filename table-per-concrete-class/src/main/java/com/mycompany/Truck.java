package com.mycompany;

import javax.persistence.*;

@Entity
@AttributeOverrides({
	@AttributeOverride(
		name="name",column=@Column(name="TRUCK_NAME"))})
public class Truck extends Car{

	private int cargo;

	public int getCargo()
		{return cargo;}
	
	public void setCargo(int cargo)
		{this.cargo = cargo;}
}



