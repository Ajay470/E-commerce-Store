package com.madrina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madrina.model.Order;


@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{

}
