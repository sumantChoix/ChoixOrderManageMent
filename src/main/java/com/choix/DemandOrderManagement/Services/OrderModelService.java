package com.choix.DemandOrderManagement.Services;

import com.choix.DemandOrderManagement.Entity.Items;
import com.choix.DemandOrderManagement.Entity.OrderItemModel;
import com.choix.DemandOrderManagement.Entity.OrdersModel;
import com.choix.DemandOrderManagement.ModelDto.OrderServiceDto;
import com.choix.DemandOrderManagement.Repo.ModelRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderModelService
{
    @Autowired
    public ModelRepo modelRepo;

    public void CreateOrder(OrderServiceDto models)
    {
        OrdersModel ordersModel=new OrdersModel();
        List<Items> list = new ArrayList<>();
        for (Items i : models.getOrder().getItems()) {
            list.add(i);
        }
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        OrdersModel orderModels= new OrdersModel();
        orderModels.setCategory(models.getOrder().getCategory());
        orderModels.setCreatedAt(models.getOrder().getCreatedAt());
        orderModels.setCust_lat(models.getOrder().getCust_lat());
        orderModels.setItems(json);
        orderModels.setStatus(models.getOrder().getStatus());
        orderModels.setTimeSlot(models.getOrder().getTimeSlot());
        orderModels.setUpdatedAt(models.getOrder().getUpdatedAt());
        orderModels.setType(models.getOrder().getType());
        orderModels.setCust_long(models.getOrder().getCust_long());
        orderModels.setUser_id(models.getOrder().getUser_id());
        modelRepo.save(orderModels);
    }


    public List<OrderItemModel> findAllOrders() throws JsonProcessingException {
        List<OrdersModel> model= modelRepo.findAll();
        List<OrderItemModel> modelsList = new ArrayList<OrderItemModel>();
        String text = null ;
        for(OrdersModel model1:model) {
            OrderItemModel orderModels = new OrderItemModel();
            text = model1.getItems();
            final ObjectMapper objectMapper = new ObjectMapper();
            Items[] langs = objectMapper.readValue(text, Items[].class);
            orderModels.setId(model1.getId());
            orderModels.setCategory(model1.getCategory());
            orderModels.setCreatedAt(model1.getCreatedAt());
            orderModels.setTimeSlot(model1.getTimeSlot());
            orderModels.setCust_lat(model1.getCust_lat());
            orderModels.setStatus(model1.getStatus());
            orderModels.setItems(langs);
            orderModels.setUpdatedAt(model1.getUpdatedAt());
            orderModels.setType(model1.getType());
            orderModels.setCust_long(model1.getCust_long());
            orderModels.setUser_id(model1.getUser_id());
            modelsList.add(orderModels);
        }
		return  modelsList;
    }


    public OrderItemModel findByIdOrder(long id) throws JsonProcessingException {
        OrdersModel model1=modelRepo.findById(id).orElse(null);
        String text = null ;
        OrderItemModel orderModels = new OrderItemModel();
        text = model1.getItems();
        final ObjectMapper objectMapper = new ObjectMapper();
        Items[] langs = objectMapper.readValue(text, Items[].class);
        orderModels.setId(model1.getId());
        orderModels.setCategory(model1.getCategory());
        orderModels.setCreatedAt(model1.getCreatedAt());
        orderModels.setTimeSlot(model1.getTimeSlot());
        orderModels.setItems(langs);
        orderModels.setCust_lat(model1.getCust_lat());
        orderModels.setStatus(model1.getStatus());
        orderModels.setUpdatedAt(model1.getUpdatedAt());
        orderModels.setType(model1.getType());
        orderModels.setCust_long(model1.getCust_long());
        orderModels.setUser_id(model1.getUser_id());
        return orderModels;
    }

    public void updateOrder(long id , OrderServiceDto models){
        OrdersModel orderModels = modelRepo.findById(id).orElse(null);
        List<Items> list = new ArrayList<>();
        for (Items i : models.getOrder().getItems()) {
            list.add(i);
        }
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        orderModels.setCategory(models.getOrder().getCategory());
        orderModels.setCreatedAt(models.getOrder().getCreatedAt());
        orderModels.setCust_lat(models.getOrder().getCust_lat());
        orderModels.setItems(json);
        orderModels.setStatus(models.getOrder().getStatus());
        orderModels.setTimeSlot(models.getOrder().getTimeSlot());
        orderModels.setUpdatedAt(models.getOrder().getUpdatedAt());
        orderModels.setType(models.getOrder().getType());
        orderModels.setCust_long(models.getOrder().getCust_long());
        orderModels.setUser_id(models.getOrder().getUser_id());
        modelRepo.save(orderModels);
    }


}
