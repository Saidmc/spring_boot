package com.said.wix.users.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.github.javafaker.Faker;
import com.said.wix.users.models.User;

//Permite registrar la clase en el contexto de Spring
@Service
public class UserService {
	
	//Inyectamos un objeto tipo "Faker" en el atributo (objeto) "faker"
	@Autowired
	private Faker faker;
	
	private List<User> users = new ArrayList<>();
	
	//En otra entrega te explicaré esta anotación a detalle, por ahora basta saber que Spring ejecutará automáticamente esté método "init" solo hasta que el bean se haya inicializado
	@PostConstruct
	//Método para inicializar la lista de cuentas
	public void init() {
		for (int i=0; i<100; i++) {
			users.add(new User(faker.funnyName().name(), faker.dragonBall().character(), faker.dragonBall().character()));
		}
	}
	
	//Este método permitirá devolver la lista de cuentas
	public List<User> getUsers() {
		return this.users;
	}
	
	//Este método permitirá devolver la primera cuenta que coincida su nombre de usuario con el parámetro "username"
	public User getUserByUsername(String username) {
		return users.stream().filter(u -> u.getUsername().equals(username)).findAny()
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("User %s not found.", username)));
	}
	
	public User createUser(User user) {
		if ( users.stream().anyMatch(u -> u.getUsername().equals(user.getUsername())) ) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("User $s already exists.", user.getUsername()));
		}
		
		users.add(user);
		return user;
	}
	
	public User updateUser(String username, User newDataUser) {
		User foundedUser = getUserByUsername(username);
		foundedUser.setNickname(newDataUser.getNickname());
		foundedUser.setPassword(newDataUser.getPassword());
		
		return foundedUser;
	}
	
	public User removeUser(String username) {
		User foundedUser = getUserByUsername(username);
		users.remove(foundedUser);
		
		return foundedUser;
	}
}
