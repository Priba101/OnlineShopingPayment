package repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import main.Mapiranje;
import main.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Mapiranje, Integer> {
	
	List<Mapiranje> findByTip(String tip);
	
}