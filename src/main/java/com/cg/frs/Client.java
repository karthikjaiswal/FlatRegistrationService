package com.cg.frs;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.frs.dto.FlatRegistrationDto;
import com.cg.frs.exceptions.InvalidFlatTypeException;
import com.cg.frs.exceptions.InvalidOwnerException;
import com.cg.frs.exceptions.MinimumDepositException;
import com.cg.frs.service.FlatRegistrationService;
import com.cg.frs.service.FlatRegistrationServiceImpl;

public class Client
{
	
    public static void main( String[] args )
    {
		 FlatRegistrationService flatRegistrationService=new FlatRegistrationServiceImpl();
		 Scanner sc=new Scanner(System.in);
		 FlatRegistrationDto flatRegistrationDto=new FlatRegistrationDto();
    	ArrayList<Integer> owner_ids=new ArrayList<Integer>();
    	System.out.println("====Menu==== \n1. Registration \n2. Exit");
    	int choice= sc.nextInt();
    	
    	if (choice==1) 
    	{
    		
    		owner_ids=flatRegistrationService.getAllOwnerIds();
    		System.out.println("Existing Owner IDs are:"+owner_ids);
	    	
	    	System.out.println("Please enter your owner id from above list:");
	    	int owner_id=sc.nextInt();
	    		if(owner_ids.contains(owner_id))
	    		{
		    			flatRegistrationDto.setOwner_id(owner_id);
	
		    	    	System.out.println("Select flat type(1-1bhk,2-2bhk):");
		    	    	int type=sc.nextInt();
		    	    	if(type==1  || type==2)
		    	    	{
		    	    		flatRegistrationDto.setFlat_type(type);
		    	    		System.out.println("Enter flat area in sq.ft:");
		    		    	flatRegistrationDto.setFlat_area(sc.nextInt());
		    		    	
		    		    	System.out.println("Enter desired rent amount:");
		    		    	flatRegistrationDto.setRent_amount(sc.nextDouble());
		    		    	
		    		    	System.out.println("Enter desired deposit amount:");
		    		    	double deposit=sc.nextDouble();
		    		    		if (deposit>flatRegistrationDto.getRent_amount())
		    		    		{
		    		    			flatRegistrationDto.setDeposit_amount(deposit);
		    		    			flatRegistrationDto=flatRegistrationService.registerFlat(flatRegistrationDto);
		    		    			System.out.println("Flat successfully registered. Registration Id :"+flatRegistrationDto.getFlat_reg_no());
		    					} 
		    		    		else {
		    						sc.close();
		    						try {
		    							throw new MinimumDepositException();
		    						} catch (MinimumDepositException e) {
		    							// TODO Auto-generated catch block
		    							e.printStackTrace();
		    						}
		    					}
		    		    		
		    	    	}
		    	    	else
		    	    	{
		    	    		try {
		    					throw new InvalidFlatTypeException();
		    				} catch (InvalidFlatTypeException e) {
		    					// TODO Auto-generated catch block
		    					e.printStackTrace();
		    				}
		    	    	}
	    			
	    		}
	    		else
	    		{
	    			try {
						throw new InvalidOwnerException();
					} catch (InvalidOwnerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    	
	    	
	    		
		} else if(choice==2) {
			sc.close();
			System.exit(0);
		}
		else
		{
			System.err.println("Enter a valid choice");
			
		}
    }

}

















