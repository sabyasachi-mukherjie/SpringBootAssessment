package com.accenture.sabyasachi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accenture.sabyasachi.model.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{

}
