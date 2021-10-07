package com.abn.springboot.model;

import javax.persistence.*;


import lombok.*;

import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "recipe")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "dateTime")
	public String dateTime;

	@Column(name = "typeOfDish")
	public String typeOfDish;

	@Column(name = "servedfor")
	public Integer servedfor;

	@Column(name = "ingredients")
	public String ingredients;

	@Column(name = "instructions")
	public String instructions;

}
