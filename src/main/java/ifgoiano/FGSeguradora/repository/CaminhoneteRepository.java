package ifgoiano.FGSeguradora.repository;

import ifgoiano.FGSeguradora.models.Caminhonete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CaminhoneteRepository extends JpaRepository<Caminhonete, Long> {

    @Query("SELECT obj FROM Caminhonete obj WHERE obj.chassi=:chassi")
    Caminhonete findByChassi(@Param("chassi") String chassi);
    @Query("SELECT obj FROM Caminhonete obj WHERE obj.placa=:placa")
    Caminhonete findByPlaca(@Param("placa") String placa);
}