package dao;
import java.util.List;
import model.Creator;

public interface CreatorDAO {
	void createCreator(Creator creator);
	
	Creator readCreator(Long id);
	
	List<Creator> readAllCreators();
	
	void updateCreator(Creator creator);
	
	void deleteCreator(Long id);

}
