package dao;
import java.util.List;
import model.Boat;

public interface BoatDAO {
	
	void createBoat(Boat boat);
	
	Boat readBoat(Long id);
	
	List<Boat> readAllBoats();
	
	void updateBoat(Boat boat);
	
	void deleteBoat(Long id);
}
