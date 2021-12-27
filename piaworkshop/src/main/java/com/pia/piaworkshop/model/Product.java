package com.pia.piaworkshop.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	private UUID id;
	private String productName;
	private String code;
	private Double price;	
}
