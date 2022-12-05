package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Query("SELECT obj FROM Vendedor obj WHERE obj.cpf=:cpf")
    Vendedor findByCPF(@Param("cpf") String cpf);
}
