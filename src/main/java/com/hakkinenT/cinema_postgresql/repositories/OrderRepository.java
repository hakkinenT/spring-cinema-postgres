package com.hakkinenT.cinema_postgresql.repositories;

import com.hakkinenT.cinema_postgresql.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
