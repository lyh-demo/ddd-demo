package org.example.ddd.infrastructure.repository;

import org.example.ddd.domain.model.Order;
import org.example.ddd.domain.model.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderRepository extends JpaRepository<Order, Long>, OrderRepository {
}
