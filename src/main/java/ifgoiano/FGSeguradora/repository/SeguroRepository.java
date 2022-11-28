package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguroRepository extends JpaRepository<Seguro, Long> {
}
