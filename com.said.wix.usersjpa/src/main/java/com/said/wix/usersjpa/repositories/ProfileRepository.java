package com.said.wix.usersjpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.said.wix.usersjpa.entities.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

}
