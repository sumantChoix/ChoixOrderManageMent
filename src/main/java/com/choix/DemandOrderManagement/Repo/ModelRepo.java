package com.choix.DemandOrderManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choix.DemandOrderManagement.Entity.OrderItemModel;
import com.choix.DemandOrderManagement.Entity.OrdersModel;

public interface ModelRepo extends JpaRepository<OrdersModel, Long>
{

}
