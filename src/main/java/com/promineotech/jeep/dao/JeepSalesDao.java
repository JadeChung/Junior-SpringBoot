package com.promineotech.jeep.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

public interface JeepSalesDao {

/*
@Param model
@Param trim
@return
*/	
	List<Jeep> fetchJeeps(JeepModel model, String trim);
	
}
