package com.cg.frs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.frs.dto.FlatRegistrationDto;
import com.cg.frs.utility.DataConnection;

public class FlatRegistrationDaoImpl implements FlatRegistrationDao{
	DataConnection dataConnection=new DataConnection();
	

	public FlatRegistrationDto registerFlat(FlatRegistrationDto flat) {
		
		
		try {
			Connection connection=dataConnection.connect();
			PreparedStatement preparedStatement=connection.prepareStatement("insert into flat_registration(owner_id,flat_type,flat_area,rent_amount,deposit_amount) values(?,?,?,?,?)");
			
			preparedStatement.setInt(1, flat.getOwner_id());
			preparedStatement.setInt(2, flat.getFlat_type());
			preparedStatement.setInt(3, flat.getFlat_area());
			preparedStatement.setDouble(4, flat.getRent_amount());
			preparedStatement.setDouble(5, flat.getDeposit_amount());
		
			int i=preparedStatement.executeUpdate();
			
			PreparedStatement preparedStatement2=connection.prepareStatement("select * from flat_registration where owner_id=?");
			preparedStatement2.setInt(1,flat.getOwner_id());
			
			ResultSet resultSet=preparedStatement2.executeQuery();
			while(resultSet.next())
			{
				flat.setFlat_reg_no(resultSet.getInt(1));
			}
			if(i==1)
				return flat;
			else
				flat=null;
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flat;
	}

	public ArrayList<Integer> getAllOwnerIds() {
		
		ArrayList<Integer> owner_ids=new ArrayList<Integer>();
		
		try {
			Connection connection=dataConnection.connect();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from flat_owners");
			
			while(resultSet.next())
			{
				owner_ids.add(resultSet.getInt(1));
			}
			
			connection.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return owner_ids;
	}

}
