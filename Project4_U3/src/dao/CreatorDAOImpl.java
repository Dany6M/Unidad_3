package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Creator;

public class CreatorDAOImpl implements CreatorDAO{
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public CreatorDAOImpl() {
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
	public void createCreator(Creator creator) {
		try {
			if(connection != null) {
				preparedStatement = connection
						.prepareStatement("INSERT INTO creators (name,last_name,filiation,area)"
								+ "VALUES(?,?,?,?);");
				preparedStatement.setString(1, creator.getName());
				preparedStatement.setString(2, creator.getLastName());
				preparedStatement.setString(3, creator.getFiliation());
				preparedStatement.setString(4, creator.getArea());
				preparedStatement.execute();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Creator readCreator(Long id) {
		Creator creator = null;
		try {
			if(connection != null) {
				preparedStatement=connection
						.prepareStatement("SELECT * FROM creators WHERE id=?");
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					creator = new Creator(resultSet.getLong(1),resultSet.getString(2),
							resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return creator;
	}

	@Override
	public List<Creator> readAllCreators() {
		List<Creator> creators = new ArrayList<Creator>();
		try {
			preparedStatement = connection
					.prepareStatement("SELECT * FROM creators");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Creator creator = new Creator(
						
						resultSet.getLong(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5));
				
				creators.add(creator);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return creators;
	}

	@Override
	public void updateCreator(Creator creator) {
		try {
			if(connection != null) {
				preparedStatement = connection
						.prepareStatement("UPDATE creators SET name=?,last_name=?,filiation=?,area=?"
								+ "WHERE id=?;");
				preparedStatement.setString(1, creator.getName());
				preparedStatement.setString(2, creator.getLastName());
				preparedStatement.setString(3, creator.getFiliation());
				preparedStatement.setString(4, creator.getArea());
				preparedStatement.setLong(5, creator.getId());
				preparedStatement.execute();
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCreator(Long id) {
		if(connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("DELETE FROM creators WHERE id=?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
