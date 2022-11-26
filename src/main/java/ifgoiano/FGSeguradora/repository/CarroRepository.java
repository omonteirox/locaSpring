package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
