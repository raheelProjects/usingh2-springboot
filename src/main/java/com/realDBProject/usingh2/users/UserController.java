package com.realDBProject.usingh2.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.realDBProject.usingh2.post.Post;
import com.realDBProject.usingh2.post.PostJpaRepo;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
//	private UserDaoService userDaoService;
	private UserJpaRepo ujp;
	private PostJpaRepo pjr;

	@Autowired
	public UserController(PostJpaRepo pjr,UserJpaRepo ujp) {
//		this.userDaoService = userDaoService;
		this.ujp = ujp;
		this.pjr=pjr;
	}
	
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		return ujp.findAll();
//		return this.userDaoService.getAllUser();	
	}
	
	@GetMapping(path="/users/{id}")
	public User getUser(@PathVariable int id) {
//		User response = this.userDaoService.getSingleUser(id);
//		if(response ==null) {
//			throw new UserNotFoundException(String.format("No user with id = %s is found", id));
//		}
		Optional<User> result=ujp.findById(id);
		if(result.isEmpty()) {
			throw new UserNotFoundException(String.format("No user with id = %s is found", id));
		}
		return result.get();
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
//		this.userDaoService.saveUser(user);
		ujp.save(user);
		return ResponseEntity.created(null).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
//		 this.userDaoService.deleteUser(id);
		ujp.deleteById(id);
		
	}
	
	@DeleteMapping(path="/users")
	public void deleteAllUser(@RequestBody List<Integer> ids) {
//		 this.userDaoService.deleteUser(id);
//		ujp.deleteById(id);
		ujp.deleteAllById(ids);
		
	}
	
	@GetMapping(path="/users/{id}/post")
	public List<Post> getAllPost(@PathVariable int id) {
		
		Optional<User> result= ujp.findById(id);
		if(result.isEmpty()) {
			throw new UserNotFoundException(String.format("No user with id = %s is found", id));
		}
		
		return result.get().getPosts();
	}
	
	@PostMapping(path="/users/{id}/post")
	public ResponseEntity<Post> addPost(@PathVariable int id,@RequestBody Post post) {
		
		Optional<User> result= ujp.findById(id);
		if(result.isEmpty()) {
			throw new UserNotFoundException(String.format("No user with id = %s is found", id));
		}
		
		post.setUser(result.get());
		pjr.save(post);
		
		return ResponseEntity.created(null).build();
	}
	

}
