package com.said.wix.usersjpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.said.wix.usersjpa.entities.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
