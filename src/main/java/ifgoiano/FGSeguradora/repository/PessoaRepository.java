package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Gerente;
import ifgoiano.FGSeguradora.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa> findByUserName(String usuario);

}
