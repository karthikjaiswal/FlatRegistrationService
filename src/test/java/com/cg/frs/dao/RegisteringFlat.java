package com.cg.frs.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.frs.dto.FlatRegistrationDto;

class RegisteringFlat {

	static FlatRegistrationDaoImpl flatdao;
	static FlatRegistrationDto flat;
	
	@BeforeAll
	public static void init()
	{
		flatdao=new FlatRegistrationDaoImpl();
		flat=new FlatRegistrationDto();
	}
	@Test
	void testRegisterFlat() {
		
			flat.setOwner_id(1);
			flat.setFlat_type(2);
			flat.setFlat_area(10);
			flat.setRent_amount(2000);
			flat.setDeposit_amount(10000);
			flat=flatdao.registerFlat(flat);
			assertEquals(1011, flat.getFlat_reg_no());
	}
	@Test 
	void testGetAllOwnerIds()
	{
		ArrayList<Integer> owners=new ArrayList<>();
		owners.add(1);
		owners.add(2);
		owners.add(3);
		assertEquals(owners, flatdao.getAllOwnerIds());
	}

}
