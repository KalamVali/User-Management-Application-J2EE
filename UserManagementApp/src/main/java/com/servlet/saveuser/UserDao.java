package com.servlet.saveuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	public int saveUser(User user)
	{
		int result = 0;
		//Get the connection
		
		
		try(Connection connection = DBConnectionUtils.createConnection();) 
		{
			PreparedStatement preparedStatement = connection.prepareStatement("insert into user_table values(?,?,?,?,?)");
			preparedStatement.setString(1, user.getUserId());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getUserEmail());
			preparedStatement.setString(4, user.getUserMobile());
			preparedStatement.setString(5, user.getUserLocation());
			result = preparedStatement.executeUpdate();	
		}
		catch(SQLException e)
		{    e.printStackTrace();
		}
		return result;
	}
	public User findById(String userId)
	{
		User user = null; 
		try(Connection connection = DBConnectionUtils.createConnection())
		{
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user_table where userId=?");
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{	user = new User();
				user.setUserId(resultSet.getString(1));
				user.setUserName(resultSet.getString(2));
				user.setUserEmail(resultSet.getString(3));
				user.setUserMobile(resultSet.getString(4));
				user.setUserLocation(resultSet.getString(5));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean loginUser(String userId,String userEmail)
	{
		boolean status = false;
		
		try(Connection connection = DBConnectionUtils.createConnection())
		{
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user_table where userId = ? and userEmail = ?");
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userEmail);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				status = true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	public List<User> findAll()
	{
		List<User> users = new ArrayList<User>();
		try(Connection connection = DBConnectionUtils.createConnection())
		{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user_table");
			while(resultSet.next())
			{
				User user = new User();
				user.setUserId(resultSet.getString(1));
				user.setUserName(resultSet.getString(2));
				user.setUserEmail(resultSet.getString(3));
				user.setUserMobile(resultSet.getString(4));
				user.setUserLocation(resultSet.getString(5));
				users.add(user);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return users;
	}
	
	public int deleteById(String userId)
	{
		int result = 0;
		try(Connection connection = DBConnectionUtils.createConnection())
		{
			PreparedStatement preparedStatement = connection.prepareStatement("delete from user_table where userId = ?");
			preparedStatement.setString(1, userId);
			
			result = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
