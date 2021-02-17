package com.choix.DemandOrderManagement.controller;

import java.util.List;

import com.choix.DemandOrderManagement.Entity.OrderItemModel;

import com.choix.DemandOrderManagement.ModelDto.OrderServiceDto;

import com.choix.DemandOrderManagement.Services.OrderModelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class OrderMangeMentController 
{
	@Autowired
	public OrderModelService orderModelService;
	
	@PostMapping("/")
	public String CretaUser(@RequestBody OrderServiceDto models) {
		
	   orderModelService.CreateOrder(models);
	    
        return "save sucessfully";
	}
	


    @GetMapping("/")
	public List<OrderItemModel> findAllOrder() throws JsonProcessingException {
		return orderModelService.findAllOrders();
	}


	@GetMapping("/{id}")
	public OrderItemModel findByIdModel(@PathVariable("id") long id) throws JsonProcessingException {
		return  orderModelService.findByIdOrder(id);
	}

	@PutMapping("/{id}")
	public String UpdateOrder(@PathVariable("id") long id , @RequestBody  OrderServiceDto orderServiceDto){
		orderModelService.updateOrder(id,orderServiceDto);
		return "update sucessfully";
	}
}
