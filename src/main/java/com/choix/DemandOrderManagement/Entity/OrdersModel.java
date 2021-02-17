package com.choix.DemandOrderManagement.Entity;

import lombok.*;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrdersModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	public String type;
	public String category;
	public String status;
	public String items;
	public String timeSlot;
	public String createdAt;
	public String updatedAt;
	public String user_id;
	public String cust_lat;
	public String cust_long;

		

}
