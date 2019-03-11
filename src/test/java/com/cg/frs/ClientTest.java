package com.cg.frs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.frs.Client;

import junit.framework.TestCase;

public class ClientTest extends TestCase {

	static Client client;
	@BeforeAll
	public static void init()
	{
		client=new Client();
	}
	
	@Test
	void testMain()
	{
		
	}
	
}
