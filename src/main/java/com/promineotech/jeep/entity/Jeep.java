package com.promineotech.jeep.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
	public class Jeep {
	
	  @SuppressWarnings("unused")
	private Long modelPK;
	  @SuppressWarnings("unused")
	private JeepModel modelId;
	  @SuppressWarnings("unused")
	private String trimLevel;
	  @SuppressWarnings("unused")
	private int numDoors;
	  @SuppressWarnings("unused")
	private int wheelSize;
	  @SuppressWarnings("unused")
	private BigDecimal basePrice;
	}


