package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
