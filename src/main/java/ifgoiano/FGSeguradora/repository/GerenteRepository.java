package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {
    @Query("SELECT obj FROM Gerente obj WHERE obj.cpf=:cpf")
    Gerente findByCPF(@Param("cpf") String cpf);

}
