package com.madrina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madrina.model.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
