package com.cg.frs.service;

import java.util.ArrayList;

import com.cg.frs.dto.FlatRegistrationDto;

public interface FlatRegistrationService {

	FlatRegistrationDto registerFlat(FlatRegistrationDto flat);
	ArrayList<Integer> getAllOwnerIds();
	
}
