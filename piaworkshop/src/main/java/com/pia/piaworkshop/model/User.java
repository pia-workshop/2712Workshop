package com.pia.piaworkshop.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class User {
	@Id
	private UUID id;
	private String name;
	private String surname;
	private String username;
}
