package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {
    Optional<Gerente> findByUserName(String usuario);
}
