package backend.login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>
{
	@Query(value = "SELECT * FROM USER_AUTH t WHERE t.USERNAME=:username", nativeQuery = true)
	Optional<User> findByUsername(String username);
}
