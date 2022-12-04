package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT obj FROM Cliente obj WHERE obj.cpf=:cpf")
    Cliente findByCPF(@Param("cpf") String cpf);
}
