package com.abn.springboot.payload.request;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class RecipeRequest {

	public String typeOfDish;

	public Integer servedfor;

	public String ingredients;

	public String instructions;

}
