package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.User;
import ifgoiano.FGSeguradora.models.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String usuario);
}
