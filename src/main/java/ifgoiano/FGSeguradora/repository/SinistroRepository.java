package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Sinistro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinistroRepository extends JpaRepository<Sinistro, Long> {
}
