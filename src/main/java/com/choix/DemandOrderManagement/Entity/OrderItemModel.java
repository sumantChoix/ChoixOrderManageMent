package com.choix.DemandOrderManagement.Entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;


@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemModel 
{
	public long id;
	public String type;
	public String category;
	public String status;
	public Items[] items;
	public String timeSlot;
	public String createdAt;
	public String updatedAt;
	public String user_id;
	public String cust_lat;
	public String cust_long;

	

}
