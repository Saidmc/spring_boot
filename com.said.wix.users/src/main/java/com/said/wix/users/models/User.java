package com.said.wix.users.models;

//Aquí no hay mucho que explicar, una clase con tres atributos y sus respectivos getters y setters, y sus constructores
public class User {
	private String nickname;
	private String username;
	private String password;
	
	public User() {
		
	}
	
	public User(String nickname, String username, String password) {
		this.nickname = nickname;
		this.username = username;
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
