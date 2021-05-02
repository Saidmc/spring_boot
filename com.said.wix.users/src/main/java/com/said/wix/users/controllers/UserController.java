package com.said.wix.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.said.wix.users.models.User;
import com.said.wix.users.services.UserService;

//Permite registrar la clase en el contexto de Spring y devolver el ResponseHttp por medio del objeto "retuirn"
@RestController
//Permite asociar un recurso ("/users") con un método
@RequestMapping("/users")
public class UserController {
	
	//Inyectamos un objeto tipo "UserService" en el atributo (objeto) "userservice"
	@Autowired
	private UserService userservice;
	
	//Asocia la solicitud de un recurso y el metodo Http GET con un método Java y permite definir una respuesta de tipo <List<User>> para devolver el ResponseHttp
	@GetMapping
	//Método HHTP (Get) + Un recurso ("/users") = Handler Method, getUsers es un Handler Method
	//Con @RequestParam se obtiene un valor de alguno de los parametros de la URL
	//aquí srtatWith es un Query param, estos queryParam sirven para os casos en los que se requiere una búsqueda o fitrar el resultado
	public ResponseEntity<List<User>> getUsers(@RequestParam(required = false, value="startWith") String startWith) {
		return new ResponseEntity<>(userservice.getUsers(startWith), HttpStatus.OK);
	}
	
	//Un caso similar al anterior, pero ahora asociamos el metodo Http GET y el recurso ("/users/{username}") con el método Java "getUserByUsername"
	@GetMapping("/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
		return new ResponseEntity<User>(userservice.getUserByUsername(username), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userservice.createUser(user), HttpStatus.CREATED);
	}
	
	@PatchMapping("/{username}")
	public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User user) {
		return new ResponseEntity<User>(userservice.updateUser(username, user), HttpStatus.OK);
	}
	
	@DeleteMapping("/{username}")
	public ResponseEntity<Void> removeUser(@PathVariable("username") String username) {
		userservice.removeUser(username);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		//return ResponseEntity.ok(HttpStatus.NO_CONTENT);
		//return new ResponseEntity<>(userservice.removeUser(username), HttpStatus.NO_CONTENT);
	}
}
