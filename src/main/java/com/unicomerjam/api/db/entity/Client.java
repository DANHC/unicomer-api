package com.unicomerjam.api.db.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data 
@Table
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "Firstname cannot be null")
	@NotBlank(message = "Firstname cannot be blank")
	private String firstName;
	@NotNull(message = "lastname cannot be null")
	@NotBlank(message = "lastname cannot be blank")
	private String lastName;
	@NotNull(message = "dob cannot be null")
	@Past 
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate birthday;
	@NotNull(message = "gender cannot be null")
	@NotBlank(message = "gender cannot be blank")
	private String gender;
	@NotNull(message = "cellphone cannot be null")
	@NotBlank(message = "cellphone cannot be blank")
	private String cellPhone;
	@NotNull(message = "homephone cannot be null")
	@NotBlank(message = "homephone cannot be blank")
	private String homePhone;
	@NotNull(message = "addresshome cannot be null")
	@NotBlank(message = "addresshome cannot be blank")
	private String addressHome;
	@NotNull(message = "profession cannot be null")
	@NotBlank(message = "profession cannot be blank")
	private String profession;
	@NotNull(message = "incomes cannot be null")
	@DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=9, fraction=2)
	private BigDecimal incomes;
}
