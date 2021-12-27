package com.pia.piaworkshop.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserDTO {
	@NotNull(message = "name is mandotory")
	private String name;
	@NotNull(message = "surname is mandotory")
	private String surname;
	@NotNull(message = "username is mandotory")
	@Length(min = 3, max = 255, message = "Your text length have to be min 3 and max 255!!!")
	private String username;
}
