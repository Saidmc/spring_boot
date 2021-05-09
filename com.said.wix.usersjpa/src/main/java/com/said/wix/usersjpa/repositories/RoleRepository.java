package com.said.wix.usersjpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.said.wix.usersjpa.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
