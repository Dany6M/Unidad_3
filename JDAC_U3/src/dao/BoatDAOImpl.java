package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Boat;

public  class BoatDAOImpl implements BoatDAO{
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public BoatDAOImpl(){
		getConnetion();
	}
	
	public Connection getConnetion() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/testdb", "postgres", "1234");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	@Override
	public void createBoat(Boat boat) {
		try {
			if(connection != null) {
				preparedStatement = connection
						.prepareStatement("INSERT INTO boats (name,origin,route)"
								+ "VALUES(?,?,?);");
				preparedStatement.setString(1, boat.getName());
				preparedStatement.setString(2, boat.getOrigin());
				preparedStatement.setString(3, boat.getRoute());
				preparedStatement.execute();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Boat readBoat(Long id) {
		Boat boat = null;
		try {
			if(connection != null) {
				preparedStatement=connection
						.prepareStatement("SELECT * FROM boats WHERE id=?");
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					boat= new Boat(resultSet.getLong(1),resultSet.getString(2),
							resultSet.getString(3),resultSet.getString(4));
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return boat;
	}
	@Override
	public List<Boat> readAllBoats() {
		List<Boat> boats = new ArrayList<Boat>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM boats");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Boat boat = new Boat(
				
				resultSet.getLong(1),
				resultSet.getString(2),
				resultSet.getString(3),
				resultSet.getString(4));
				
				boats.add(boat);
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return boats;
	}
	@Override
	public void updateBoat(Boat boat) {
		try {
			if(connection != null) {
				preparedStatement=connection
						.prepareStatement("UPDATE boats SET name=?,origin=?,route=? "
								+ "WHERE id=?;");
				
				preparedStatement.setString(1, boat.getName());
				preparedStatement.setString(2, boat.getOrigin());
				preparedStatement.setString(3, boat.getRoute());
				preparedStatement.setLong(4, boat.getId());
				preparedStatement.execute();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteBoat(Long id) {
		if(connection != null) {
			try{
				preparedStatement=connection
						.prepareStatement("DELETE FROM boats WHERE id=?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
