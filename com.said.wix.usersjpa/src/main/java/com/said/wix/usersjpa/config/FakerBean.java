package com.said.wix.usersjpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

//Permite registrar la clase de tipo configuración en el contexto de Spring 
@Configuration
public class FakerBean {

	//Faker no se puede definir como un estereotipo por ser una clase externa, se debe definir como bean explicitamente. Ahora se peude inyectar un bean Fake en cualquier lugar, pues se ha definido la salida de este método como un bean de tipo Faker.
	@Bean
	public Faker getFaker() {
		return new Faker();
	}
}
