package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Gerente;
import ifgoiano.FGSeguradora.models.Terceirizado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TerceirizadoRepository  extends JpaRepository<Terceirizado,Long> {
    Optional<Terceirizado> findByUserName(String usuario);

}
