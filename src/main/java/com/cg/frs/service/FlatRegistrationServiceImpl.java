package com.cg.frs.service;

import java.util.ArrayList;

import com.cg.frs.dao.FlatRegistrationDao;
import com.cg.frs.dao.FlatRegistrationDaoImpl;
import com.cg.frs.dto.FlatRegistrationDto;

public class FlatRegistrationServiceImpl implements FlatRegistrationService{

	
	FlatRegistrationDao flatRegistrationDao=new FlatRegistrationDaoImpl();
	public FlatRegistrationDto registerFlat(FlatRegistrationDto flat) {
	
		return flatRegistrationDao.registerFlat(flat);
	}

	public ArrayList<Integer> getAllOwnerIds() {
		
		return flatRegistrationDao.getAllOwnerIds();
	}
	
}
