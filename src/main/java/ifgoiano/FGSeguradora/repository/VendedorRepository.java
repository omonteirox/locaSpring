package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Gerente;
import ifgoiano.FGSeguradora.models.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendedorRepository extends JpaRepository<Vendedor,Long> {
    Optional<Vendedor> findByUserName(String usuario);

}
