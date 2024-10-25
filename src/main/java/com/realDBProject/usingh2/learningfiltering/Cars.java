package com.realDBProject.usingh2.learningfiltering;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFilter;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//static filtering
//@JsonIgnoreProperties({"id","launched"})

//dynamic filtering
@JsonFilter("car filter")
public class Cars {

	private Integer id;
	private String name;
	private LocalDate yearOfProduction;
	private String color;
	private Boolean launched;
	
	public Cars(Integer id,String name, LocalDate yearOfProduction, String color, Boolean launched) {
		this.id = id;
		this.name = name;
		this.yearOfProduction = yearOfProduction;
		this.color = color;
		this.launched = launched;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(LocalDate yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getLaunched() {
		return launched;
	}

	public void setLaunched(Boolean launched) {
		this.launched = launched;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
