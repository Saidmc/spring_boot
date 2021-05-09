package com.said.wix.usersjpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.said.wix.usersjpa.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
