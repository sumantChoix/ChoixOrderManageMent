package com.choix.DemandOrderManagement.ModelDto;


import com.choix.DemandOrderManagement.Entity.OrderItemModel;
import com.choix.DemandOrderManagement.Entity.OrdersModel;

import lombok.*;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderServiceDto
{
    public OrderItemModel order;
}
