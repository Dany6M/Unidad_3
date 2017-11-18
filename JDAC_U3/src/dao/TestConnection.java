package dao;
import java.util.List;

import model.Boat;


public class TestConnection {
	public static void main(String [] args) {
		
		BoatDAOImpl boatDAOImpl = new BoatDAOImpl();
		boatDAOImpl.createBoat(new Boat(4L,"Titanic","Liverpool","Atlantic"));
		
		
		
		
	}
}
