package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelRepository extends JpaRepository <Automovel, Long> {
}
