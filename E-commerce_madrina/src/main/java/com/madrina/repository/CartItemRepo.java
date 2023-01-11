package com.madrina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madrina.model.CartItem;


@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer>{

}
