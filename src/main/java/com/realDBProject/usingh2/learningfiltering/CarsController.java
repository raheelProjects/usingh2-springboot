package com.realDBProject.usingh2.learningfiltering;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class CarsController {
	
private List<Cars> allCars = new ArrayList<Cars>();
	
	{allCars.add(new Cars(1,"Porshe",LocalDate.now().minusYears(10),"red",true));
	allCars.add(new Cars(2,"Bugati",LocalDate.now().minusYears(5),"blue",true));
	allCars.add(new Cars(3,"BMW",LocalDate.now(),"white",false));}
	
	
	public MappingJacksonValue filteringOutMultiple(List<Cars> cars,List<String> properties) {
		MappingJacksonValue result = new MappingJacksonValue(cars);
		SimpleBeanPropertyFilter filtere = SimpleBeanPropertyFilter.filterOutAllExcept(properties.toArray(new String[0]));
		FilterProvider filter = new SimpleFilterProvider().addFilter("car filter", filtere );
		result.setFilters(filter );
		return result;
	}


	public MappingJacksonValue reusableCode(List<String> filters) {
		List<Cars> cars = this.allCars;
		MappingJacksonValue result = filteringOutMultiple(cars, filters );
		return result;
	}

	@GetMapping(path="/cars/all")
	public MappingJacksonValue getAllCars(){
		
		return reusableCode(Arrays.asList( "name","yearOfProduction","color"));
	}
	
	
	



	@GetMapping(path="/cars/names")
	public MappingJacksonValue getAllCarsNames(){
		return reusableCode(Arrays.asList( "name"));
	}

}
