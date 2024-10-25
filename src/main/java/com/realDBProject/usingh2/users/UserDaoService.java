package com.realDBProject.usingh2.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;



@Component
public class UserDaoService {
	
	private int userCount = 0;
	
	private List<User> avaliableUsers = new ArrayList<User>();
	
	{
		avaliableUsers.add(new User(++userCount,"Raheel",LocalDate.now().minusYears(23)));
		avaliableUsers.add(new User(++userCount,"Bisham",LocalDate.now().minusYears(22)));
	}
	
	
	public List<User> getAllUser(){
		return this.avaliableUsers;
	}
	
	public User getSingleUser(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return avaliableUsers.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void saveUser(User user) {
		user.setId(++userCount);
		avaliableUsers.add(user);
	}
	
	public void deleteUser(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		avaliableUsers.removeIf(predicate);
	}
	

}
